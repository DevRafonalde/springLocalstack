package br.com.ntendencia.springApi.helper;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.io.StringWriter;

@Log4j2
public class JsonHelper {
    public static String embrulhar(Object object) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        StringWriter stringWriter = new StringWriter();
        objectMapper.writeValue(stringWriter, object);
        return stringWriter.toString();
    }

    public static Object desembrulhar(String json, Class type) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(json, type);
        } catch (IOException ex) {
            log.error(ex.getMessage());
        }
        return null;
    }
}
