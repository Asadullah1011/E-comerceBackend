package ecommerce.example.EcomerceBackend.service;


import ecommerce.example.EcomerceBackend.model.Dao.ProductDAO;
import ecommerce.example.EcomerceBackend.model.Product;
import org.springframework.stereotype.Service;
import ecommerce.example.EcomerceBackend.model.WebOrderQuantities;

import ecommerce.example.EcomerceBackend.api.model.AddproductBody;
import java.util.List;

@Service
public class ProductService {

    private ProductDAO productDAO;

    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public List<Product> getProducts()
    {
        return productDAO.findAll();
    }


    public Product AddProduct(AddproductBody addproduct)
    {

        Product product = new Product();
        product.setId(addproduct.getId());
        product.setName(addproduct.getName());
        product.setShortDescription(addproduct.getShortDescription());
        product.setLongDescription(addproduct.getLongDescription());
        product.setPrice(addproduct.getPrice());
        return productDAO.save(product);
    }
    //public void deleteProductDetails(long productId)
    //{productDAO.deleteById(productId);}


}
