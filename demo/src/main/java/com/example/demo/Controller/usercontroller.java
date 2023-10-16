package com.example.demo.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Model.user;
import com.example.demo.Repository.userRepository;

import java.util.List;


@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api")

public class usercontroller {

    @Autowired
    private userRepository userrepo;

    // @PostMapping("/addproduct")
    // public String saveproduct(@RequestBody product temp){
    //         productrepo.save(temp);

    //         return "Added Successfully";
    // }

    // @GetMapping("/findAllproducts")
    // public List<product> getproducts () {
    //     return productrepo.findAll();
    // }

    // @DeleteMapping("/delete/id")
    // public String deleteproduct (@PathVariable String id){
    //     productrepo.deleteById(id);
    //     return "Deleted Successfully";
    // }

    @PostMapping("/signup")
    public String saveuser(@RequestBody user temp){
        if (userrepo.existsByname(temp.getname()) || userrepo.existsByemail(temp.getemail())) {
            return "0";
        }

        
        // String hashedPassword = BCrypt.hashpw(temp.getPassword(), BCrypt.gensalt());
        // temp.setPassword(hashedPassword);

        // Save the user in the database
        userrepo.save(temp);


        return "1";
        
    }


    @PostMapping("/login")
    public String loginuser(@RequestBody user temp){
        
         System.out.println(temp.email);
         //System.out.println(temp.password);

         //boolean x= userrepo.existsByemail(temp.getemail());

         //System.out.println(x);
         
        if(userrepo.existsByemail(temp.getemail())){
             
             List<user> user = userrepo.findByemail(temp.email);

             //System.out.println(user.get(0).password);

             if(user.get(0).password.equals(temp.password)){
                  return "1";
             }

             return "0";
        }

        return "0";
    }



}
