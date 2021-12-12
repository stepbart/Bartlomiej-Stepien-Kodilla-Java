package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CompanyFacadeTestSuite {

    @Autowired
    private CompanyFacade companyFacade;

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    void testSearchingCompanyByFragmentOfName() {

        //Given
        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        //When
        List<Company> aestName = new ArrayList<>();
        List<Company> chineName = new ArrayList<>();
        List<Company> testName = new ArrayList<>();
        try {
            aestName = companyFacade.searchCompany("aest");
            chineName = companyFacade.searchCompany("chine");
            testName = companyFacade.searchCompany("test123");
        } catch (SearchingException e) {
            e.getMessage();
        }

        //Then
        assertEquals(1, aestName.size());
        assertEquals(1, chineName.size());
        assertEquals(0, testName.size());

        //CleanUp
        try {
            companyDao.deleteById(softwareMachineId);
            companyDao.deleteById(dataMaestersId);
            companyDao.deleteById(greyMatterId);
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    void testSearchingEmployeeByFragmentOfName() {

        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        employeeDao.save(johnSmith);
        int johnSmithId = johnSmith.getId();
        employeeDao.save(stephanieClarckson);
        int stephanieClarcksonId = stephanieClarckson.getId();
        employeeDao.save(lindaKovalsky);
        int lindaKovalskyId = lindaKovalsky.getId();

        //When
        List<Employee> ithName = new ArrayList<>();
        List<Employee> aName = new ArrayList<>();
        List<Employee> testName = new ArrayList<>();
        try {
            ithName = companyFacade.searchEmployee("ith");
            aName = companyFacade.searchEmployee("a");
            testName = companyFacade.searchEmployee("test123");
        } catch (SearchingException e) {
            e.getMessage();
        }

        //Then
        assertEquals(1, ithName.size());
        assertEquals(2, aName.size());
        assertEquals(0, testName.size());

        //CleanUp
        try {
            employeeDao.deleteById(johnSmithId);
            employeeDao.deleteById(stephanieClarcksonId);
            employeeDao.deleteById(lindaKovalskyId);
        } catch (Exception e) {
            //do nothing
        }
    }

}
