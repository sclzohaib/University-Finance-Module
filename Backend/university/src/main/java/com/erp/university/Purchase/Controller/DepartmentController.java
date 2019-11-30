package com.erp.university.Purchase.Controller;


import com.erp.university.Purchase.DTO.DepartmentDTO;
import com.erp.university.Purchase.Model.Department;
import com.erp.university.Purchase.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/department")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    //Post Call
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<String> saveDepartment(@RequestBody DepartmentDTO departmentDTO){
        return departmentService.saveDepartment(departmentDTO);
    }

    //Get Call to Get all Departments
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Department>> getDepartment(){
        return departmentService.getDepartment();
    }

    //Get call to get single department by id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Department> getDepartmentById(@PathVariable("id") Long id){
        return departmentService.getDepartmentById(id);
    }

    //Update Department via Id
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateDepartment(@PathVariable("id") Long id, @RequestBody DepartmentDTO departmentDTO){
        return departmentService.updateDepartment(id, departmentDTO);
    }

}
