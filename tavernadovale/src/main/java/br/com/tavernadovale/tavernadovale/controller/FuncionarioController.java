package br.com.tavernadovale.tavernadovale.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tavernadovale.tavernadovale.dao.IFuncionario;
import br.com.tavernadovale.tavernadovale.model.Funcionario;

@RestController
@CrossOrigin("*")
@RequestMapping("/funcionario")
public class FuncionarioController{

    @Autowired
    private IFuncionario dao;

    @GetMapping()
    public List<Funcionario> listarFuncionario(){
        return (List<Funcionario>) dao.findAll();
    }

    @PostMapping
    public Funcionario criarFuncionario(@RequestBody Funcionario funcionario){
        Funcionario funcionarioNovo = dao.save(funcionario);
        return funcionarioNovo;
    }

    @PutMapping
    public Funcionario editarFuncionario(@RequestBody Funcionario funcionario){
        Funcionario novoFuncionario = dao.save(funcionario);
        return novoFuncionario;
    }

    @DeleteMapping
    public Optional<Funcionario> exlcuirFuncionario(@PathVariable Integer idFuncionario){
        Optional<Funcionario> funcionario = dao.findById(idFuncionario);
        dao.deleteById(idFuncionario);
        return funcionario;
    }
}