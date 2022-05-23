package com.codegym.service.impl;

import com.codegym.model.Category;
import com.codegym.repository.ICategoryRepository;
import com.codegym.repository.impl.CategoryRepository;
import com.codegym.service.ICategoryService;

import java.util.List;

public class CategoryService implements ICategoryService {
    private final ICategoryRepository iCategoryRepository = new CategoryRepository();
    @Override
    public List<Category> findALL() {
        return iCategoryRepository.findALL();
    }
}
