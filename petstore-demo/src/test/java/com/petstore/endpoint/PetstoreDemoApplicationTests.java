package com.petstore.endpoint;

import com.petstore.endpoint.controller.PetStoreController;
import com.petstore.endpoint.model.Pet;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootTest
class PetstoreDemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private PetStoreController petStoreController = new PetStoreController();

    @Test
    public void getAllPetsTest() {
        Pet p1 = new Pet(1, "", 2d);
        Pet p2 = new Pet(1, "", 2d);
        Pet[] petArray = {p1,p2};
        Mockito.when(restTemplate.getForObject("/pets", Pet[].class))
                .thenReturn(petArray);
        ResponseEntity<List<Pet>> responseEntity = petStoreController.getAllPets();
        Assert.assertEquals(petArray.length, responseEntity.getBody().size());
    }

    @Test
    public void getPetByIdTest() {
        Pet p1 = new Pet(1, "dog", 2d);
        Mockito.when(restTemplate.getForObject("/pets/1", Pet.class, Map.class))
                .thenReturn(p1);
        ResponseEntity<Pet> responseEntity = petStoreController.getPetById(1L);
        Assert.assertEquals("dog", responseEntity.getBody().getType());
    }

}
