package com.codegym.repository;

import com.codegym.model.Category;

import java.util.List;

public interface ICategoryRepository {
    List<Category> findALL();
}
