package com.PrProcessFlow.PrProcessFlow.Repository;

import com.PrProcessFlow.PrProcessFlow.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    public Optional<User> findByUserName(String username);
    public User findById(int id);
    public User deleteById(int id);
    public Optional<User> findByEmailId(String email);
    public User findByPassword(String password);

}
