package com.example.demo.cliente.repository;

import com.example.demo.cliente.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
