package com.dguerrar.zara.junit;

import com.dguerrar.zara.domain.Brand;
import com.dguerrar.zara.domain.PriceEntry;
import com.dguerrar.zara.domain.PriceListEntry;
import com.dguerrar.zara.domain.Product;
import com.dguerrar.zara.dto.BrandDTO;
import com.dguerrar.zara.dto.PriceEntryDTO;
import com.dguerrar.zara.dto.PriceListEntryDTO;
import com.dguerrar.zara.dto.ProductDTO;
import com.dguerrar.zara.managers.BrandManager;
import com.dguerrar.zara.managers.PriceEntryManager;
import com.dguerrar.zara.managers.PriceListEntryManager;
import com.dguerrar.zara.managers.ProductManager;
import org.apache.commons.collections4.CollectionUtils;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ZaraApplicationTests {

	@Autowired
	private BrandManager brandManager;

	@Autowired
	private ProductManager productManager;

	@Autowired
	private PriceListEntryManager priceListEntryManager;

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
	void getBrandById(){
		BrandDTO brands=brandManager.getBrandById(1l);
		assertNotNull(brands);


	}


	@Test
	void getAllBrands(){
		List<BrandDTO> brands=brandManager.geAllBrands();
		assertNotNull(brands);
		assertTrue(CollectionUtils.isNotEmpty(brands));

	}

	@Test
	void getAllProducts(){
		List<ProductDTO> products=productManager.geAllProducts();
		assertNotNull(products);
		assertTrue(CollectionUtils.isNotEmpty(products));

	}

	@Test
	void getProductById(){
		ProductDTO products=productManager.getProductById(1l);
		assertNotNull(products);


	}


	@Test
	void getAllPriceListEntry(){
		List<PriceListEntryDTO> priceListEntries=priceListEntryManager.geAllPriceListEntry();
		assertNotNull(priceListEntries);
		assertTrue(CollectionUtils.isNotEmpty(priceListEntries));

	}

	@Test
	void getPriceListEntryById(){
		PriceListEntryDTO priceListEntries=priceListEntryManager.getPriceListEntryById(1l);
		assertNotNull(priceListEntries);

	}


	@Test
	void getAllPriceEntry(){
		List<PriceEntry> priceEntries=priceEntryManager.geAllPrices();
		assertNotNull(priceEntries);
		assertTrue(CollectionUtils.isNotEmpty(priceEntries));

	}

	@Test
	void getPriceEntryById(){
		PriceEntryDTO priceEntries=priceEntryManager.getPriceEntryById(1l);
		assertNotNull(priceEntries);


	}

}
