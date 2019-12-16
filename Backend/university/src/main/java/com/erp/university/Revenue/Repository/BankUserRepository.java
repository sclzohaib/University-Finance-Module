package com.erp.university.Revenue.Repository;

import com.erp.university.Revenue.Model.BankUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankUserRepository extends JpaRepository<BankUser, Long> {
}
