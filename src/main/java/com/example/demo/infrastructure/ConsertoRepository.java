package com.example.demo.infrastructure;

import com.example.demo.model.Conserto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsertoRepository extends JpaRepository<Conserto, Long> {
}
