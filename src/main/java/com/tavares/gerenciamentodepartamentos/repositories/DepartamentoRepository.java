package com.tavares.gerenciamentodepartamentos.repositories;

import com.tavares.gerenciamentodepartamentos.models.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {}
