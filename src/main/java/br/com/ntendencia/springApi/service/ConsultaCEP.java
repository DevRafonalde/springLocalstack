package br.com.ntendencia.springApi.service;

import br.com.ntendencia.springApi.model.entity.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "consultaCep", url = "${consulta.consultaCep.url}")
public interface ConsultaCEP {

    @GetMapping("/{cep}/json")
    Endereco consultaCep(@PathVariable String cep);
}
