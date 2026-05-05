package warehouse.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import warehouse.model.ProductData;
import warehouse.repository.WarehouseRepository;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private WarehouseRepository repository;

    // POST /product
    @PostMapping("/product")
    public ProductData addProduct(@RequestBody ProductData product) {
        return repository.save(product);
    }

    // GET /product
    @GetMapping("/product")
    public List<ProductData> getAllProducts() {
        return repository.findAll();
    }

    // GET /product/{id}
    @GetMapping("/product/{id}")
    public ProductData getByProductID(@PathVariable String id) {
        return repository.findByProductID(id);
    }

    // DELETE /product/{id}
    @DeleteMapping("/product/{id}")
    public String deleteProduct(@PathVariable String id) {
        ProductData p = repository.findByProductID(id);
        if (p != null) {
            repository.delete(p);
            return "Deleted";
        }
        return "Not found";
    }

    // GET /warehouse/{id}
    @GetMapping("/warehouse/{id}")
    public List<ProductData> getByWarehouse(@PathVariable String id) {
        return repository.findByWarehouseID(id);
    }
}