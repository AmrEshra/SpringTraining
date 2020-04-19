package code.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import code.orm.Customer;
import code.services.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String listCustomers(Model theModel) {

		List<Customer> customerList = customerService.getCustomers();
		theModel.addAttribute("customers", customerList);
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Customer theCustomer = new Customer();
		
		theModel.addAttribute("customer", theCustomer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		// save the customer using our service
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}
	
	/*@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customer") Customer theCustomer) {
		
		// delete the customer
		customerService.deleteCustomer(theCustomer);
		
		return "redirect:/customer/list";
	}*/
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") Long theId) {
		
		// delete the customer
		customerService.deleteCustomer(customerService.getCustomerById(theId));
		
		return "redirect:/customer/list";
	}

}
