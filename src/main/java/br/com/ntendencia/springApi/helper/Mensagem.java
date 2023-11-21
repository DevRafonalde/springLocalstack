package br.com.ntendencia.springApi.helper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Mensagem(
        @JsonProperty("MessageId")
        String messageId,
        @JsonProperty("Message")
        String body
) {
}