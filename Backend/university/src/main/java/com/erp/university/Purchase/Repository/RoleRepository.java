package com.erp.university.Purchase.Repository;

import com.erp.university.Purchase.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query(
            value = "DELETE FROM ROLE_PERMISSION rp WHERE rp.ROLE_ID = :id",
            nativeQuery = true)
    void deleteROLE_PERMISSIONByRoleId(@Param("id") Long id);

    @Query(
            value = "DELETE FROM ROLE_USERS ru WHERE ru.ROLE_ID = :id",
            nativeQuery = true)
    void deleteROLE_USERSByRoleId(@Param("id") Long id);
}
