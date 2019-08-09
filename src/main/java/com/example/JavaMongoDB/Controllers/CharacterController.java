package com.example.JavaMongoDB.Controllers;

import com.example.JavaMongoDB.Models.CharacterModel;
import com.example.JavaMongoDB.Services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class CharacterController {

    @Autowired
    CharacterService characterService;

    @PostMapping(value = "/character")
    public ResponseEntity createCharacter(@ModelAttribute CharacterModel character) {
        characterService.createCharacter(character);
        return new ResponseEntity<>("Character created successfully", HttpStatus.OK);
    }

    @GetMapping(value = "/character")
    public List<CharacterModel> getCharacters() {
        return characterService.getCharacters();
    }
}
