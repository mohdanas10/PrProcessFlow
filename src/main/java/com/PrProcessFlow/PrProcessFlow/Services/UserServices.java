package com.PrProcessFlow.PrProcessFlow.Services;

import com.PrProcessFlow.PrProcessFlow.Entity.User;
import com.PrProcessFlow.PrProcessFlow.Repository.UserRepo;
import com.PrProcessFlow.PrProcessFlow.dto.UserDTO;
import com.PrProcessFlow.PrProcessFlow.util.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Component
public class UserServices implements CommandLineRunner {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;


    @Override
    public void run(String... args) throws Exception {
        // Check if any admin already exists
        User admin = userRepo.findByEmailId("admin@zeptonow.com").orElse(null);
        if (admin == null) {
            User newAdmin = new User();
            newAdmin.setUserName("System Admin");
            newAdmin.setEmailId("admin@zeptonow.com");
            newAdmin.setPassword(passwordEncoder.encode("Anas@580")); // ⚠️ store encrypted if you add security later
            newAdmin.setRole("ADMIN");

            userRepo.save(newAdmin);
            System.out.println("✅ Default admin created -> email: admin@example.com | password: admin123");
        } else {
            System.out.println("ℹ️ Admin already exists: " + admin.getEmailId());
        }
    }

    public User addUser(User user){ // add user logic here

        User user1 = userRepo.findByEmailId(user.getEmailId()).orElse(null);
        if(user1 != null && user1.getEmailId().equals(user.getEmailId())){
            return null;
        }




            user.setPassword(passwordEncoder.encode(user.getPassword()));
            User newUser = this.userRepo.save(user);
            if(newUser != null && newUser.getId() > 0){
                return user;
            }
            else {
                return null;
            }

    }

    public List<User> getAllUser(){
        return this.userRepo.findAll();
    }

    public UserDTO login(User user) {
        User user1 = userRepo.findByEmailId(user.getEmailId())
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + user.getEmailId()));

        if (passwordEncoder.matches(user.getPassword(), user1.getPassword())) {
            String token = jwtService.generateToken(user1.getEmailId(),user1.getRole());

            return new UserDTO(
                    user1.getUserName(),
                    user1.getEmailId(),
                    user1.getRole(),
                    token
            );
        }
        return null;
    }


    public String deleteUser ( int id){
        User user = this.userRepo.findById(id);
        if(user != null){
            this.userRepo.delete(user);
            return "User Deleted Successfully";
        }
        else {
            return "User Deleted Failed";
        }
    }

    public String updateUser(int id , User user){
        User user1 = this.userRepo.findById(id);
        if(user1 != null && user1.getEmailId().equals(user.getEmailId())){
            user1.setRole(user.getRole());
            this.userRepo.save(user1);
            return "User Updated Successfully";
        }
        else {
            return "User Updated Failed";
        }
    }
}
