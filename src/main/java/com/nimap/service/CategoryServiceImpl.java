package com.nimap.service;

import com.nimap.entity.CategoryModel;
import com.nimap.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<CategoryModel> getAllCategories() {
		return categoryRepository.findAll();
	}

	@Override
	public CategoryModel getCategoryById(Long id) {
		return categoryRepository.findById(id).orElse(null);
	}

	@Override
	public CategoryModel createCategory(CategoryModel category) {
		return categoryRepository.save(category);
	}

	@Override
	public CategoryModel updateCategory(Long id, CategoryModel category) {
		if (categoryRepository.existsById(id)) {
			category.setId(id);
			return categoryRepository.save(category);
		} else {
			return null;
		}
	}

	@Override
	public void deleteCategory(Long id) {
		categoryRepository.deleteById(id);
	}
}
