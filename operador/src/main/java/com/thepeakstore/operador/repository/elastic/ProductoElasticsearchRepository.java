package com.thepeakstore.operador.repository.elastic;

import com.thepeakstore.operador.model.Producto;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProductoElasticsearchRepository extends ElasticsearchRepository<Producto, Integer> {
}
