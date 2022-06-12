package com.petarjk.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.petarjk.spring.entity.Customer;
import com.petarjk.spring.entity.SalesRepresentative;
import com.petarjk.spring.service.CustomerService;
import com.petarjk.spring.service.SalesRepService;

@Controller
@RequestMapping("/salesRep")
public class SalesRepController {

	@Autowired
	private SalesRepService salesRepService;

	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String listSalesReps(Model theModel) {

		List<SalesRepresentative> theSalesRepresentatives = salesRepService.getSalesRepresentatives();

		theModel.addAttribute("salesReps", theSalesRepresentatives);

		return "list-sales-reps";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		SalesRepresentative theSalesRepresentative = new SalesRepresentative();

		theModel.addAttribute("salesRep", theSalesRepresentative);

		return "sales-rep-form";
	}

	@PostMapping("/saveSalesRep")
	public String saveSalesRep(@ModelAttribute("salesRep") SalesRepresentative theSalesRepresentative) {

		salesRepService.saveSalesRep(theSalesRepresentative);

		return "redirect:/salesRep/list";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("salesRepId") int theId, Model theModel) {

		SalesRepresentative theSalesRepresentative = salesRepService.getSalesRepresentative(theId);

		theModel.addAttribute("salesRep", theSalesRepresentative);

		return "sales-rep-form";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("salesRepId") int theId) {

		salesRepService.delete(theId);

		return "redirect:/salesRep/list";
	}

	@GetMapping("/search")
	public String searchSalesReps(@RequestParam("theSearchName") String theSearchName, Model theModel) {

		List<SalesRepresentative> theSalesRepresentatives = salesRepService.searchSalesRep(theSearchName);

		theModel.addAttribute("salesReps", theSalesRepresentatives);

		return "list-sales-reps";
	}

	@GetMapping("/viewAllCustomers")
	public String viewAllCustomers() {

		return "redirect:/customer/list";
	}

	@GetMapping("/listAssignedCustomers")
	public String listAssignedCustomers(@RequestParam("salesRepId") int theSalesRepId, Model theModel) {

		List<Customer> theCustomers = salesRepService.listAssignedCustomers(theSalesRepId);

		theModel.addAttribute("customers", theCustomers);

		return "assigned-customers";
	}

	@GetMapping("/showFormForAsign")
	public String showFormForAsign(Model theModel) {

		List<Customer> theCustomers = customerService.getCustomers();

		theModel.addAttribute("customers", theCustomers);

		return "assign-customer-form";
	}

	@GetMapping("/assignCustomer")
	public String assignCustomer(@RequestParam("customerId") int theCustomerId) {

		salesRepService.assignCustomer(theCustomerId);

		return "redirect:/salesRep/showFormForAsign";
	}

	@GetMapping("/unassignCustomer")
	public String unassignCustomer(@RequestParam("customerId") int theCustomerId) {

		salesRepService.unassignCustomer(theCustomerId);

		return "redirect:/salesRep/showFormForAsign";
	}
}
