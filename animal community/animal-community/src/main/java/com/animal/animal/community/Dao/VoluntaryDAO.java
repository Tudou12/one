package com.animal.animal.community.Dao;


import com.animal.animal.community.pojo.User;
import com.animal.animal.community.pojo.Voluntary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VoluntaryDAO extends JpaRepository<Voluntary,Integer> {
    List<Voluntary> findAllByUser(User user);
}
