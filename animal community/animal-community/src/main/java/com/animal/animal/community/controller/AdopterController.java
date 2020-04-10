package com.animal.animal.community.controller;



import com.animal.animal.community.pojo.Adopter;
import com.animal.animal.community.service.AdopterService;

import com.animal.animal.community.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

@RestController
public class AdopterController {
    @Autowired
    AdopterService adopterService;
    //解决跨域问题
    @CrossOrigin

    @GetMapping("/api/adopter")
    @ResponseBody
    public List<Adopter>list() throws Exception {
        return adopterService.list();
    }

    @CrossOrigin
    @PostMapping("/api/adopter/add")
    public Adopter addOrUpdate(@RequestBody Adopter adopter) throws Exception {
        adopterService.addOrUpdate(adopter);
        return adopter;
    }

    @CrossOrigin
    @PostMapping("/api/adopter/delete")
    public void delete(@RequestBody Adopter adopter) throws Exception {
        adopterService.deleteById(adopter.getId());
    }

//    @CrossOrigin
//    @GetMapping("/api/stray/{ID}/adopter")
//    public List<Adopter> listByStray(@PathVariable("ID") int ID) throws Exception {
//        if (0 != ID) {
//            return adopterService.listByStray(ID);
//        } else {
//            return list();
//        }
//    }
//    //图片上传
//    @CrossOrigin
    @PostMapping("api/animal_images")
    public String coversUpload(MultipartFile file) throws Exception {
        String folder = "D:/workspace/img";
        File imageFolder = new File(folder);
        File f = new File(imageFolder,getRandomString(6) + file.getOriginalFilename()
                .substring(file.getOriginalFilename().length() - 4));
        if (!f.getParentFile().exists())
            f.getParentFile().mkdirs();
        try {
            file.transferTo(f);
            String imgURL = "http://localhost:8443/api/file/" + f.getName();
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