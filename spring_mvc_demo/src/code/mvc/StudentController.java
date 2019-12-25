package code.mvc;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import code.mvc.model.Student;

@Controller
@RequestMapping("/studentController")
public class StudentController {

	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult) {

		if (bindingResult.hasErrors())
			return "student-form";

		else {
			System.out.println(student.getFirstName() + " " + student.getLastName() + " from " + student.getCountry());
			System.out.println(student.getGender());
			return "student-confirmation";
		}
	}

	@RequestMapping("/showForm")
	public String showform(Model theModel) {

		List<String> countryList = new ArrayList<>();
		countryList.add("Egypt");
		countryList.add("USA");
		countryList.add("UAE");
		countryList.add("Germany");
		countryList.add("Qatar");
		theModel.addAttribute("countries", countryList);

		Student theStudent = new Student();
		theModel.addAttribute("student", theStudent);

		return "student-form";
	}

}
