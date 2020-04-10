package com.animal.animal.community.service;




import com.animal.animal.community.Dao.StrayDAO;
import com.animal.animal.community.pojo.Category;
import com.animal.animal.community.pojo.Stray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StrayService {
    @Autowired
    StrayDAO strayDAO;
    @Autowired
    CategoryService categoryService;

    public List<Stray> list() {
        Sort sort = new Sort(Sort.Direction.DESC, "ID");
        return strayDAO.findAll(sort);
    }

    public void addOrUpdate(Stray stray) {
        strayDAO.save(stray);//当主键存在时更新数据，当主键不存在时插入数据。
    }

    public void deleteById(int ID) {
        strayDAO.deleteById(ID);
    }
    public Stray get(int ID) {
        Stray s= strayDAO.findById(ID).orElse(null);
        return s;
    }
    public List<Stray> listByCategory(int aid) {
        Category category = categoryService.get(aid);
        Sort sort = new Sort(Sort.Direction.DESC, "ID");
        return strayDAO.findAllByCategory(category);
    }
}