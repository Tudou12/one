package com.animal.animal.community.controller;

import com.animal.animal.community.pojo.Voluntary;
import com.animal.animal.community.service.VoluntaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VoluntaryController {
   @Autowired
    VoluntaryService voluntaryService;
   @CrossOrigin
    @GetMapping("/api/voluntary/list")
    @ResponseBody
    public List<Voluntary> list() throws Exception{
       return voluntaryService.list();

   }
   @CrossOrigin
    @PostMapping("/api/voluntary/add")
    public  Voluntary addOrupdate(@RequestBody Voluntary voluntary)throws Exception{
       voluntaryService.addOrUpdata(voluntary);
       return voluntary;
   }

    @CrossOrigin
    @GetMapping("/api/user/{userId}/voluntary")
    public List<Voluntary> listByCategory(@PathVariable("userId") int userId) throws Exception {
        if (0 != userId) {
            return voluntaryService.listByUser(userId);
        } else {
            return list();
        }
    }

}