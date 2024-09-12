package de.ricardo.javarickandmorthyapi;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/characters" )
public class RickAndMorthyController {

    RestClient.Builder builder = RestClient.builder();
    private final CharacterService characterService = new CharacterService(builder);

//    @GetMapping
//    public List<Character> getAllCharacters() {
//        return characterService.getAllCharacters();
//    }

    @GetMapping("/{id}" )
    public Character getCharacterById(@PathVariable int id) {
        return characterService.getCharacterById(id);
    }

    @GetMapping
    public List<Character> getCharacterByStatus(@RequestParam("status") Optional<String> status) {
        if (status.isPresent()) {
            return characterService.filterByStatus(status.get());
        }
        return characterService.getAllCharacters();
    }
}
