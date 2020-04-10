package com.animal.animal.community.service;

import com.animal.animal.community.Dao.VoluntaryDAO;
import com.animal.animal.community.pojo.User;
import com.animal.animal.community.pojo.Voluntary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoluntaryService {
     @Autowired
     VoluntaryDAO voluntaryDAO;
     @Autowired
    UserService userService;

     public List<Voluntary>list(){
         Sort sort = new Sort(Sort.Direction.DESC,"id");
         return voluntaryDAO.findAll(sort);
     }

     public  void  addOrUpdata(Voluntary voluntary){
         voluntaryDAO.save(voluntary);
     }

     public List<Voluntary>listByUser(int id){
         User user = userService.get(id);
         Sort sort = new Sort(Sort.Direction.DESC,"id");
         return voluntaryDAO.findAllByUser(user);
     }
}