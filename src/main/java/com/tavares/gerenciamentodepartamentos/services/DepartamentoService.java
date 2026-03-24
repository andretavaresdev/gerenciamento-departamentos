package com.tavares.gerenciamentodepartamentos.services;

import com.tavares.gerenciamentodepartamentos.models.Departamento;
import com.tavares.gerenciamentodepartamentos.repositories.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService {
    @Autowired
    private DepartamentoRepository repository;

    public Departamento salvar(Departamento departamento){
        return repository.save(departamento);
    }

    public List<Departamento> listarTodos(){
        return repository.findAll();
    }

    public Optional<Departamento> buscarPorId(Long id){
        return repository.findById(id);
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }
}
