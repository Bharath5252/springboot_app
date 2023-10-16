// package com.example.demo.Controller;

// import static org.junit.Assert.assertEquals;
// import static org.junit.Assert.assertThat;
// import static org.mockito.Mockito.when;

// import java.util.ArrayList;
// import java.util.List;
// import java.util.Optional;

// import org.junit.Before;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.MockitoAnnotations;
// import org.mockito.junit.jupiter.MockitoExtension;

// import com.example.demo.Repository.userRepository;
// import com.example.demo.Model.user;

// @ExtendWith(MockitoExtension.class)
// public class usercontrollerTests {


//     @InjectMocks
//     usercontroller usercontroller_instance;

//     @Mock
//     userRepository userrepo;

//     @Before
//     public void setUp(){
//        MockitoAnnotations.initMocks(this);
//     }

//     List<user> getuserlist(){
//        user sampleuser=new user();
//        sampleuser.email="mbharani.1269@gmail.com";
//        sampleuser.name="Bharani";
//        sampleuser.password="Qwerty@12345";

//        user sampleuser1 = new user();
//        sampleuser1.email="nonexsistent@gmail.com";
//        sampleuser1.name="non-exsistent";
//        sampleuser1.password="Qwerty@12345";


//        List<user> userlist = new ArrayList<>();

//        userlist.add(sampleuser);
//        userlist.add(sampleuser1);

//        return userlist;
//     }

//     @Test
//     void testLoginuser() {
//       //fake

//        user sampleuser=new user();
//        sampleuser.email="mbharani.1269@gmail.com";
//        sampleuser.name="Bharani";
//        sampleuser.password="Qwerty@12345";

//        List<user> userlist = new ArrayList<>();

//        userlist.add(sampleuser);
          
//        when(userrepo.findByemail("mbharani.1269@gmail.com")).thenReturn(userlist);
       
//        //test
//        String response = usercontroller_instance.loginuser(sampleuser);
       
//        //assert
//        assertEquals(response,"0");

//     }

//     @Test
//     void testSaveuser() {

//     }
// }
