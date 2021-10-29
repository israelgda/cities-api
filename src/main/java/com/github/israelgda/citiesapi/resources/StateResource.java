package com.github.israelgda.citiesapi.resources;

import com.github.israelgda.citiesapi.entities.State;
import com.github.israelgda.citiesapi.services.StateService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/states")
public class StateResource {

    private final StateService service;

    public StateResource(StateService service) {
        this.service = service;
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<State> findById(@PathVariable Long id){
        State state = service.findById(id);
        return ResponseEntity.ok().body(state);
    }

    @GetMapping
    public ResponseEntity<List<State>> findAll(){
        List<State> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
}
