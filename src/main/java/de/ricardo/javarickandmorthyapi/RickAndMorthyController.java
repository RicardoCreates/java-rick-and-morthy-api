package de.ricardo.javarickandmorthyapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import java.util.List;

@RestController
@RequestMapping("/api/characters")
public class RickAndMorthyController {

    RestClient.Builder builder = RestClient.builder();
    private final CharacterService characterService = new CharacterService(builder);

    @GetMapping
    public List<Character> getAllCharacters(){
        return characterService.getAllCharacters();
    }
}
