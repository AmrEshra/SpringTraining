package code.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

	// need a controller method to show the initial HTML form
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
		
	// need a controller method to process the HTML form
	
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	@RequestMapping("/processForm2")
	public String processForm2(HttpServletRequest request, Model model) {
		
		String theName = request.getParameter("studentName");
		theName = theName.toUpperCase();
		
		model.addAttribute("message" , theName);
		return "helloworld";
	}
		
}






