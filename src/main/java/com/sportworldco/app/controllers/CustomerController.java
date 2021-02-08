package com.sportworldco.app.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sportworldco.app.models.entity.Customer;
import com.sportworldco.app.models.service.ICustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	private ICustomerService iCustomerService;
	
	@GetMapping(value = "/view/{id}")
	public String viewCustomer(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash ) {
		Customer customer = iCustomerService.findOne(id);
		if(customer == null) {
			flash.addAttribute("error", "No fue encontrado un cliente con este ID");
			return "redirect:/tolist";
		}
		model.put("customer", customer);
		model.put("title", "Detalle cliente: " + customer.getName());
		return "view";
	}

	@RequestMapping(value = "/tolist", method = RequestMethod.GET)
	public String toList(Model model) {
		model.addAttribute("title", "Listado de clientes");
		model.addAttribute("customers", iCustomerService.findAll());
		return "toList";
	}
	
	@RequestMapping(value = "/form")
	public String create(Map<String, Object> model) {
		Customer customer = new Customer();
		model.put("customer", customer);
		model.put("title", "Formulario de Cliente");
		return "form";
		
	}
	
	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String saveCustomer(@Valid Customer customer, BindingResult result, Model model, RedirectAttributes flash) {
		if(result.hasErrors()) {
			model.addAttribute("title", "Formulario de Cliente");
			return "form";
		}
		
		String mensajeFlash = (customer.getId() != null)?"Cliente editado exitosamente" : "Cliente agregado exitosamente";
		
		iCustomerService.save(customer);
		flash.addFlashAttribute("success",mensajeFlash);
		return "redirect:/tolist";
	}
	
	@RequestMapping(value = "/form/{id}")
	public String editCustomer(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {
		Customer customer = null;
		if(id > 0) {
			customer = iCustomerService.findOne(id);
			if(customer == null) {
				flash.addFlashAttribute("error","El id del cliente no existe en la base de datos");
				return "redirect:/tolist";
			}
		} else {
			flash.addFlashAttribute("error","El id del cliente no puede ser cero!");
			return "redirect:/tolist";
		}
		model.put("customer", customer);
		model.put("title", "Formulario de Cliente");
		return "form";
	}
	
	@RequestMapping(value = "/delete/{id}")
	public String deleteCustomer(@PathVariable(value = "id") Long id, RedirectAttributes flash) {
		if(id > 0) {
			iCustomerService.delete(id);
			flash.addFlashAttribute("seccess","Cliente eliminado con éxito");
		} 
		return "redirect:/tolist";
	}
	
	
}
