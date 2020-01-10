package com.erp.university.Purchase.Repository;

import com.erp.university.Purchase.Model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {
    @Query(
            value = "DELETE FROM ROLE_PERMISSION rp WHERE rp.PERMISSION_ID = :id",
            nativeQuery = true)
    void deleteROLE_PERMISSIONByPermissionId(@Param("id") Long id);
}
