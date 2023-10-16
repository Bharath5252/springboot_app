package com.example.demo.Controller;

import com.example.demo.Model.product;
import com.example.demo.Repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api")


public class productcontroller {
    @Autowired
    private ProductRepository productrepo;

    @PostMapping("/addproduct")
    public String saveproduct(@RequestBody product temp){
            productrepo.save(temp);

            return "Added Successfully";
    }

    @GetMapping("/findAllproducts")
    public List<product> getproducts () {
        return productrepo.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteproduct (@PathVariable String id){
        productrepo.deleteById(id);
        return "Deleted Successfully";
 
    }

    @GetMapping("/Edit/{id}")
    public ResponseEntity<product> findid (@PathVariable String id){
        Optional<product> temp =productrepo.findById(id);
        return temp.map(response -> ResponseEntity.ok().body(response))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/Edit/{id}")
    public String editdone(@RequestBody product temp){
        productrepo.save(temp); 
        return "Added Successful";
    }
}
