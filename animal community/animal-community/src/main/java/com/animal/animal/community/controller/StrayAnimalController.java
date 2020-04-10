package com.animal.animal.community.controller;



import com.animal.animal.community.service.StrayService;
import com.animal.animal.community.pojo.Stray;

import com.animal.animal.community.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

@RestController
public class StrayAnimalController {
    @Autowired
    StrayService strayService;
    //解决跨域问题
    @CrossOrigin

    @GetMapping("/api/strays")
    @ResponseBody
    public List<Stray> list() throws Exception {
        return strayService.list();
    }

    @CrossOrigin
    @PostMapping("/api/strays")
    public Stray addOrUpdate(@RequestBody Stray stray) throws Exception {
        strayService.addOrUpdate(stray);
        return stray;
    }

    @CrossOrigin
    @PostMapping("/api/strays/delete")
    public void delete(@RequestBody Stray stray) throws Exception {
        strayService.deleteById(stray.getID());
    }

    @CrossOrigin
    @GetMapping("/api/category/{aid}/strays")
    public List<Stray> listByCategory(@PathVariable("aid") int aid) throws Exception {
        if (0 != aid) {
            return strayService.listByCategory(aid);
        } else {
            return list();
        }
    }
    //图片上传
    @CrossOrigin
    @PostMapping("api/images")
    public String coversUpload( @RequestParam(value = "file")  MultipartFile file) throws Exception {
        String folder = "D:/workspace/img";
        File imageFolder = new File(folder);
        File f = new File(imageFolder, getRandomString(6) + file.getOriginalFilename()
                .substring(file.getOriginalFilename().length() - 4));
        if (!f.getParentFile().exists())
            f.getParentFile().mkdirs();
        try {
            file.transferTo(f);
            String imgURL = "http://localhost:8443/api/file/" + f.getName();
//            String imgURL = sonImgPath +fileName;
            return imgURL;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
    public static  String getRandomString(int lenght){
        String base ="abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0;i<lenght; i++){
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return  sb.toString();
    }
}