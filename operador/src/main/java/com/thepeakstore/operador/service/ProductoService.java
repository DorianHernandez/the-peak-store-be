package com.thepeakstore.operador.service;

import com.thepeakstore.operador.model.Producto;
import com.thepeakstore.operador.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    private final ProductoRepository repo;

    public ProductoService(ProductoRepository repo) {
        this.repo = repo;
    }

    public List<Producto> getAll() {
        return repo.findAll();
    }

    public Optional<Producto> getById(int id) {
        return repo.findById(id);
    }

    public List<Producto> getProductsFiltered(String name, String brand, String category) {
        return repo.findAll().stream()
                .filter(p -> name == null || p.getName().toLowerCase().contains(name.toLowerCase()))
                .filter(p -> brand == null || p.getBrand().equalsIgnoreCase(brand))
                .filter(p -> category == null || p.getCategory().equalsIgnoreCase(category))
                .toList();
    }
}