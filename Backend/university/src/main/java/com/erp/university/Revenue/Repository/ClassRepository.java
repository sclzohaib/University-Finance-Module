package com.erp.university.Revenue.Repository;

import com.erp.university.Revenue.Model.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<Class, Long> {
}
