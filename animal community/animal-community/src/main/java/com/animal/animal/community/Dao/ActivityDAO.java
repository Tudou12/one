package com.animal.animal.community.Dao;

import com.animal.animal.community.pojo.Activity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityDAO extends JpaRepository<Activity,Integer> {

}