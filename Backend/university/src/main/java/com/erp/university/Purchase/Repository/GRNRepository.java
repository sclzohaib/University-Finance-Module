package com.erp.university.Purchase.Repository;

import com.erp.university.Purchase.Model.GRN;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GRNRepository extends JpaRepository<GRN, Long> {

}
