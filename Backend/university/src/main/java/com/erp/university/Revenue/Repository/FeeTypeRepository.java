package com.erp.university.Revenue.Repository;

import com.erp.university.Revenue.Model.FeeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeeTypeRepository extends JpaRepository<FeeType, Long> {
}
