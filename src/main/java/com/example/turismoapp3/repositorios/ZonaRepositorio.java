package com.example.turismoapp3.repositorios;

import com.example.turismoapp3.modelos.Zona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZonaRepositorio extends JpaRepository<Zona, Integer> {
}
