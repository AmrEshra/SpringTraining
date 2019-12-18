package code.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/helloWorldController")
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
		theName = "processForm2 " + theName.toUpperCase();
		
		model.addAttribute("message2" , theName);
		return "helloworld";
	}
	
	@RequestMapping("/processForm3")
	public String processForm3(
			@RequestParam("studentName") String studentName,
			Model model) {
		
		String theName = studentName;
		theName = "processForm3 " + theName.toUpperCase();
		
		model.addAttribute("message3" , theName);
		return "helloworld";
	}
		
}






