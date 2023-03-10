package com.dguerrar.zara.controllers.product;

import com.dguerrar.zara.dto.ProductDTO;
import com.dguerrar.zara.dto.ReturnDTO;
import com.dguerrar.zara.generic.GenericModule;
import com.dguerrar.zara.managers.product.ProductManager;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product-controller")
@CrossOrigin(
        origins = "*",
        methods = {RequestMethod.GET}
)
public class ProductController extends GenericModule {

    @Autowired
    private ProductManager productManager;

    @GetMapping(value = "products",produces = "application/json")
    @Operation(summary = "Gets all products")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get all products",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Error",
                    content = @Content) })

    public ResponseEntity getAllProducts() throws Exception {


        List<?> objList = productManager.geAllProducts();

        ReturnDTO dto = new ReturnDTO();
        dto.setObject(objList);

        return new ResponseEntity<ReturnDTO>(dto, null, HttpStatus.OK);
    }


    @GetMapping(value = "product/{id}", produces = "application/json")
    @Operation(summary = "Get product by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get product by id",
                    content = @Content),
            @ApiResponse(responseCode = "422", description = "Incorrect data provided",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Entity not found",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Generic Error",
                    content = @Content)})
    public ResponseEntity getProductById(@PathVariable Long id) throws Exception{
        ProductDTO dtoEntry = productManager.getProductById(id);
        ReturnDTO dto = new ReturnDTO();
        dto.setObject(dtoEntry);
        return new ResponseEntity<ReturnDTO>(dto, null, HttpStatus.OK);

    }


    @Override
    protected Class<?> getLogClass() {
        return ProductController.class;
    }
}
