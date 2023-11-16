package com.daniele.passwordmanager.resources;

import com.daniele.passwordmanager.dto.DataDto;
import com.daniele.passwordmanager.exception.ErrorDetails;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
public interface IDataController {
    @Operation(description = "Create data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Data created successfully", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = DataDto.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid detail supplied", content =
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDetails.class))),
            @ApiResponse(responseCode = "500", description = "Something went wrong", content =
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDetails.class)))
    })
    @PostMapping("${password-manager-base-url}/data")
    public ResponseEntity<DataDto> createData(@Valid @RequestBody DataDto dataDto);

    @Operation(description = "Get all data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All data retrieved successfully", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = DataDto.class))}),
            @ApiResponse(responseCode = "404", description = "Data not found", content =
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDetails.class))),
            @ApiResponse(responseCode = "500", description = "Something went wrong", content =
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDetails.class)))
    })
    @GetMapping("${password-manager-base-url}/data")
    public ResponseEntity<List<DataDto>> getAllData();

    @Operation(description = "Get data by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Data retrieved successfully", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = DataDto.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied", content =
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDetails.class))),
            @ApiResponse(responseCode = "404", description = "Data not found with this id", content =
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDetails.class))),
            @ApiResponse(responseCode = "500", description = "Something went wrong", content =
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDetails.class)))
    })
    @GetMapping("${password-manager-base-url}/data/{id}")
    public ResponseEntity<DataDto> getDataById(@Valid @Parameter(name = "id", description = "Data Id", required = true) @PathVariable Long id);

    @Operation(description = "Update data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Data updated successfully", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = DataDto.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid detail supplied", content =
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDetails.class))),
            @ApiResponse(responseCode = "404", description = "Data not found with this id", content =
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDetails.class))),
            @ApiResponse(responseCode = "500", description = "Something went wrong", content =
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDetails.class)))
    })
    @PutMapping("${password-manager-base-url}/data")
    public ResponseEntity<DataDto> updateData(@Valid @RequestBody DataDto dataDto);

    @Operation(description = "Delete data by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Data deleted successfully", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = DataDto.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied", content =
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDetails.class))),
            @ApiResponse(responseCode = "404", description = "Data not found with this id", content =
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDetails.class))),
            @ApiResponse(responseCode = "500", description = "Something went wrong", content =
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDetails.class)))
    })
    @DeleteMapping("${password-manager-base-url}/data/{id}")
    public ResponseEntity<DataDto> deleteDataById(@Valid @Parameter(name = "id", description = "Data Id", required = true) @PathVariable Long id);

    @Operation(description = "Delete all data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Data deleted successfully", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = DataDto.class))}),
            @ApiResponse(responseCode = "500", description = "Something went wrong", content =
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDetails.class)))
    })
    @DeleteMapping("${password-manager-base-url}/data")
    public ResponseEntity<List<DataDto>> deleteAllData();
}