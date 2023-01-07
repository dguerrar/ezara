package com.dguerrar.zara.controllers;

import com.dguerrar.zara.dto.BrandDTO;
import com.dguerrar.zara.dto.ProductDTO;
import com.dguerrar.zara.dto.ReturnDTO;
import com.dguerrar.zara.generic.GenericModule;
import com.dguerrar.zara.managers.BrandManager;
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
@RequestMapping("brand-controller")
@CrossOrigin(
        origins = "*",
        methods = {RequestMethod.GET}
)
public class BrandController extends GenericModule {

    @Autowired
    private BrandManager brandManager;

    @GetMapping(value = "brands",produces = "application/json")
    @Operation(summary = "Gets all brands")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get all brands",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Error",
                    content = @Content) })

    public ResponseEntity getAllBrands() throws Exception {


        List<?> objList= brandManager.geAllBrands();

        ReturnDTO dto= new ReturnDTO();
        dto.setObject(objList);

        return new ResponseEntity<ReturnDTO>(dto,null, HttpStatus.OK);
    }


    @GetMapping(value = "brand/{id}", produces = "application/json")
    @Operation(summary = "Get brand by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get brand by id",
                    content = @Content),
            @ApiResponse(responseCode = "422", description = "Incorrect data provided",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Entity not found",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Generic Error",
                    content = @Content)})
    public ResponseEntity getBrandById(@PathVariable Long id) throws Exception{
        BrandDTO dtoEntry = brandManager.getBrandById(id);
        ReturnDTO dto = new ReturnDTO();
        dto.setObject(dtoEntry);
        return new ResponseEntity<ReturnDTO>(dto, null, HttpStatus.OK);

    }

    @Override
    protected Class<?> getLogClass() {
        return BrandController.class;
    }
}
