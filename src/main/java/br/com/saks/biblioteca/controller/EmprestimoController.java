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
/**
 *
 * @author Paola Zanella
 */
public class EmprestimoController {
  
    @Autowired
    private EmprestimoRepossitory livroRepository;
    
    @GetMapping
    public List<Emprestimo> listarTodos() {
        return livroRepository.findAll();
    }
    
    @GetMapping(value="/{id}")
    public Optional<Emprestimo> listarPeloId(@PathVariable Long id) {
        return livroRepository.findById(id);
    }
    
    @PostMapping
    public Emprestimo adicionar(@RequestBody Emprestimo livro) {
        return livroRepository.save(livro);
    }
    
 

    
}
