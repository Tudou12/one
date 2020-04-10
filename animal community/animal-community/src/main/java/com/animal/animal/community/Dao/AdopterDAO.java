package com.animal.animal.community.Dao;

import com.animal.animal.community.pojo.Adopter;
import com.animal.animal.community.pojo.Stray;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AdopterDAO extends JpaRepository<Adopter, Integer> {
//    List<Adopter> findAllByStray(Stray stray);
}
