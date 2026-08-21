package dev.andersonjuniorz.SecOps_Tracker.service;

import dev.andersonjuniorz.SecOps_Tracker.entity.Viatura;
import dev.andersonjuniorz.SecOps_Tracker.repository.ViaturaRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Transactional
@Service
public class ViaturaService {

    private final ViaturaRepository repository;

    public ViaturaService(ViaturaRepository repository) {
        this.repository = repository;
    }

    // Create =========================================================

    public Viatura create(Viatura viatura){
        viatura.setId(null);
        return repository.save(viatura);
    }

    // READ =========================================================
    public List<Viatura> findAll(){
        return repository.findAll();
    }

    public Viatura findById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Viatura não encontrada com o ID: " + id));
    }

    public Viatura findByPlaca(String placa) {
        return repository.findByPlaca(placa)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Viatura não encontrada com a placa: " + placa));
    }

    // Update =========================================================
    public Viatura update(UUID id, Viatura viatura){
        Viatura viaturaUpdated = findById(id);
        viaturaUpdated.setPlaca(viatura.getPlaca());
        viaturaUpdated.setStatus(viatura.getStatus());

        return repository.save(viaturaUpdated);
    }

    // Delete =========================================================
    public void delete(UUID id){
        if(!repository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Viatura não encontrada com o ID: " + id);        }
        repository.deleteById(id);
    }
}
