package com.OfBusiness.task.service.impl;

import com.OfBusiness.task.entity.Employee;
import com.OfBusiness.task.payload.EmployeeVO;
import com.OfBusiness.task.repository.EmployeeDAO;
import com.OfBusiness.task.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    public List<Employee> getEmployees() {
        return employeeDAO.findAll();
    }


    @Override
    public Employee createEmployee(EmployeeVO req) {
        Employee e = new Employee();
        try {
            String fname = req.getLastName();
            String lname = req.getLastName();
            String email = req.getEmail();

            e.setFirstName(fname);
            e.setLastName(lname);
            e.setEmail(email);
            e = employeeDAO.save(e);

        }catch (Exception ex){

        }
        return e;
    }

    @Override
    public Boolean deleteEmployee(Long id) {
        Optional<Employee> e = employeeDAO.findById(id);
        if(e.isPresent()){
            employeeDAO.delete(e.get());
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Optional<Employee> getEmployee(Long id) {
        Optional<Employee> e = employeeDAO.findById(id);
        if (e.isPresent()) {
            return e;
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Employee> updateEmlpoyee(EmployeeVO req) {
        Optional<Employee> e = employeeDAO.findById(req.getEmployeeID());
        if(!e.isEmpty() && e.isPresent()) {
            Employee updatedEmployee = e.get();
            updatedEmployee.setLastName(req.getLastName());
            updatedEmployee.setFirstName(req.getFirstName());
            updatedEmployee.setEmail(req.getEmail());
            employeeDAO.save(updatedEmployee);
            e = Optional.of(updatedEmployee);
            return e;
        }else
            return Optional.empty();
    }
}
