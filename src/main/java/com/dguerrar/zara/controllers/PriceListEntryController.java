package com.dguerrar.zara.controllers;

import com.dguerrar.zara.dto.PriceEntryDTO;
import com.dguerrar.zara.dto.PriceListEntryDTO;
import com.dguerrar.zara.dto.ReturnDTO;
import com.dguerrar.zara.generic.GenericModule;
import com.dguerrar.zara.managers.BrandManager;
import com.dguerrar.zara.managers.PriceListEntryManager;
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
@RequestMapping("price-list-entry-controller")
@CrossOrigin(
        origins = "*",
        methods = {RequestMethod.GET}
)
public class PriceListEntryController extends GenericModule {

    @Autowired
    private PriceListEntryManager priceListEntryManager;

    @GetMapping(value = "price-list-entries",produces = "application/json")
    @Operation(summary = "Gets all price-list-entry")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get all price-list-entry",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Error",
                    content = @Content) })

    public ResponseEntity getAllPriceListEntries() throws Exception {


        List<?> objList= priceListEntryManager.geAllPriceListEntry();

        ReturnDTO dto= new ReturnDTO();
        dto.setObject(objList);

        return new ResponseEntity<ReturnDTO>(dto,null, HttpStatus.OK);
    }


    @GetMapping(value = "price-list-entry/{id}", produces = "application/json")
    @Operation(summary = "Get price list by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get price list by id",
                    content = @Content),
            @ApiResponse(responseCode = "422", description = "Incorrect data provided",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Entity not found",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Generic Error",
                    content = @Content)})
    public ResponseEntity getPriceListById(@PathVariable Long id) throws Exception{
        PriceListEntryDTO dtoEntry = priceListEntryManager.getPriceListEntryById(id);
        ReturnDTO dto = new ReturnDTO();
        dto.setObject(dtoEntry);
        return new ResponseEntity<ReturnDTO>(dto, null, HttpStatus.OK);

    }


    @Override
    protected Class<?> getLogClass() {
        return PriceListEntryController.class;
    }
}
