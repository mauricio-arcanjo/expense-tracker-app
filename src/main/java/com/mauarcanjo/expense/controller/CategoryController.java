package com.mauarcanjo.expense.controller;

import com.mauarcanjo.expense.dto.CategoryDto;
import com.mauarcanjo.expense.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "CRUD REST APIs for Category Resource",
        description = "CRUD REST APIs for Category Resource - Create Category" +
                "Update Category, Get Category and Delete Category"
)
@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Operation(
            summary = "Create Category REST API",
            description = "Create Category REST API to save category into database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP STATUS 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<CategoryDto> createCategory (@RequestBody CategoryDto categoryDto){

        CategoryDto category = categoryService.createCategory(categoryDto);

        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get Category REST API",
            description = "Get Category REST API to get category from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 Ok"
    )
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> geteCategoryById (@PathVariable("id") Long id){

        CategoryDto category = categoryService.getCategoryById(id);

        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @Operation(
            summary = "Get all Categories REST API",
            description = "Get all Categories REST API to get all categories from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 Ok"
    )
    @GetMapping("/getall")
    public ResponseEntity<List<CategoryDto>> geteAllCategories (){

        List<CategoryDto> categories =categoryService.getAllCategories();

        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @Operation(
            summary = "Update Category REST API",
            description = "Update Category REST API to update category in the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 Ok"
    )
    @PutMapping
    public ResponseEntity<CategoryDto> updateCategory (@RequestBody CategoryDto categoryDto){

        CategoryDto category = categoryService.updateCategory(categoryDto);

        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @Operation(
            summary = "Delete Category REST API",
            description = "Delete Category REST API to Delete category from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 Ok"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory (@PathVariable("id") Long id){

        categoryService.deleteCategory(id);

        return ResponseEntity.ok("Category sucessfuly deleted!");
    }

}
