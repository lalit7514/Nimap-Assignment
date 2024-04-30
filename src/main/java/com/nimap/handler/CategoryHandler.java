package com.nimap.handler;

import com.nimap.dto.CategoryDTO;
import com.nimap.entity.CategoryModel;
import com.nimap.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/categories")
public class CategoryHandler {

	@Autowired
	private CategoryService categoryService;

	@GetMapping
	public List<CategoryDTO> getAllCategories() {
		List<CategoryModel> categories = categoryService.getAllCategories();
		return categories.stream().map(this::convertToCategoryDTO).collect(Collectors.toList());
	}

	@GetMapping("/{id}")
	public CategoryDTO getCategoryById(@PathVariable Long id) {
		CategoryModel category = categoryService.getCategoryById(id);
		return convertToCategoryDTO(category);
	}

	@PostMapping
	public CategoryDTO createCategory(@RequestBody CategoryDTO categoryDTO) {
		CategoryModel category = convertToCategory(categoryDTO);
		CategoryModel createdCategory = categoryService.createCategory(category);
		return convertToCategoryDTO(createdCategory);
	}

	@PutMapping("/{id}")
	public CategoryDTO updateCategory(@PathVariable Long id, @RequestBody CategoryDTO categoryDTO) {
		CategoryModel category = convertToCategory(categoryDTO);
		CategoryModel updatedCategory = categoryService.updateCategory(id, category);
		return convertToCategoryDTO(updatedCategory);
	}

	@DeleteMapping("/{id}")
	public void deleteCategory(@PathVariable Long id) {
		categoryService.deleteCategory(id);
	}

	private CategoryDTO convertToCategoryDTO(CategoryModel category) {
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setId(category.getId());
		categoryDTO.setName(category.getName());

		return categoryDTO;
	}

	private CategoryModel convertToCategory(CategoryDTO categoryDTO) {
		CategoryModel category = new CategoryModel();
		category.setId(categoryDTO.getId());
		category.setName(categoryDTO.getName());

		return category;
	}
}
