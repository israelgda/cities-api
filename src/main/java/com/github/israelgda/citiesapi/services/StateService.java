package com.github.israelgda.citiesapi.services;

import com.github.israelgda.citiesapi.entities.State;
import com.github.israelgda.citiesapi.repository.StateRepository;
import com.github.israelgda.citiesapi.services.exceptions.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StateService {

    private final StateRepository repository;

    public StateService(StateRepository repository) {
        this.repository = repository;
    }

    public State findById(Long id){
        Optional<State> state = repository.findById(id);
        return state.orElseThrow(()-> new ResourceNotFoundException(id));
    }

    public List<State> findAll(){
        List<State> list = repository.findAll();
        return list;
    }
}
