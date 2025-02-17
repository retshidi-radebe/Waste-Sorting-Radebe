package com.enviro.assessment.grad001.retshidiradebe.controller;

import java.util.List;

import javax.validation.Valid;

import com.enviro.assessment.grad001.retshidiradebe.model.WasteItem;
import com.enviro.assessment.grad001.retshidiradebe.service.WasteItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.*;

@RestController
@RequestMapping("/wasteitems")
@Api(value = "WasteItem service", description = "Service to manage waste items")
public class WasteItemController {

    @Autowired
    private WasteItemService wasteItemService;

    @PostMapping()
    @ApiOperation(value = "Create waste item", response = WasteItem.class)
    @ResponseStatus(value = HttpStatus.CREATED)
    @ApiResponses(value = {
        @ApiResponse(code = 201, response = WasteItem.class, message = "Waste item created successfully"),
        @ApiResponse(code = 400, message = "Invalid waste item request"),
        @ApiResponse(code = 401, message = "You are not authorized to access the resource"),
        @ApiResponse(code = 403, message = "You are forbidden to create waste item"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
        @ApiResponse(code = 500, message = "Internal server error")
    })
    public WasteItem createWasteItem(@Valid @RequestBody WasteItem wasteItem) {
        return wasteItemService.createWasteItem(wasteItem);
    }

    @GetMapping()
    @ApiOperation(value = "View list of waste items", response = WasteItem.class, responseContainer = "List")
    @ResponseStatus(value = HttpStatus.OK)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully retrieved waste item list", response = WasteItem.class, responseContainer = "List"),
        @ApiResponse(code = 401, message = "You are not authorized to access the resource"),
        @ApiResponse(code = 403, message = "You are forbidden to view waste item list"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
        @ApiResponse(code = 500, message = "Internal server error")
    })
    public List<WasteItem> getWasteItems() {
        return wasteItemService.getWasteItems();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "View waste item details by id", response = WasteItem.class)
    @ResponseStatus(value = HttpStatus.OK)
    @ApiResponses(value = {
        @ApiResponse(code = 200, response = WasteItem.class, message = "Successfully retrieved waste item by id"),
        @ApiResponse(code = 400, message = "Invalid request"),
        @ApiResponse(code = 401, message = "You are not authorized to access the resource"),
        @ApiResponse(code = 403, message = "You are forbidden to view waste item by id"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
        @ApiResponse(code = 500, message = "Internal server error")
    })
    public WasteItem getWasteItemById(@PathVariable(value = "id") Long id) {
        return wasteItemService.getWasteItemById(id);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update waste item details by id", response = WasteItem.class)
    @ResponseStatus(value = HttpStatus.OK)
    @ApiResponses(value = {
        @ApiResponse(code = 200, response = WasteItem.class, message = "Successfully updated waste item by id"),
        @ApiResponse(code = 400, message = "Invalid request"),
        @ApiResponse(code = 401, message = "You are not authorized to access the resource"),
        @ApiResponse(code = 403, message = "You are forbidden to update waste item by id"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
        @ApiResponse(code = 500, message = "Internal server error")
    })
    public WasteItem updateWasteItemById(@Valid @RequestBody WasteItem wasteItem, @PathVariable(value = "id") Long id) {
        return wasteItemService.updateWasteItemById(id, wasteItem);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete waste item details by id", response = WasteItem.class)
    @ResponseStatus(value = HttpStatus.OK)
    @ApiResponses(value = {
        @ApiResponse(code = 200, response = WasteItem.class, message = "Successfully deleted waste item by id"),
        @ApiResponse(code = 400, message = "Invalid request"),
        @ApiResponse(code = 401, message = "You are not authorized to access the resource"),
        @ApiResponse(code = 403, message = "You are forbidden to delete waste item by id"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
        @ApiResponse(code = 500, message = "Internal server error")
    })
    public ResponseEntity<?> deleteWasteItemById(@PathVariable(value = "id") Long id) {
        wasteItemService.deleteWasteItemById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/category/{categoryName}")
    @ApiOperation(value = "View waste items by category name", response = WasteItem.class, responseContainer = "List")
    @ResponseStatus(value = HttpStatus.OK)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved waste items by category name", response = WasteItem.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Invalid request"),
            @ApiResponse(code = 401, message = "You are not authorized to access the resource"),
            @ApiResponse(code = 403, message = "You are forbidden to view waste items by category name"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    public List<WasteItem> getWasteItemsByCategoryName(@PathVariable(value = "categoryName") String categoryName) {
        return wasteItemService.getWasteItemsByCategoryName(categoryName);
    }
}