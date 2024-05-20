package com.example.dictionaryN.ServiceImp;

import com.example.dictionaryN.Entity.DictionaryEntity;
import com.example.dictionaryN.Repo.DicRepo;
import com.example.dictionaryN.Service.DicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DicServiceImp  implements DicService {
    @Autowired
    DicRepo dicRepo;

    @Override
    public List<DictionaryEntity> getAll() {
        return dicRepo.findAll();
    }
}
