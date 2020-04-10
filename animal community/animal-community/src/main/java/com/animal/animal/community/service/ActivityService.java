package com.animal.animal.community.service;

import com.animal.animal.community.pojo.Activity;
import com.animal.animal.community.Dao.ActivityDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {
@Autowired
    ActivityDAO activityDAO;
    public List<Activity> list() {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return activityDAO.findAll(sort);
    }

    public void addOrUpdate(Activity activity) {
        activityDAO.save(activity);//当主键存在时更新数据，当主键不存在时插入数据。
    }

    public void deleteById(int id) {
        activityDAO.deleteById(id);
    }
    public Activity get(int id) {
        Activity a= activityDAO.findById(id).orElse(null);
        return a;
    }
}