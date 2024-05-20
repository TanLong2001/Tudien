package com.example.dictionaryN.Controller;

import com.example.dictionaryN.Entity.DictionaryEntity;
import com.example.dictionaryN.Repo.DicRepo;
import com.example.dictionaryN.Service.DicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class DicController {

    @Autowired
    DicService dicService;

    @GetMapping("/get")
    public List<DictionaryEntity> getDataTest(){
        System.out.println(dicService.getAll().get(1).toString());
        return dicService.getAll();
    }



//    @GetMapping("/get/{id}")
//    public DictionaryEntity getOne( @PathVariable("id") Long id){
//        return dicRepo.findOneById(id);
//    }

}
