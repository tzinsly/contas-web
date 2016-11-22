package br.com.caelum.contas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorld {
	
	//http://blog.globalcode.com.br/2012/02/json-facil-em-java-com-gson.html
	//http://pro.jsonlint.com
	@RequestMapping("/HelloWorldSpring")
	public String execute(){
		System.out.println("My first method using MVC");
		return "hello/ok";
	}

}
