package com.animal.animal.community.controller;

import com.animal.animal.community.service.LostService;
import com.animal.animal.community.pojo.Lost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LostController {
   @Autowired
   LostService lostService;
   @CrossOrigin
   @GetMapping("/api/losts/list")
   @ResponseBody
   public List<Lost>list() throws Exception{
       return lostService.list();
   }

    @CrossOrigin
    @PostMapping("/api/losts/add")
    public Lost addOrUpdate(@RequestBody Lost lost) throws Exception {
        lostService.addOrUpdate(lost);
        return lost;
    }

    @CrossOrigin
    @PostMapping("/api/losts/delete")
    public void delete(@RequestBody Lost lost) throws Exception {
        lostService.deleteById(lost.getId());
    }

    @CrossOrigin
    @GetMapping("/api/category/{aid}/losts")
    public List<Lost> listByCategory(@PathVariable("aid") int aid) throws Exception {
        if (0 != aid) {
            return lostService.listByCategory(aid);
        } else {
            return list();
        }
    }
}