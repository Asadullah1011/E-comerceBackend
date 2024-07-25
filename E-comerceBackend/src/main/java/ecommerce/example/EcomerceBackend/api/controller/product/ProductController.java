package ecommerce.example.EcomerceBackend.api.controller.product;


import ecommerce.example.EcomerceBackend.Exception.UserAlreadyExistsException;
import ecommerce.example.EcomerceBackend.api.model.RegistrationBody;
import ecommerce.example.EcomerceBackend.model.Product;
import ecommerce.example.EcomerceBackend.service.ProductService;
import ecommerce.example.EcomerceBackend.api.model.AddproductBody;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {


    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts()
    {
        return productService.getProducts();
    }



    @PostMapping("/addProduct")
    public ResponseEntity addProduct(@Valid @RequestBody AddproductBody addproduct)
    {

            productService.AddProduct(addproduct);
            return ResponseEntity.ok().build();


    }


    //@DeleteMapping({"/deleteProductDeatils/{id}"})
    //public void  deleteProductDetails(@PathVariable("productId")  long Id)
    //{
   //    productService.deleteProductDetails(Id);
   // }
}
