package com.example.onlinepracticaltest.controller;

import com.example.onlinepracticaltest.model.Customer;
import com.example.onlinepracticaltest.model.Emi;
import com.example.onlinepracticaltest.service.CustomerService;
import com.example.onlinepracticaltest.service.EmiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(path = "")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private EmiService emiService;

    @InitBinder
    public void InitBinder(WebDataBinder data) {
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        data.registerCustomEditor(Date.class, new CustomDateEditor(s, true));
    }

    @RequestMapping(path = "/")
    public String getAllCustomer(Model model) {
        List<Customer> list = customerService.getAllCustomer();
        model.addAttribute("list", list);
        return "customer";
    }

    @RequestMapping(path = "/add")
    public String insertCustomer(Model model) {
        Customer customer = new Customer();
        model.addAttribute("custNew", customer);
        return "insertCust";
    }

    @RequestMapping(path = "/saveCust", method = RequestMethod.POST)
    public String saveCustomer(@ModelAttribute("custNew") Customer customer, Model model) {
        boolean bl = customerService.saveCustomer(customer);
        if (bl) {
            return "redirect:/?success=insert success";
        }
        return "redirect:/?error=insert failed";
    }

    @RequestMapping(path = "emi")
    public String getEmiByCust(@RequestParam("id") Integer custId, Model model) {
        List<Emi> list = emiService.getEmiByCust(custId);
        model.addAttribute("listEmi", list);

        return "getEmiById";
    }
}
