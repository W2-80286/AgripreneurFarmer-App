package com.agri.service;

import com.agri.model.Taluka;
import com.agri.repository.TalukaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TalukaService {

    @Autowired
    private TalukaRepository talukaRepository;

    public List<Taluka> getAllTalukas() {
        return talukaRepository.findAll();
    }

    public Optional<Taluka> getTalukaById(Long id) {
        return talukaRepository.findById(id);
    }

    public Taluka saveTaluka(Taluka taluka) {
        return talukaRepository.save(taluka);
    }

    public void deleteTaluka(Long id) {
        talukaRepository.deleteById(id);
    }
}
