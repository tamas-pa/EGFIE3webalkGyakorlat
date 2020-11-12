package hu.egfie3.springbootweb;

import org.springframework.web.bind.annotation.GetMapping;

public class HelloSpringBoot {

	@GetMapping
	public void index() {
		System.out.println("Hello spring boot web");
	}
}
