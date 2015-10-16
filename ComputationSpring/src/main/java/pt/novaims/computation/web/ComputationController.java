package pt.novaims.computation.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ComputationController {

	
	@RequestMapping("/game")
	public String game(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
		System.err.println("Test");
		return "game";

	}

}
