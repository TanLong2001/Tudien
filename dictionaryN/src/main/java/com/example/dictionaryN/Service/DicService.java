package com.example.dictionaryN.Service;

import com.example.dictionaryN.Entity.DictionaryEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DicService {

    public List<DictionaryEntity> getAll();

}
