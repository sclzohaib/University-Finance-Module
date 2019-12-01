package com.erp.university.Purchase.Repository;

import com.erp.university.Purchase.Model.CoveringLetter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoveringLetterRepository extends JpaRepository<CoveringLetter,Long> {
}
