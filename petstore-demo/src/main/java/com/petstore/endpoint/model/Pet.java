package com.petstore.endpoint.model;


import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

public class Pet {

    public Pet() {
    }

    public Pet(Integer id, String type, Double price) {
        this.id = id;
        this.type = type;
        this.price = price;
    }

    private Integer id;
private String type;
private Double price;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public Integer getId() {
return id;
}

public void setId(Integer id) {
this.id = id;
}

public String getType() {
return type;
}

public void setType(String type) {
this.type = type;
}

public Double getPrice() {
return price;
}

public void setPrice(Double price) {
this.price = price;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}