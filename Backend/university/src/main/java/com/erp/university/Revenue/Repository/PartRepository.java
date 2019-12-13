package com.erp.university.Revenue.Repository;

import com.erp.university.Revenue.Model.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartRepository extends JpaRepository<Part ,String> {
}
