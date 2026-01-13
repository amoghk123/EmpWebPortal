package com.example.empwebapp.controller;

import com.example.empwebapp.model.Employee;
import com.example.empwebapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeRepository repo;

    @GetMapping("/")
    public String viewHome(Model model) {
        model.addAttribute("employees", repo.findAll());
        return "index";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Employee employee) {
        repo.save(employee);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        repo.deleteById(id);
        return "redirect:/";
    }

}
