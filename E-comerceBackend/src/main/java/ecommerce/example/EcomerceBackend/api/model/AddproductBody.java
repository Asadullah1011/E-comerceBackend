package ecommerce.example.EcomerceBackend.api.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.security.PrivateKey;

public class AddproductBody {


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }


    private Long Id;


    @Size(min=3, max=255)
    private String name;



    private String shortDescription;
    private String longDescription;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


    private Double price;


}
