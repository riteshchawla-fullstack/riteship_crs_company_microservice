package com.riteship.crs.company.microservice.convertor;

import com.riteship.crs.company.microservice.dtos.CompanyDataBeanDTO;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompanyDataBeanConvertor {

    public static List<CompanyDataBeanDTO> convertCompanyDataListToCompanyDataBean(ArrayList CompanyDataList) {
        List<CompanyDataBeanDTO> companyDataBeanDTOS = new ArrayList<>();
        if(!CollectionUtils.isEmpty(CompanyDataList)) {
            CompanyDataList.stream().forEach(data -> {
                if(data != null) {
                    HashMap companyData = (HashMap) data;
                    if(!CollectionUtils.isEmpty(companyData)) {
                        CompanyDataBeanDTO companyDataBeanDTO = getCompanyDataBeanDTOFromDataMap(companyData);
                        if(companyDataBeanDTO != null) {
                            companyDataBeanDTOS.add(companyDataBeanDTO);
                        }
                    }
                }
            });
        }
        return companyDataBeanDTOS;
    }

    public static CompanyDataBeanDTO getCompanyDataBeanDTOFromDataMap(HashMap CompanyData) {
        CompanyDataBeanDTO companyDataBeanDTO = null;
        if(!CollectionUtils.isEmpty(CompanyData)) {
            companyDataBeanDTO = new CompanyDataBeanDTO();
            companyDataBeanDTO.setCompanyCity((String)CompanyData.get("company_city"));
            companyDataBeanDTO.setCompanyState((String)CompanyData.get("company_state"));
            companyDataBeanDTO.setCompanyCountry((String)CompanyData.get("company_country"));
            companyDataBeanDTO.setCompanyMobile((String)CompanyData.get("company_mobile"));
            companyDataBeanDTO.setCompanyAddress((String)CompanyData.get("company_address"));
            companyDataBeanDTO.setCompanyId(Integer.valueOf((String)CompanyData.get("company_id")));
            companyDataBeanDTO.setCompanyDescription((String)CompanyData.get("company_email"));
            companyDataBeanDTO.setCompanyEmail((String)CompanyData.get("company_description"));
            companyDataBeanDTO.setCompanyWebsite((String)CompanyData.get("company_website"));
            companyDataBeanDTO.setCompanyImage((String)CompanyData.get("company_image"));
            companyDataBeanDTO.setCompanyName((String)CompanyData.get("company_name"));
            companyDataBeanDTO.setCompanyPassword((String)CompanyData.get("company_password"));

        }
        return companyDataBeanDTO;
    }

    public static Map<String, String> getMapOfCompanyDataFromCompanyDataBean(CompanyDataBeanDTO companyDataBeanDTO) {
        Map<String, String> result = new HashMap<>();
        if(companyDataBeanDTO != null) {
            result.put("company_id", String.valueOf(companyDataBeanDTO.getCompanyId()));
            result.put("company_state", companyDataBeanDTO.getCompanyState());
            result.put("company_country", companyDataBeanDTO.getCompanyCountry());
            result.put("company_mobile", companyDataBeanDTO.getCompanyMobile());
            result.put("company_address", companyDataBeanDTO.getCompanyAddress());
            result.put("company_id", String.valueOf(companyDataBeanDTO.getCompanyId()));
            result.put("company_email", companyDataBeanDTO.getCompanyEmail());
            result.put("company_description", companyDataBeanDTO.getCompanyDescription());
            result.put("company_website", companyDataBeanDTO.getCompanyWebsite());
            result.put("company_image", companyDataBeanDTO.getCompanyImage());
            result.put("company_city", companyDataBeanDTO.getCompanyCity());
            result.put("company_name", companyDataBeanDTO.getCompanyName());
        }
        return result;
    }
}
