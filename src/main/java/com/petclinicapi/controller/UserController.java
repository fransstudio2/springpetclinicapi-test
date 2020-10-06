package com.petclinicapi.controller;

import java.util.List;

import com.petclinicapi.model.User;
import com.petclinicapi.model.UserRepository;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class UserController {

  // @Autowired
  private UserRepository userRepository;

  // DI
  UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @GetMapping("/users")
  public List<User> index() {
    final List<User> result = this.userRepository.findAll();
    return result;

  }

  // @PutMapping("/users/add")
  @GetMapping("/users/add")
  public boolean add() {
    User u = new User();
    u.setName("Frans1");
    try {
      this.userRepository.save(u);
    } catch (Exception e) {
      return false;
    }
    return true;
  }
}
