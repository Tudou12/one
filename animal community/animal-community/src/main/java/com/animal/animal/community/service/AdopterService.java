package com.animal.animal.community.service;



import com.animal.animal.community.Dao.AdopterDAO;
import com.animal.animal.community.pojo.Adopter;
import com.animal.animal.community.pojo.Stray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class AdopterService {
    @Autowired
    AdopterDAO adopterDAO;
//    @Autowired
//    StrayService StrayService;

    public List<Adopter> list() {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return adopterDAO.findAll(sort);
    }

    public void addOrUpdate(Adopter adopter) {
        adopterDAO.save(adopter);//当主键存在时更新数据，当主键不存在时插入数据。
    }

    public void deleteById(int id) {
        adopterDAO.deleteById(id);
    }

//    public List<Adopter> listByStray(int ID) {
//        Stray stray = StrayService.get(ID);
//        Sort sort = new Sort(Sort.Direction.DESC, "ID");
//        return adopterDAO.findAllByStray(stray);
//    }
}