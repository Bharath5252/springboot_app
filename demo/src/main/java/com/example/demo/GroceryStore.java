// package com.example.demo;

// import java.io.File;
// import java.io.FileInputStream;
// import java.io.FileNotFoundException;
// import java.io.IOException;
// import java.io.InputStream;
// import java.util.ArrayList;
// import java.util.List;

// import javax.xml.bind.JAXBContext;
// import javax.xml.bind.JAXBException;
// import javax.xml.bind.Unmarshaller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Profile;
// import org.springframework.core.env.Environment;
// import org.springframework.stereotype.Component;
// import org.springframework.stereotype.Service;

// import com.example.demo.Model.product;
// import com.example.demo.Repository.ProductRepository;

// import jakarta.annotation.PostConstruct;

// @Service
// @Component
// public class GroceryStore {

    
//     // JAXBContext jc = JAXBContext.newInstance( "com.acme.foo" );
//     // Unmarshaller u = jc.createUnmarshaller();
//     // Object o = u.unmarshal( is );

//     //static final String STORE_XML = "products.xml";
//     @Autowired
//     private ProductRepository groceryRepo;

//     // @Autowired 
//     // private GroceryTimescale timescaleRepo;

//     @Autowired 
//     private Environment environment;

//     @PostConstruct
//     public void fillDatabase() throws JAXBException, IOException{
//         List< product >  groceryList = new ArrayList<product>();
//         // product grocery1 = new product();
//         // grocery1.description =  "hey I am new here";
//         // grocery1.name = "Oppenhiemer";
//         // grocery1.price = "110000";
        
//         // groceryList.add(grocery1);

//         List<product> final_list = convertXMLToObject().getGroceryList();

//         groceryList.addAll(final_list);
//         //if(environment.getActiveProfiles()[0].equals("mongo")){
//             groceryRepo.saveAll(groceryList);
//         // }
//         //     else{
//                 // timescaleRepo.saveAll(groceryList);
//         // }
//     }

//     private static GroceryList convertXMLToObject() throws FileNotFoundException{
//         try{

//             InputStream is = new FileInputStream("/app/src/main/resources/static/products.xml");

//             JAXBContext context = JAXBContext.newInstance(GroceryList.class);
//             Unmarshaller un = context.createUnmarshaller();
//             GroceryList groceryList1 = (GroceryList) un.unmarshal(is);

//             return groceryList1;
//         }
//         catch(JAXBException e){ 
//             e.printStackTrace();
//         }
//         return null;
//     }

// }
