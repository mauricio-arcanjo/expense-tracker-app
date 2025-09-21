package com.mauarcanjo.expense.service;

import com.mauarcanjo.expense.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto createCategory(CategoryDto categoryDto);

    CategoryDto getCategoryById(Long categoryId);

    List<CategoryDto> getAllCategories();

    CategoryDto updateCategory(CategoryDto categoryDto);

    void deleteCategory(Long categoryId);

}
