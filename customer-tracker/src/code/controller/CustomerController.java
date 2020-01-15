package code.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import code.dao.CustomerDAO;
import code.orm.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerDAO customerService;

	public CustomerController(CustomerDAO customerService) {
		this.customerService = customerService;
	}

	@RequestMapping("/list")
	public String listCustomers(Model theModel) {

		List<Customer> customerList = customerService.getCustomers();
		theModel.addAttribute("customers", customerList);
		return "list-customers";
	}

}
