package br.com.anderson.RestAPI.resources;

import br.com.anderson.RestAPI.models.Product;
import br.com.anderson.RestAPI.services.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Api(value = "API REST - Produtos")
@RestController
@RequestMapping("/products")
public class ProductResource {

    @Autowired
    private ProductService service;

    public ProductResource(ProductService service) {

        this.service = service;
    }

    @GetMapping(produces = "application/json")
    @ResponseBody
    @ApiOperation(value = "List All Products")
    public ResponseEntity<?> listAll() {
        List<Product> produtos = this.service.findAll();

        return new ResponseEntity<List>(produtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "List Product by ID")
    public ResponseEntity<?> findOne(@PathVariable("id") Long id) {
        Product product = this.service.findOne(id);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(code = HttpStatus.CREATED)
    @ApiOperation(value = "Create a new Product")
    public ResponseEntity<?> create(@Valid @RequestBody Product products, Errors errors) {
        if (!errors.hasErrors()) {
            Product productCreated = this.service.create(products);
            return new ResponseEntity<Product>(productCreated, HttpStatus.CREATED);
        }

        return ResponseEntity.badRequest().body(
                errors.getAllErrors().stream().map(msg -> msg.getDefaultMessage()).collect(Collectors.joining(",")));

    }

    @PutMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "Update a Product")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @Valid @RequestBody Product product, Errors errors) {
        Product productExists = this.service.findOne(id);
        if (productExists != null && !errors.hasErrors()) {
            product.setId(productExists.getId());
            Product productUpdate = this.service.create(product);
            return new ResponseEntity<Product>(productUpdate, HttpStatus.OK);
        }
        return ResponseEntity.badRequest().body(
                errors.getAllErrors().stream().map(msg -> msg.getDefaultMessage()).collect(Collectors.joining(",")));
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        this.service.delete(id);

    }
}
