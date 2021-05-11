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
@RequestMapping(path = "emi")
public class EmisController {
    @Autowired
    private EmiService emiService;

    @Autowired
    private CustomerService customerService;

    @InitBinder
    public void InitBinder(WebDataBinder data) {
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        data.registerCustomEditor(Date.class, new CustomDateEditor(s, true));
    }

    @RequestMapping(path = "/")
    public String insertEmi(Model model) {
        Emi emi = new Emi();
        model.addAttribute("emiNew", emi);
        List<Customer> listCust = customerService.getAllCustomer();
        model.addAttribute("listCust", listCust);
        return "insertEmi";
    }

    @RequestMapping(path = "saveEmi", method = RequestMethod.POST)
    public String saveEmi(@ModelAttribute("emiNew") Emi emi) {
        emi.setStatus("active");
        emi.setEmi_total(emiAmount(emi.getLoan_amount(), emi.getRate_of_interest(), emi.getRate_of_interest()));
        boolean bl = emiService.saveEmi(emi);
        if (bl) {
            return "redirect:/?success=insert success";
        }
        return "redirect:/emi?error=insert failed";
    }

    @RequestMapping(path = "/detail")
    public String detailEmi(@RequestParam("id") Integer id, Model model) {

        return "";
    }

    public double emiAmount(double l, double r, double n) {
        double total = 0;
        total = l * r / 12 * ((l + r) * n / (l + r) * n - 1);

        return total;
    }
}