package com.dguerrar.zara.controllers.price;

import com.dguerrar.zara.domain.PriceEntry;
import com.dguerrar.zara.dto.PriceEntryDTO;
import com.dguerrar.zara.dto.QueryDTO;
import com.dguerrar.zara.dto.ReturnDTO;
import com.dguerrar.zara.generic.GenericModule;
import com.dguerrar.zara.managers.price.PriceEntryManager;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("price-entry-controller")
@CrossOrigin(
        origins = "*",
        methods = {RequestMethod.GET, RequestMethod.POST}
)
public class PriceEntryController extends GenericModule {

    @Autowired
    private PriceEntryManager priceEntryManager;

    @GetMapping(value = "price-entries", produces = "application/json")
    @Operation(summary = "Gets all price-entry")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get all price-entry",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Error",
                    content = @Content)})

    public ResponseEntity getAllPrices() throws Exception {
        List<?> objList = priceEntryManager.geAllPrices();
        ReturnDTO dto = new ReturnDTO();
        dto.setObject(objList);
        return new ResponseEntity<ReturnDTO>(dto, null, HttpStatus.OK);
    }


    @PostMapping(value = "price-entry-query", produces = "application/json")
    @Operation(summary = "Get price by query")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get price by query",
                    content = @Content),
            @ApiResponse(responseCode = "400", description = "Error bad format",
                    content = @Content),

            @ApiResponse(responseCode = "422", description = "Incorrect data provided",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Generic Error",
                    content = @Content)})
    public ResponseEntity getPriceByQueryDTO(@RequestBody QueryDTO queryDTO) throws Exception{
        List<?> objList = priceEntryManager.getPriceEntryByQuery(queryDTO);
        ReturnDTO dto = new ReturnDTO();
        dto.setObject(objList);
        return new ResponseEntity<ReturnDTO>(dto, null, HttpStatus.OK);

    }



    @GetMapping(value = "price-entry/{id}", produces = "application/json")
    @Operation(summary = "Get price by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get price by id",
                    content = @Content),
            @ApiResponse(responseCode = "422", description = "Incorrect data provided",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Entity not found",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Generic Error",
                    content = @Content)})
    public ResponseEntity getPriceById(@PathVariable Long id) throws Exception{
        PriceEntryDTO dtoEntry = priceEntryManager.getPriceEntryById(id);
        ReturnDTO dto = new ReturnDTO();
        dto.setObject(dtoEntry);
        return new ResponseEntity<ReturnDTO>(dto, null, HttpStatus.OK);

    }


    @QueryMapping
    public List<PriceEntry> getPriceByDateAndPriorityAndTariff(@Argument int tariffId, @Argument int productId, @Argument int brandId,@Argument String currentDate) throws Exception {
        QueryDTO queryDTO= new QueryDTO();
        queryDTO.setBrandId((long)brandId);
        queryDTO.setProductId((long)productId);
        queryDTO.setTariffId((long)tariffId);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(currentDate, formatter);
        queryDTO.setDate(dateTime);
        List<PriceEntry>objList = priceEntryManager.getPriceEntryByQuerygrapQL(queryDTO);
        return objList;
    }



    @QueryMapping
    public List<PriceEntry>  priceEntries(){
        List<PriceEntry>objList = priceEntryManager.geAllPrices();

        return objList;
    }


    @Override
    protected Class<?> getLogClass() {
        return PriceEntryController.class;
    }
}
