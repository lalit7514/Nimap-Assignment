
package com.nimap.service;

import java.util.List;

import com.nimap.entity.CategoryModel;

public interface CategoryService {
	List<CategoryModel> getAllCategories();

	CategoryModel getCategoryById(Long id);

	CategoryModel createCategory(CategoryModel category);

	CategoryModel updateCategory(Long id, CategoryModel category);

	void deleteCategory(Long id);
}
