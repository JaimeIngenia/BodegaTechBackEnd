package com.example.turismoapp3.repositorios;

import com.example.turismoapp3.modelos.Mercancia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MercanciaRepositorio extends JpaRepository<Mercancia,Integer> {
}
