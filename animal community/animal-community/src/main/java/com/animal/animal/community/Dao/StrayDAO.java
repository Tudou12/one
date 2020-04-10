package com.animal.animal.community.Dao;


import com.animal.animal.community.pojo.Category;
import com.animal.animal.community.pojo.Stray;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StrayDAO extends JpaRepository<Stray,Integer> {
    List<Stray> findAllByCategory(Category category);
//    List<Lost> findAllBy(String keyword1, String keyword2);
}
