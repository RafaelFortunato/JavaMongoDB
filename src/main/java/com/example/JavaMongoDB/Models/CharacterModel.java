package com.example.JavaMongoDB.Models;

import com.example.JavaMongoDB.Utils.CharacterRace;
import com.example.JavaMongoDB.Utils.CharacterRole;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "character")
public class CharacterModel {

    @Id
    String id;

    @Indexed(unique = true)
    String name;
    CharacterRole role;
    CharacterRace race;
    Integer strength;
    Integer wisdom;
    Integer agility;
    Integer vitality;
    String timeCreated;
}
