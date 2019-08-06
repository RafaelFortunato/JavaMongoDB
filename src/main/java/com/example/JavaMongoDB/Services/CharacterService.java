package com.example.JavaMongoDB.Services;

import com.example.JavaMongoDB.Models.CharacterModel;
import com.example.JavaMongoDB.Repositories.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class CharacterService {

    @Autowired
    CharacterRepository characterRepository;

    public void createCharacter(CharacterModel c) {
        Assert.hasText(c.getName(), "Name must not be null or empty!");
//        c.setTimeCreated();
//
//        CharacterModel c = new CharacterModel();
//        c.setName(name);
//        c.setRace(CharacterRace.ELF);
//        c.setRole(CharacterRole.ASSASSIN);
//        c.setStrength(4);
//        c.setAgility(7);
//        c.setWisdom(5);
//        c.setVitality(5);
        characterRepository.save(c);
    }

    public List<CharacterModel> getCharacters() {
        return characterRepository.findAllByOrderByIdDesc();
    }
}
