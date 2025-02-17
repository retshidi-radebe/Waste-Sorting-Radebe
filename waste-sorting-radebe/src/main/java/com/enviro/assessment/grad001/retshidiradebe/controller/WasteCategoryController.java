package com.enviro.assessment.grad001.retshidiradebe.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.enviro.assessment.grad001.retshidiradebe.model.WasteCategory;
import com.enviro.assessment.grad001.retshidiradebe.service.WasteCategoryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/wastecategories")
@Api(value = "WasteCategory service", description = "Service to manage waste categories")
public class WasteCategoryController {

    @Autowired
    private WasteCategoryService wasteCategoryService;

    @PostMapping()
    @ApiOperation(value = "Create waste category", response = WasteCategory.class)
    @ResponseStatus(value = HttpStatus.CREATED)
    @ApiResponses(value = {
        @ApiResponse(code = 201, response = WasteCategory.class, message = "Waste category created successfully"),
        @ApiResponse(code = 400, message = "Invalid waste category request"),
        @ApiResponse(code = 401, message = "You are not authorized to access the resource"),
        @ApiResponse(code = 403, message = "You are forbidden to create waste category"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
        @ApiResponse(code = 500, message = "Internal server error")
    })
    public WasteCategory createWasteCategory(@Valid @RequestBody WasteCategory wasteCategory) {
        return wasteCategoryService.createWasteCategory(wasteCategory);
    }

    @GetMapping()
    @ApiOperation(value = "View list of waste categories", response = WasteCategory.class, responseContainer = "List")
    @ResponseStatus(value = HttpStatus.OK)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully retrieved waste category list", response = WasteCategory.class, responseContainer = "List"),
        @ApiResponse(code = 401, message = "You are not authorized to access the resource"),
        @ApiResponse(code = 403, message = "You are forbidden to view waste category list"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
        @ApiResponse(code = 500, message = "Internal server error")
    })
    public List<WasteCategory> getWasteCategories() {
        return wasteCategoryService.getWasteCategories();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "View waste category details by id", response = WasteCategory.class)
    @ResponseStatus(value = HttpStatus.OK)
    @ApiResponses(value = {
        @ApiResponse(code = 200, response = WasteCategory.class, message = "Successfully retrieved waste category by id"),
        @ApiResponse(code = 400, message = "Invalid request"),
        @ApiResponse(code = 401, message = "You are not authorized to access the resource"),
        @ApiResponse(code = 403, message = "You are forbidden to view waste category by id"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
        @ApiResponse(code = 500, message = "Internal server error")
    })
    public WasteCategory getWasteCategoryById(@PathVariable(value = "id") Long id) {
        return wasteCategoryService.getWasteCategoryById(id);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update waste category details by id", response = WasteCategory.class)
    @ResponseStatus(value = HttpStatus.OK)
    @ApiResponses(value = {
        @ApiResponse(code = 200, response = WasteCategory.class, message = "Successfully updated waste category by id"),
        @ApiResponse(code = 400, message = "Invalid request"),
        @ApiResponse(code = 401, message = "You are not authorized to access the resource"),
        @ApiResponse(code = 403, message = "You are forbidden to update waste category by id"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
        @ApiResponse(code = 500, message = "Internal server error")
    })
    public WasteCategory updateWasteCategoryById(@Valid @RequestBody WasteCategory wasteCategory, @PathVariable(value = "id") Long id) {
        return wasteCategoryService.updateWasteCategoryById(id, wasteCategory);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete waste category details by id", response = WasteCategory.class)
    @ResponseStatus(value = HttpStatus.OK)
    @ApiResponses(value = {
        @ApiResponse(code = 200, response = WasteCategory.class, message = "Successfully deleted waste category by id"),
        @ApiResponse(code = 400, message = "Invalid request"),
        @ApiResponse(code = 401, message = "You are not authorized to access the resource"),
        @ApiResponse(code = 403, message = "You are forbidden to delete waste category by id"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
        @ApiResponse(code = 500, message = "Internal server error")
    })
    public ResponseEntity<?> deleteWasteCategoryById(@PathVariable(value = "id") Long id) {
        wasteCategoryService.deleteWasteCategoryById(id);
        return ResponseEntity.ok().build();
    }
}