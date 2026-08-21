package dev.andersonjuniorz.SecOps_Tracker.controller;

import dev.andersonjuniorz.SecOps_Tracker.entity.Viatura;
import dev.andersonjuniorz.SecOps_Tracker.service.ViaturaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/Viaturas")
public class ViaturaController {

    private final ViaturaService service;


    // Constructor
    public ViaturaController(ViaturaService service) {
        this.service = service;
    }

    // CREATE =================================================================================
    @PostMapping
    public ResponseEntity<Viatura> create(@Valid @RequestBody Viatura viatura){
        Viatura viaturaCreated = service.create(viatura);
        return ResponseEntity.status(HttpStatus.CREATED).body(viaturaCreated);
    }

    // READ ===================================================================================
    @GetMapping
    public ResponseEntity<List<Viatura>> findAll(){
        List<Viatura> viaturas;
        viaturas = service.findAll();

        return ResponseEntity.ok(viaturas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Viatura> findById(@PathVariable UUID id) {
        Viatura viatura = service.findById(id);
        return ResponseEntity.ok(viatura);
    }

    // UPDATE =================================================================================
    @PutMapping("/{id}")
    public ResponseEntity<Viatura> update(@PathVariable UUID id, @RequestBody @Valid Viatura viatura){
        Viatura viaturaUpdated = service.update(id, viatura);
        return ResponseEntity.ok(viaturaUpdated);
    }

    // DELETE =================================================================================
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
