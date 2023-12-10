package com.riteship.crs.company.microservice.controller;

import com.riteship.crs.company.microservice.convertor.CompanyDataBeanConvertor;
import com.riteship.crs.company.microservice.dtos.CompanyDataBeanDTO;
import com.riteship.crs.company.microservice.entities.CompanyDataBean;
import com.riteship.crs.company.microservice.impl.RiteShipCompanyServiceBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/riteship")
public class RiteShipCompanyRestController {

    /*@Autowired
    private RiteShipCompanyDBOperationsBean CompanyDBOperationsBean;*/

    @Autowired
    private RiteShipCompanyServiceBean<CompanyDataBean, Integer> companyServiceBean;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/companies/getAll")
    public @ResponseBody List<CompanyDataBeanDTO> getAllCompanies() {
        return CompanyDataBeanConvertor.convertCompanyDataListToCompanyDataBean(companyServiceBean.getAllCompany(0));
    }

    @PutMapping("/companies/save-company")
    public @ResponseBody String saveCompany(CompanyDataBeanDTO companyData) {
        companyServiceBean.saveCompany((HashMap)CompanyDataBeanConvertor.getMapOfCompanyDataFromCompanyDataBean(companyData));
        return "Success";
    }

    @GetMapping("/companies/get-company")
    public @ResponseBody CompanyDataBeanDTO getCompanyDetails(int company_id) {
        return CompanyDataBeanConvertor.getCompanyDataBeanDTOFromDataMap(companyServiceBean.getCompanyDetails(company_id));
    }

    @PatchMapping("/companies/update-company")
    public @ResponseBody String updateCompany(CompanyDataBeanDTO companyData) {
        return companyServiceBean.updateCompany((HashMap)CompanyDataBeanConvertor.getMapOfCompanyDataFromCompanyDataBean(companyData));
    }
}
