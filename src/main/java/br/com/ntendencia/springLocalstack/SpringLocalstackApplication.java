package br.com.ntendencia.springLocalstack;

import br.com.ntendencia.springLocalstack.service.ContratacaoService;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringLocalstackApplication {

	@Autowired
	ContratacaoService contratacaoService;

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringLocalstackApplication.class, args);
		ContratacaoService employeeService = context.getBean(ContratacaoService.class);
	}

}
