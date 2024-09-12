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

    public List<Character> getAllCharacters() {
        RickAndMorthyApiResponseResult response = this.restClient.get().uri("/character" ).retrieve().body(RickAndMorthyApiResponseResult.class);
        assert response != null;
        return response.results();
    }

}
