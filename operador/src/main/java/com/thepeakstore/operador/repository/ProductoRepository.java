package com.thepeakstore.operador.repository;

import com.thepeakstore.operador.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}