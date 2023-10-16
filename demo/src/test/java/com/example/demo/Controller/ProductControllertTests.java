package com.example.demo.Controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.ResponseEntity;

import com.example.demo.Model.product;
import com.example.demo.Repository.ProductRepository;

@ExtendWith(MockitoExtension.class)
public class ProductControllertTests{
    
    @InjectMocks
    productcontroller productcontroller_instace;

    @Mock
    ProductRepository productrepo;
    

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    private List<product> getProductList() {
        product p1 = new product();
        p1.name="Fruit1";
        p1.price="200";
        p1.description="Fruit1-desc";


        product p2 = new product();
        p2.name="Fruit2";
        p2.price="300";
        p2.description="Fruit2-desc";

        List<product> productList = new ArrayList<>();
        productList.add(p1);
        productList.add(p2);
        return  productList;
    }

    @Test
    public void productcontroller_findallproducts(){

        List <product>sample_productlist=getProductList();


        //fake
        when(productrepo.findAll()).thenReturn(sample_productlist);
        
        //test
        List<product> products = productcontroller_instace.getproducts();

        //assert
        assertThat(products.get(0).name).isEqualTo("Fruit1");
        assertThat(products.get(1).name).isEqualTo("Fruit2");

        assertThat(products.get(0).price).isEqualTo("200");
        assertThat(products.get(1).price).isEqualTo("300");


        assertThat(products.get(0).description).isEqualTo("Fruit1-desc");
        assertThat(products.get(1).description).isEqualTo("Fruit2-desc");

         //System.out.println(products.get(0).name);
        
    }

    

    // @Test
    // public void productcontroller_save(){
    //      List<product>sample_productlist = getProductList();
         
    //      //fake
    //      //String s="Added Successfully";
    //      when(productrepo.save(sample_productlist.get(0))).thenReturn(Optional.of("Added Successfully"));
         


    // }
    

    @Test
    public void productcontroller_findid(){

        List<product>sample_productlist = getProductList();

        //fake
        when(productrepo.findById("0")).thenReturn(Optional.of(sample_productlist.get(0)));

        //test

        ResponseEntity<product> response= productcontroller_instace.findid("0");
       
        //assert
        assertThat(response.getBody().name).isEqualTo("Fruit1");
        assertThat(response.getBody().price).isEqualTo("200");
        assertThat(response.getBody().description).isEqualTo("Fruit1-desc");

    }
}


