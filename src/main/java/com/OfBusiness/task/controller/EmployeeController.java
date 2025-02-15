package com.OfBusiness.task.controller;

import com.OfBusiness.task.entity.Employee;
import com.OfBusiness.task.payload.EmployeeVO;
import com.OfBusiness.task.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController  {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<?> getEmployees(){
        List<Employee> employees = new ArrayList<>();
        employees = employeeService.getEmployees();
        if(employees.size() == 0)
            return new ResponseEntity<>(employees, HttpStatus.OK);
        else
            return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> createEmployee(@RequestBody @Valid EmployeeVO req, BindingResult bindingResult){
        try{
            if(bindingResult.hasErrors()){
                FieldError er = bindingResult.getFieldErrors().get(0);
                Map<String, String> erromap = new HashMap<>();
                erromap.put("message", er.getDefaultMessage());
                return new ResponseEntity<>(erromap, HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(employeeService.createEmployee(req), HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;


    }

    @DeleteMapping("/delete/{employeeId}")
    public ResponseEntity<?> createEmployee(@PathVariable(name = "employeeId") Long employeeId){
        Boolean response = employeeService.deleteEmployee(employeeId);
        if(response != null && response)
            return new ResponseEntity<>("Employee data deleted successfully", HttpStatus.OK);
        else
            return new ResponseEntity<>("Employee with mentioned ID not found", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<?> getEmployee(@PathVariable(name = "employeeId") Long employeeId){
         Optional<Employee> employee = employeeService.getEmployee(employeeId);
        if(!employee.isEmpty() && employee.isPresent())
            return new ResponseEntity<>(employee.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>("Employee with mentioned ID not found", HttpStatus.NOT_FOUND);
    }

    @PatchMapping("/update")
    public ResponseEntity<?> updateEmployee(@Valid @RequestBody EmployeeVO req, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            FieldError er = bindingResult.getFieldErrors().get(0);
            Map<String, String> erromap = new HashMap<>();
            erromap.put("message", er.getDefaultMessage());
            return new ResponseEntity<>(erromap, HttpStatus.BAD_REQUEST);
        }
        Optional<Employee> employee = employeeService.updateEmlpoyee(req);
        if(!employee.isEmpty() && employee.isPresent())
            return new ResponseEntity<>(employee.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>("Employee with mentioned ID not found", HttpStatus.NOT_FOUND);
    }
}