package com.thepeakstore.operador.controller;

import com.thepeakstore.operador.model.Producto;
import com.thepeakstore.operador.service.ProductoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import org.springframework.http.ResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ProductoController {

    private final ProductoService service;
        private static final Logger log = LoggerFactory.getLogger(ProductoController.class);

    public ProductoController(ProductoService service) {
        this.service = service;
    }
    // GET /operador/productos
    @GetMapping("/operador/productos")
    @Operation(
            operationId = "Obtener productos",
            description = "Devuelve todos los productos almacenados. Se pueden aplicar filtros opcionales.",
            summary = "Obtención de múltiples productos."
    )
    @ApiResponse(
            responseCode = "200",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Producto.class))
    )
    public ResponseEntity<List<Producto>> getProducts(
            @RequestHeader Map<String, String> headers,
            @Parameter(name = "name", description = "Nombre del producto (coincidencia parcial).",
                    example = "Curry", required = false)
            @RequestParam(required = false) String name,
            @Parameter(name = "brand", description = "Marca del producto (exacta).",
                    example = "Nike", required = false)
            @RequestParam(required = false) String brand,
            @Parameter(name = "category", description = "Categoría del producto (exacta).",
                    example = "Tenis", required = false)
            @RequestParam(required = false) String category
    ) {

        log.info("Headers recibidos: {}", headers);

        List<Producto> productos = service.getProductsFiltered(name, brand, category);
        return ResponseEntity.ok(productos);
    }
    // GET /operador/productos/{id}
    @GetMapping("/operador/productos/{id}")
    @Operation(
            operationId = "Obtener un producto",
            description = "Devuelve un producto a partir de su ID.",
            summary = "Obtención de un solo producto."
    )
    @ApiResponse(
            responseCode = "200",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Producto.class))
    )
    @ApiResponse(
            responseCode = "404",
            description = "No se encontró un producto con ese ID.",
            content = @Content(mediaType = "application/json")
    )
    public ResponseEntity<?> getProductById(
            @Parameter(name = "id", description = "ID del producto.", example = "1")
            @PathVariable int id
    ) {

        log.info("Solicitud recibida para producto ID {}", id);

        return service.getById(id)
                .map(p -> ResponseEntity.<Object>ok(p))
                .orElse(ResponseEntity.status(404)
                        .body("No se encontró el producto con ID: " + id));
    }
}