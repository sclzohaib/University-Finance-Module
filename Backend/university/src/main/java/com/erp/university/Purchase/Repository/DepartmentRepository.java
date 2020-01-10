package com.erp.university.Purchase.Repository;

import com.erp.university.Purchase.Model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    @Query(
            value = "DELETE FROM APP_USER au WHERE au.DEPT_ID = :id",
            nativeQuery = true)
    void deleteUsersById(@Param("id") Long id);
}
