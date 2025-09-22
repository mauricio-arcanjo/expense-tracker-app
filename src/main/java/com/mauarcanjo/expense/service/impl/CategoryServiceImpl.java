package com.mauarcanjo.expense.service.impl;

import com.mauarcanjo.expense.dto.CategoryDto;
import com.mauarcanjo.expense.entity.Category;
import com.mauarcanjo.expense.exceptions.ResourceNotFoundException;
import com.mauarcanjo.expense.mapper.CategoryMapper;
import com.mauarcanjo.expense.repository.CategoryRepository;
import com.mauarcanjo.expense.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl (CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public CategoryDto createCategory(CategoryDto categoryDto) {

        Category category = CategoryMapper.mapToCategory(categoryDto);

        Category savedCategory = categoryRepository.save(category);

        return  CategoryMapper.mapToCategoryDto(savedCategory);
    }

    public CategoryDto getCategoryById(Long categoryId) {


        Category category = getCategory(categoryId);

        return CategoryMapper.mapToCategoryDto(category);
    }

    public List<CategoryDto> getAllCategories() {

        return categoryRepository
                .findAll()
                .stream()
                .map(CategoryMapper::mapToCategoryDto)
                .toList();
    }

    @Transactional
    public CategoryDto updateCategory(CategoryDto categoryDto) {

        Category category = getCategory(categoryDto.id());

        category.setName(categoryDto.name());

        return CategoryMapper.mapToCategoryDto(category);
    }

    public void deleteCategory(Long categoryId) {

        Category category = getCategory(categoryId);
        categoryRepository.delete(category);
    }

    private Category getCategory(Long categoryId){

        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + categoryId));
    }

}
