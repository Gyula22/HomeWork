package com.example.homework.controllers;

import com.example.homework.dto.ClientDTO;
import com.example.homework.dto.PositionDTO;
import com.example.homework.models.Client;
import com.example.homework.models.Position;
import com.example.homework.repos.ClientRepository;
import com.example.homework.repos.PositionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class AppController {

    private final ClientRepository clientRepository;
    private final PositionRepository positionRepository;


    public AppController(ClientRepository clientRepository, PositionRepository positionRepository) {
        this.clientRepository = clientRepository;
        this.positionRepository = positionRepository;
    }

    @PostMapping(value = "/client")
    public String client(@RequestBody @Valid ClientDTO clientDTO) {
        Client client = new Client(clientDTO.getName(), clientDTO.getEmail());
        UUID uuid = UUID.randomUUID(); // Itt generalok egy UUID kulcsot.
        client.setApplicationKey(uuid.toString());  // Itt alitom be.
        clientRepository.save(client); // Elmentem a "Client" et.

        return client.getApplicationKey();
    }

    @PostMapping(value = "/position")
    public String position(@RequestBody @Valid PositionDTO positionDTO) {
        clientRepository.findByApplicationKey(positionDTO.getApplicationKey()).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.BAD_REQUEST, "Hibauzenet")); // Itt adok vissza "hibauzenetet"
                                        // ha nem ervenyes az API kulcs. Nem volt megadva az Exception tipusa.
        Position position = new Position(positionDTO.getPositionName(), positionDTO.getLocation());
        Position savedposition = positionRepository.save(position);
        return "http://localhost:8080/position/" + savedposition.getId(); // Kikerem az elobb elmentett poziciot URL kent. 
    }

    @GetMapping(value = "/position/search")
    public List<String> positionSearch(PositionDTO positionDTO) {
        clientRepository.findByApplicationKey(positionDTO.getApplicationKey()).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.BAD_REQUEST, "Hiabuzenet"));
        List<Position> positions = positionRepository
                .findByPositionNameContainingAndLocationContaining(positionDTO.getPositionName(), positionDTO.getLocation());
        List<String> result = new ArrayList<>();    // Listat hozok letre a kereses tarolasara.
        for (Position position : positions) {
            String url = "http://localhost:8080/position/" + position.getId();
            result.add(url);
        }
        return result;
    }

    @GetMapping(value = "/position/{id}")
    public Position getPosition(@PathVariable long id) {

        return positionRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Hiabuzenet"));
    }
}
