package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class CompanyFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyFacade.class);

    @Autowired
    CompanyDao companyDao;

    @Autowired
    EmployeeDao employeeDao;

    public List<Company> searchCompany(String companyName) throws SearchingException {
        List<Company> companiesByNames = companyDao.getCompanyByName("%"+companyName+"%");
        if (companiesByNames.size()==0){
            LOGGER.error(SearchingException.ERR_NO_COMP_FOUND);
            throw new SearchingException(SearchingException.ERR_NO_COMP_FOUND);
        }
        return companiesByNames;
    }

    public List<Employee> searchEmployee(String employeeName) throws SearchingException {
        List<Employee> employeesByNames = employeeDao.getEmployeesByName("%"+employeeName+"%");
        if (employeesByNames.size()==0){
            LOGGER.error(SearchingException.ERR_NO_EMPL_FOUND);
            throw new SearchingException(SearchingException.ERR_NO_EMPL_FOUND);
        }
        return employeesByNames;
    }
}
