package com.erp.university.Purchase.Repository;

import com.erp.university.Purchase.Model.StudentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public interface StudentTypeRepository extends JpaRepository<StudentType, String> {
}
