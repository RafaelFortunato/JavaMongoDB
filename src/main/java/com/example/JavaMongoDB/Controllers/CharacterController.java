package com.example.JavaMongoDB.Controllers;

import com.example.JavaMongoDB.Models.CharacterModel;
import com.example.JavaMongoDB.Services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CharacterController {

    @Autowired
    CharacterService characterService;

    @RequestMapping(value = "/character", method = RequestMethod.POST)
    public ResponseEntity createCharacter(@RequestBody CharacterModel character) {
        characterService.createCharacter(character);

        return new ResponseEntity<>("Character created successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/character", method = RequestMethod.GET)
    public List<CharacterModel> getCharacters(@RequestParam(value = "name", required = false) String name,
                                        @RequestParam(value = "role", required = false) String role) {
        return characterService.getCharacters(name, role);
    }

//    @RequestMapping(value = "/character/role", method = RequestMethod.GET)
//    public List<CharacterModel> getCharactersByRole(@RequestParam(value = "role") String role) {
//        return characterService.getCharactersByRole(role);
//    }
}
