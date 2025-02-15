package com.OfBusiness.task.service;


import com.OfBusiness.task.entity.Employee;
import com.OfBusiness.task.payload.EmployeeVO;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> getEmployees();
    Employee createEmployee(EmployeeVO req);
    Boolean deleteEmployee(Long id);
    Optional<Employee> getEmployee(Long id);
    Optional<Employee> updateEmlpoyee(EmployeeVO req);
}
