package com.example.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.User;
import com.example.user.UserRepository;
//import com.example.user.communication.PaymentCartCommunication;

//@Controller// This means that this class is a Controller
@RequestMapping("/user")// This means URL's start with /demo (after Application path)
@RestController
public class UserController {
  @Autowired // This means to get the bean called userRepository
         // Which is auto-generated by Spring, we will use it to handle the data
  private UserRepository userRepository;

  // @Autowired
  // private PaymentCartCommunication communication;

  // @GetMapping("/data")
  // public String getData() {
      
  //     return "From PAYMENT-SERVICE " + communication.getCartInfo();
  // }


  @GetMapping("/message")
  public String getHelloWorld()
  {
    return "Hello World";
  }


  @PostMapping("/add") // Map ONLY POST Requests
  public @ResponseBody String addNewUser (@RequestParam String name
      , @RequestParam String email) {
    // @ResponseBody means the returned String is the response, not a view name
    // @RequestParam means it is a parameter from the GET or POST request

    User n = new User();
    n.setNome(name);
    n.setEmail(email);
    userRepository.save(n);
    return "Saved";
  }

  @GetMapping("/all")
  public @ResponseBody Iterable<User> getAllUsers() {
    // This returns a JSON or XML with the users
    return userRepository.findAll();
  }
}

