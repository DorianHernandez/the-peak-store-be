package com.thepeakstore.operador.service;

import com.thepeakstore.operador.model.Producto;
import com.thepeakstore.operador.repository.elastic.ProductoElasticsearchRepository;
import com.thepeakstore.operador.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class ProductoService {

    private final ProductoRepository repo;
    private final ProductoElasticsearchRepository elasticRepo;

    public ProductoService(ProductoRepository repo, ProductoElasticsearchRepository elasticRepo) {
        this.repo = repo;
        this.elasticRepo = elasticRepo;
    }

    public List<Producto> getAll() {
        return repo.findAll();
    }

    public Optional<Producto> getById(int id) {
        return repo.findById(id);
    }

    public List<Producto> getProductsFiltered(String name, String brand, String category) {
        // Primero intentamos buscar en Elasticsearch si hay algún criterio de búsqueda
        if (name != null || brand != null || category != null) {
            return StreamSupport.stream(elasticRepo.findAll().spliterator(), false)
                    .filter(p -> name == null || p.getName().toLowerCase().contains(name.toLowerCase()))
                    .filter(p -> brand == null || p.getBrand().equalsIgnoreCase(brand))
                    .filter(p -> category == null || p.getCategory().equalsIgnoreCase(category))
                    .toList();
        }
        return repo.findAll();
    }
    
    public void syncToElastic() {
        List<Producto> products = repo.findAll();
        elasticRepo.saveAll(products);
    }
}