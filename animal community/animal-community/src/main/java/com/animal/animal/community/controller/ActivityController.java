package com.animal.animal.community.controller;

import com.animal.animal.community.pojo.Activity;
import com.animal.animal.community.service.ActivityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ActivityController {
    @Autowired
    ActivityService activityService;
    //解决跨域问题
    @CrossOrigin
    @GetMapping("/api/activity/list")
    @ResponseBody
    public List<Activity> list() throws Exception {
        return activityService.list();
    }

    @CrossOrigin
    @PostMapping("/api/activity/add")
    public Activity addOrUpdate(@RequestBody Activity activity) throws Exception {
        activityService.addOrUpdate(activity);
        return activity;
    }

    @CrossOrigin
    @PostMapping("/api/activitys/delete")
    public void delete(@RequestBody Activity activity) throws Exception {
        activityService.deleteById(activity.getId());
    }

}