package com.erp.university.Purchase.Repository;

import com.erp.university.Purchase.Model.MajorHead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface MajorHeadRepository extends JpaRepository<MajorHead, Long> {
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(
            value = "DELETE FROM minor_head mh WHERE mh.MAJOR_HEAD_ID = :id",
            nativeQuery = true)
    void deleteMinorHeadById(@Param("id") Long id);
}
