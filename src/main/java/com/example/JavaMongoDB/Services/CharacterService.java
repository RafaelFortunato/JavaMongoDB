package com.example.JavaMongoDB.Services;

import com.example.JavaMongoDB.Models.CharacterModel;
import com.example.JavaMongoDB.Repositories.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class CharacterService {

    private final static DateFormat DATE_TIME_FORMATTER = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    @Autowired
    CharacterRepository characterRepository;

    public void createCharacter(CharacterModel c) {
        Assert.hasText(c.getName(), "Name must not be null or empty!");
        c.setTimeCreated(DATE_TIME_FORMATTER.format(new Date()));
        characterRepository.save(c);
    }

    public List<CharacterModel> getCharacters() {
        return characterRepository.findAllByOrderByIdDesc();
    }
}
