package de.ricardo.javarickandmorthyapi;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class CharacterService {

    private final RestClient restClient;

    public CharacterService(RestClient.Builder builder) {
        this.restClient = builder.baseUrl("https://rickandmortyapi.com/api" ).build();
    }

    //Get All Characters
    public List<Character> getAllCharacters() {
        RickAndMorthyApiResponseResult response = this.restClient.get().uri("/character" ).retrieve().body(RickAndMorthyApiResponseResult.class);
        assert response != null;
        return response.results();
    }

    //BYID
    public Character getCharacterById(int id) {
        List<Character> characters = getAllCharacters();
        return characters.stream().filter(character -> character.getId() == id).findFirst().orElse(null);
    }

    //Filter
    public List<Character> filterByStatus(String status) {
        RickAndMorthyApiResponseResult response = this.restClient
                .get()
                .uri("/character?status={status}", status)
                .retrieve()
                .body(RickAndMorthyApiResponseResult.class);
        assert response != null;
        return response.results();
    }

    //Statistics
    public int getAliveBySpecies(String species) {
        RickAndMorthyApiResponseResult response = this.restClient
                .get()
                .uri("/character?species={species}&status=alive", species)
                .retrieve()
                .body(RickAndMorthyApiResponseResult.class);
        assert response != null;
        return response.info().count();
    }


}
