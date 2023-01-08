package com.dguerrar.zara.junit;

import com.dguerrar.zara.domain.PriceEntry;
import com.dguerrar.zara.dto.*;
import com.dguerrar.zara.managers.brand.BrandManager;
import com.dguerrar.zara.managers.price.PriceEntryManager;
import com.dguerrar.zara.managers.product.ProductManager;
import com.dguerrar.zara.managers.tariff.TariffManager;
import org.apache.commons.collections4.CollectionUtils;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class JunitTestsRequired {

	@Autowired
	private BrandManager brandManager;

	@Autowired
	private ProductManager productManager;

	@Autowired
	private TariffManager tariffManager;

	@Autowired
	private PriceEntryManager priceEntryManager;

	@Autowired
	private Flyway flyway;

	@Test
	void contextLoads() {

	}

	@BeforeEach
	void before() {
		flyway.migrate();
	}



	@Test
	void getPriceEntryTest1() throws Exception {
		QueryDTO queryDTO= new QueryDTO();
		queryDTO.setBrandId(1l);
		queryDTO.setProductId(35455l);
		String str = "2020/06/14 10:00:00";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
		queryDTO.setDate(dateTime);

		List<PriceEntryDTO> priceEntries=priceEntryManager.getPriceEntryByQuery(queryDTO);
		assertNotNull(priceEntries);
		assertTrue(CollectionUtils.isNotEmpty(priceEntries));

	}

	@Test
	void getPriceEntryTest2() throws Exception {
		QueryDTO queryDTO= new QueryDTO();
		queryDTO.setBrandId(1l);
		queryDTO.setProductId(35455l);
		String str = "2020/06/14 16:00:00";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
		queryDTO.setDate(dateTime);

		List<PriceEntryDTO> priceEntries=priceEntryManager.getPriceEntryByQuery(queryDTO);
		assertNotNull(priceEntries);
		assertTrue(CollectionUtils.isNotEmpty(priceEntries));

	}

	@Test
	void getPriceEntryTest3() throws Exception {
		QueryDTO queryDTO= new QueryDTO();
		queryDTO.setBrandId(1l);
		queryDTO.setProductId(35455l);
		String str = "2020/06/14 21:00:00";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
		queryDTO.setDate(dateTime);

		List<PriceEntryDTO> priceEntries=priceEntryManager.getPriceEntryByQuery(queryDTO);
		assertNotNull(priceEntries);
		assertTrue(CollectionUtils.isNotEmpty(priceEntries));

	}


	@Test
	void getPriceEntryTest4() throws Exception {
		QueryDTO queryDTO= new QueryDTO();
		queryDTO.setBrandId(1l);
		queryDTO.setProductId(35455l);
		String str = "2020/06/15 10:00:00";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
		queryDTO.setDate(dateTime);

		List<PriceEntryDTO> priceEntries=priceEntryManager.getPriceEntryByQuery(queryDTO);
		assertNotNull(priceEntries);
		assertTrue(CollectionUtils.isNotEmpty(priceEntries));

	}

	@Test
	void getPriceEntryTest5() throws Exception {
		QueryDTO queryDTO= new QueryDTO();
		queryDTO.setBrandId(1l);
		queryDTO.setProductId(35455l);
		String str = "2020/06/16 21:00:00";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
		queryDTO.setDate(dateTime);

		List<PriceEntryDTO> priceEntries=priceEntryManager.getPriceEntryByQuery(queryDTO);
		assertNotNull(priceEntries);
		assertTrue(CollectionUtils.isNotEmpty(priceEntries));

	}

}
