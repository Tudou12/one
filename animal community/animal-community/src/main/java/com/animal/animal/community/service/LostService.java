package com.animal.animal.community.service;

import com.animal.animal.community.Dao.LostDAO;


import com.animal.animal.community.pojo.Category;
import com.animal.animal.community.pojo.Lost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LostService {
    @Autowired
    LostDAO lostDAO;
    @Autowired
    CategoryService categoryService;

    public List<Lost> list() {
     Sort sort = new Sort(Sort.Direction.DESC,"id") ;
     return lostDAO.findAll(sort);
    }

    public void addOrUpdate(Lost lost) {
        lostDAO.save(lost);//当主键存在时更新数据，当主键不存在时插入数据。
    }

    public void deleteById(int id) {
        lostDAO.deleteById(id);
    }

    public List<Lost> listByCategory(int aId) {
        Category category = categoryService.get(aId);
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return lostDAO.findAllByCategory(category);
    }
}