package it.corso.eng.esempiohtml.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {
	
	
	@GetMapping("/ciao")
	public String ciao( Model model ) {
		Random random = new Random();
		int i=0;
		
		List<String> lista = new ArrayList<>();
		lista.add( ""+i );
		
		model.addAttribute("valore " + i , random.nextInt(90));
		return "home";
	}
	

}
