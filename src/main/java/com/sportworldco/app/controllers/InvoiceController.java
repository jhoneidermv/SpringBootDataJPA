package com.sportworldco.app.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sportworldco.app.models.entity.Customer;
import com.sportworldco.app.models.entity.Invoice;
import com.sportworldco.app.models.entity.Product;
import com.sportworldco.app.models.service.ICustomerService;

@Controller
@RequestMapping("/invoice")
//El mismo nombre "factura" con el cual se pasa a la vista
@SessionAttributes("factura")
public class InvoiceController {
	
	@Autowired
	private ICustomerService iCustomerService;
	
	@GetMapping(value = "/form/{id}")
	public String createInvoice(@PathVariable (value = "id") Long id,
			Map <String, Object> model,
			RedirectAttributes flash) {
		
		Customer customer = iCustomerService.findOne(id);
		if(customer == null) {
			flash.addAttribute("error", "No se ha encontrado un cliente con este ID");
			return "redirect:/tolis";
		}
		
		Invoice invoice = new Invoice();
		invoice.setCustomer(customer);
		model.put("invoice", invoice);
		model.put("title", "Crear factura");
		return "invoice/form";
	}
	
	@GetMapping(value = "/load-products/{term}", produces = {"application/json"})
	public @ResponseBody List<Product> loadProducts(@PathVariable(name = "term") String term) {
		return iCustomerService.findByName(term);
	}
}
