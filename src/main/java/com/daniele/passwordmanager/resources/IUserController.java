package com.daniele.passwordmanager.resources;

import com.daniele.passwordmanager.dto.DataDto;
import com.daniele.passwordmanager.dto.UserDto;
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
public interface IUserController {
    @Operation(summary = "Create user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User created successfully", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid detail supplied", content =
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDetails.class))),
            @ApiResponse(responseCode = "500", description = "Something went wrong", content =
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDetails.class)))
    })
    @PostMapping("${password-manager-base-url}/user")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto);

    @Operation(summary = "Get all user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All user retrieved successfully", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = DataDto.class))}),
            @ApiResponse(responseCode = "404", description = "Data not found", content =
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDetails.class))),
            @ApiResponse(responseCode = "500", description = "Something went wrong", content =
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDetails.class)))
    })
    @GetMapping("${password-manager-base-url}/user")
    public ResponseEntity<List<UserDto>> getAllUser();

    @Operation(summary = "Get user by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User retrieved successfully", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied", content =
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDetails.class))),
            @ApiResponse(responseCode = "404", description = "User not found with this id", content =
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDetails.class))),
            @ApiResponse(responseCode = "500", description = "Something went wrong", content =
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDetails.class)))
    })
    @GetMapping("${password-manager-base-url}/user/{id}")
    public ResponseEntity<UserDto> getUserById(@Valid @Parameter(name = "id", description = "Id of user to be updated", required = true) @PathVariable Long id);

    @Operation(description = "Update user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User updated successfully", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = DataDto.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid detail supplied", content =
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDetails.class))),
            @ApiResponse(responseCode = "404", description = "User not found with this id", content =
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDetails.class))),
            @ApiResponse(responseCode = "500", description = "Something went wrong", content =
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDetails.class)))
    })
    @PutMapping("${password-manager-base-url}/user")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto);

    @Operation(description = "Delete all user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User deleted successfully", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = DataDto.class))}),
            @ApiResponse(responseCode = "500", description = "Something went wrong", content =
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDetails.class)))
    })
    @DeleteMapping("${password-manager-base-url}/user")
    public ResponseEntity<List<UserDto>> deleteAllUser();

    @Operation(description = "Delete user by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User deleted successfully", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = DataDto.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied", content =
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDetails.class))),
            @ApiResponse(responseCode = "404", description = "User not found with this id", content =
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDetails.class))),
            @ApiResponse(responseCode = "500", description = "Something went wrong", content =
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDetails.class)))
    })
    @DeleteMapping("${password-manager-base-url}/user/{id}")
    public ResponseEntity<UserDto> deleteUserById(@Valid @Parameter(name = "id", description = "Id of user to be deleted", required = true) @PathVariable Long id);
}
