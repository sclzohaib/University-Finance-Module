package com.erp.university.Purchase.Repository;

import com.erp.university.Purchase.Model.GST;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GSTRepository extends JpaRepository<GST,Long> {

    
}
