/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.saks.biblioteca.controller;

import br.com.saks.biblioteca.model.Emprestimo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import br.com.saks.biblioteca.repository.EmprestimoRepossitory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author Paola Zanella
 */
@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {
  
  @Autowired
    private EmprestimoRepossitory emprestimoRepository;

    @GetMapping
    public List<Emprestimo> listarTodos() {
        return emprestimoRepository.findAll();
    }

    @GetMapping(value="/{id}")
    public Optional<Emprestimo> listarPeloId(@PathVariable Long id) {
        return emprestimoRepository.findById(id);
    }

    @PostMapping
    public Emprestimo adicionar(@RequestBody Emprestimo emprestimo) {
        return emprestimoRepository.save(emprestimo);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity editar(@PathVariable Long id, @RequestBody Emprestimo emprestimo) {
        return emprestimoRepository.findById(id)
                .map(record -> {
                    record.setStatus(emprestimo.getStatus());
                    Emprestimo emprestimoUpdated = emprestimoRepository.save(record);
                    return ResponseEntity.ok().body(emprestimoUpdated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity deletar(@PathVariable Long id) {
        return emprestimoRepository.findById(id)
                .map(record-> {
                    emprestimoRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
    
 

    
}
