package com.dguerrar.zara.controllers.tariff;

import com.dguerrar.zara.dto.TariffDTO;
import com.dguerrar.zara.dto.ReturnDTO;
import com.dguerrar.zara.generic.GenericModule;
import com.dguerrar.zara.managers.tariff.TariffManager;
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
@RequestMapping("tariff-controller")
@CrossOrigin(
        origins = "*",
        methods = {RequestMethod.GET}
)
public class TariffController extends GenericModule {

    @Autowired
    private TariffManager tariffManager;

    @GetMapping(value = "tariffs",produces = "application/json")
    @Operation(summary = "Gets all tariffs")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get all tariffs",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Error",
                    content = @Content) })

    public ResponseEntity getAllTariffs() throws Exception {


        List<?> objList= tariffManager.geAllTariffs();

        ReturnDTO dto= new ReturnDTO();
        dto.setObject(objList);

        return new ResponseEntity<ReturnDTO>(dto,null, HttpStatus.OK);
    }


    @GetMapping(value = "tariff/{id}", produces = "application/json")
    @Operation(summary = "Get tariff by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get tariff by id",
                    content = @Content),
            @ApiResponse(responseCode = "422", description = "Incorrect data provided",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Entity not found",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Generic Error",
                    content = @Content)})
    public ResponseEntity getTarriffById(@PathVariable Long id) throws Exception{
        TariffDTO dtoEntry = tariffManager.getTariffById(id);
        ReturnDTO dto = new ReturnDTO();
        dto.setObject(dtoEntry);
        return new ResponseEntity<ReturnDTO>(dto, null, HttpStatus.OK);

    }


    @Override
    protected Class<?> getLogClass() {
        return TariffController.class;
    }
}
