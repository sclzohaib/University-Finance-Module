package com.erp.university.Purchase.Repository;

import com.erp.university.Purchase.Model.Part;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartRepository extends JpaRepository<Part, String> {
}
