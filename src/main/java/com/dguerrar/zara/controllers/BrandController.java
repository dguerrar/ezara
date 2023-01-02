package com.dguerrar.zara.controllers;

import com.dguerrar.zara.dto.ReturnDTO;
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
public class BrandController {

    @Autowired
    private BrandManager brandManager;

    @GetMapping(value = "brands",produces = "application/json")
    @Operation(summary = "Gets all brands")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get all brands",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Error",
                    content = @Content) })

    public ResponseEntity getAllbrands() throws Exception {


        List<?> objList= brandManager.geAllBrands();

        ReturnDTO dto= new ReturnDTO();
        dto.setObject(objList);

        return new ResponseEntity<ReturnDTO>(dto,null, HttpStatus.OK);
    }


}
