package br.com.ntendencia.springApi.service;

import br.com.ntendencia.springApi.helper.JsonHelper;
import br.com.ntendencia.springApi.helper.Mensagem;
import br.com.ntendencia.springApi.model.entity.Contratacao;
import br.com.ntendencia.springApi.model.entity.ContratacaoDTO;
import br.com.ntendencia.springApi.model.entity.Endereco;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.awspring.cloud.sqs.annotation.SqsListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;

@Service
public class SqsSender {
    @Autowired
    private SqsClient sqsClient;
    @Autowired
    private ContratacaoService contratacaoService;
    @Autowired
    private ConsultaCEP consultaCep;
    private final String queueUrl = "http://sqs.us-east-1.localhost.localstack.cloud:4566/000000000000/localstack-queue";

    public void sendMessage(String message) {
        sqsClient.sendMessage(SendMessageRequest.builder()
                .queueUrl(queueUrl)
                .messageBody(message)
                .delaySeconds(5)
                .build());
    }

    @SqsListener(value = {"${spring.cloud.sqs.contratacao}"})
    public void lerMensagensContratacao(Message<Mensagem> message) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Contratacao contratacao = objectMapper.readValue(message.getPayload().body(), Contratacao.class);

        contratacaoService.insert(contratacao);

        System.out.println("Contratação inserida: " + JsonHelper.embrulhar(new ContratacaoDTO(contratacao.getCpfCnpj(), contratacao.getCep())));
    }

    @SqsListener(value = {"${spring.cloud.sqs.cep}"})
    public void lerMensagensCep(Message<Mensagem> message) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Contratacao contrato = objectMapper.readValue(message.getPayload().body(), Contratacao.class);

        Endereco endereco = consultaCep.consultaCep(contrato.getCep());
        System.out.println(endereco.toString());

    }
}
