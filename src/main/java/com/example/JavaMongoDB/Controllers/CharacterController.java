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

    @GetMapping(value = "/characterCreation")
    public ModelAndView showForm() {
        return new ModelAndView("characterCreation", "character", new CharacterModel());
    }

    @PostMapping(value = "/character")
    public ModelAndView createCharacter(@ModelAttribute("character") CharacterModel character) {
        characterService.createCharacter(character);
        return new ModelAndView("characterCreation", HttpStatus.OK);//new ResponseEntity<>("Character created successfully", HttpStatus.OK);
    }

    @GetMapping(value = "/character")
    public List<CharacterModel> getCharacters() {
        return characterService.getCharacters();
    }
}
