package com.mauarcanjo.expense.controller;

import com.mauarcanjo.expense.dto.CategoryDto;
import com.mauarcanjo.expense.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<CategoryDto> createCategory (@RequestBody CategoryDto categoryDto){

        CategoryDto category = categoryService.createCategory(categoryDto);

        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> geteCategoryById (@PathVariable("id") Long id){

        CategoryDto category = categoryService.getCategoryById(id);

        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<CategoryDto>> geteAllCategories (){

        List<CategoryDto> categories =categoryService.getAllCategories();

        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<CategoryDto> updateCategory (@RequestBody CategoryDto categoryDto){

        CategoryDto category = categoryService.updateCategory(categoryDto);

        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory (@PathVariable("id") Long id){

        categoryService.deleteCategory(id);

        return ResponseEntity.ok("Category sucessfuly deleted!");
    }

}
