package com.ejemplo.backend.services;

import com.ejemplo.backend.models.Causa;
import com.ejemplo.backend.repositories.CausaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CausaService {

    @Autowired
    private CausaRepository causaRepository;

    public List<Causa> obtenerTodas() {
        return causaRepository.findAll();
    }

    public void guardarCausa(Causa causa) {
        causaRepository.save(causa);
    }

    public Optional<Causa> obtenerPorId(Long id) {
        return causaRepository.findById(id);
    }
}