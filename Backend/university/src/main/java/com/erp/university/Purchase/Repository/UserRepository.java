package com.erp.university.Purchase.Repository;

import com.erp.university.Purchase.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
