package com.dguerrar.zara.repositories;

import com.dguerrar.zara.domain.PriceEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface PriceEntryRepository extends JpaRepository<PriceEntry, Long>, JpaSpecificationExecutor<PriceEntry> {

}
