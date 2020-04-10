package com.animal.animal.community.Dao;


import com.animal.animal.community.pojo.Category;
import com.animal.animal.community.pojo.Lost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LostDAO extends JpaRepository<Lost,Integer> {
    List<Lost> findAllByCategory(Category category);
//    List<Lost> findAllBy(String keyword1, String keyword2);
}
