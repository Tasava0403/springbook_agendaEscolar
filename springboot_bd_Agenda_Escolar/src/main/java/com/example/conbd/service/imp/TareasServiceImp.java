package com.example.conbd.service.imp;

import com.example.conbd.entity.Tareas;
import com.example.conbd.repository.ITareasRepository;
import com.example.conbd.service.ITareasService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareasServiceImp implements ITareasService {

    @Autowired
    private ITareasRepository repository;

    @Override
    public List<Tareas> listarTareas() {
        return repository.findAll();
    }

    @Override
    public Tareas buscarPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }

}
