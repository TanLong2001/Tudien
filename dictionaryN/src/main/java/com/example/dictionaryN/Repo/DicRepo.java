package com.example.dictionaryN.Repo;

import com.example.dictionaryN.Entity.DictionaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DicRepo extends JpaRepository<DictionaryEntity, Long> {

        DictionaryEntity findOneById(Long id);
//    @Override
//    public List<DictionaryEntity> findAll();
}
