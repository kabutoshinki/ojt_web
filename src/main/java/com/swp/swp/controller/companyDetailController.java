package com.swp.swp.controller;

import com.swp.swp.model.CompanyDetail;
import com.swp.swp.repositories.CompanyDetailRepositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import antlr.collections.List;

@Controller
@RequestMapping(path = "listCompany")
public class companyDetailController {
    @Autowired CompanyDetailRepositories repositories;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String displayCompany(ModelMap modelMap){
        Iterable<CompanyDetail> list = repositories.findAll();
        modelMap.addAttribute("companyList", list);
        return "companyList";
    }
}
