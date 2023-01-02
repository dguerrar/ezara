package com.dguerrar.zara.repositories;


import com.dguerrar.zara.domain.PriceListEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceListEntryRepository extends JpaRepository<PriceListEntry, Long> {

}
