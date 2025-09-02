package com.PrProcessFlow.PrProcessFlow.Controller;

import com.PrProcessFlow.PrProcessFlow.Entity.User;
import com.PrProcessFlow.PrProcessFlow.Services.UserServices;
import com.PrProcessFlow.PrProcessFlow.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(originPatterns = "*")
public class UserController {

    @Autowired
    private UserServices userServices;

    @PostMapping("/add-user")
    public User addUser(@RequestBody User user) {
        return userServices.addUser(user);
    }

    @GetMapping("/get-users")
    public List<User> getAllUsers() {
        return this.userServices.getAllUser();
    }

    @PostMapping("/login")
    public UserDTO login(@RequestBody User user) {
        System.out.println(user);
        System.out.println(user.getEmailId());
        return  this.userServices.login(user);
    }
    @DeleteMapping("/delete-user/{id}")
    public String deleteUser(@PathVariable int id) {
        return this.userServices.deleteUser(id);
    }

    @PutMapping("/update-user/{id}")
    public String updateUser(@PathVariable int id, @RequestBody User user) {
        return  this.userServices.updateUser(id, user);
    }





}
