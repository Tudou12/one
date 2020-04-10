package com.animal.animal.community.service;


import com.animal.animal.community.Dao.CategoryDAO;
import com.animal.animal.community.pojo.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService {
    @Autowired
    CategoryDAO categoryDAO;

    public List<Category> list() {
        Sort sort = new Sort(Sort.Direction.DESC, "ID");
        return categoryDAO.findAll(sort);
    }

    public Category get(int ID) {
        Category c= categoryDAO.findById(ID).orElse(null);
        return c;
    }
}