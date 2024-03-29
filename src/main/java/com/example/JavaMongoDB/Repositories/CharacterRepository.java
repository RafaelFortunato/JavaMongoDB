package com.example.JavaMongoDB.Repositories;

import com.example.JavaMongoDB.Models.CharacterModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CharacterRepository extends CrudRepository<CharacterModel, String> {
    CharacterModel findByName(String name);
    List<CharacterModel> findAllByName(String name);
    List<CharacterModel> findAllByOrderByIdDesc();
}
