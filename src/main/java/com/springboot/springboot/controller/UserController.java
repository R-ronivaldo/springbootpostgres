package com.springboot.springboot.controller;
import java.util.List;
import java.util.Optional;

import com.springboot.springboot.model.UserModel;
import com.springboot.springboot.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Users")
public class UserController {    
    @Autowired
    private UserRepository userRepository;
    
    @GetMapping("/{id}")
    public UserModel userr(@PathVariable("id") int id) {
        Optional<UserModel> userFind = this.userRepository.findById(id);

        if (userFind.isPresent()) {
            return userFind.get();
        }

        return null;
    }

    @PostMapping("/")
    public UserModel userr(@RequestBody UserModel userr){
        return this.userRepository.save(userr);
    }

    @GetMapping("/List")
    public List<UserModel> list(){
        return this.userRepository.findAll();
    }

    @GetMapping("/List/{name}")
    public List<UserModel> findByName(@PathVariable("name") String name){
        return this.userRepository.findByNameIgnoreCase(name);
    }
}
