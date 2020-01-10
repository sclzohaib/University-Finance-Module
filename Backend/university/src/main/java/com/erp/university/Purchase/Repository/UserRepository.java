package com.erp.university.Purchase.Repository;

import com.erp.university.Purchase.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(
            value = "DELETE FROM ROLE_USERS ru WHERE ru.USERS_ID = :id",
            nativeQuery = true)
    void deleteROLE_USERSByUsersId(@Param("id") Long id);

    User findByEmail(String email);
}
