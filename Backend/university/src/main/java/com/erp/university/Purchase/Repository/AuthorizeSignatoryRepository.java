package com.erp.university.Purchase.Repository;

import com.erp.university.Purchase.Model.AuthorizeSignatory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorizeSignatoryRepository  extends JpaRepository<AuthorizeSignatory,Long>
{

}
