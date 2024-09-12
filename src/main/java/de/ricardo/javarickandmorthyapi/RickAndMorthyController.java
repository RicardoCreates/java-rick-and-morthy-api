package de.ricardo.javarickandmorthyapi;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/" )
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

    @GetMapping("/characters" )
    public List<Character> getCharacterByStatus(@RequestParam(required = false) String status) {
        if (status != null) {
            return characterService.filterByStatus(status);
        } else {
            return characterService.getAllCharacters();
        }
    }

    @GetMapping("species-statistic" )
    public int getCharacterBySpecies(@RequestParam(required = false) String species) {
        if (species != null) {
            return characterService.getAliveBySpecies(species);
        } else {
            return 0;
        }
    }
}
