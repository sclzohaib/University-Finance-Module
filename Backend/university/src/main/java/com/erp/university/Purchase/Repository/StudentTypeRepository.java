package com.erp.university.Purchase.Repository;

import com.erp.university.Revenue.Model.StudentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentTypeRepository extends JpaRepository<StudentType, String> {
}
