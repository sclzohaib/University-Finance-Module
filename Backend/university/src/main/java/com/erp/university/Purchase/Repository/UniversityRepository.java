package com.erp.university.Purchase.Repository;

import com.erp.university.Purchase.Model.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityRepository extends JpaRepository<University, Long> {
    @Query(
            value = "DELETE FROM DEPARTMENT d WHERE d.UNI_ID = :id",
            nativeQuery = true)
    void deleteDepartmentById(@Param("id") Long id);
}
