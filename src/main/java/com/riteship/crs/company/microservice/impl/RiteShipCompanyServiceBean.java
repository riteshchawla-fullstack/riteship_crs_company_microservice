package com.riteship.crs.company.microservice.impl;

import com.riteship.common.apis.services.impls.RiteShipGeneralServiceImpl;
import com.riteship.crs.company.microservice.RiteShipCompanyDBOperationsBean;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class RiteShipCompanyServiceBean<CollegeDataBean, Integer> extends RiteShipGeneralServiceImpl<CollegeDataBean, Integer> {

        @PostConstruct
        public void initializeBean() {
            setRiteShipDatabaseOperationsBean(new RiteShipCompanyDBOperationsBean().getDatabaseOperationsBean());
        }

}
