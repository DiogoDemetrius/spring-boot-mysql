package com.diogodemetrius.mysql.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.diogodemetrius.mysql.domain.User;
import com.diogodemetrius.mysql.repository.UserRepository;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        
        userRepository.deleteAll();
        
        // Use null para o id, permitindo que o banco de dados gere automaticamente
        User maria = new User("1", "Maria Brown", "maria@gmail.com");
        User alex = new User("2", "Alex Green", "alex@gmail.com");
        User bob = new User("3", "Bob Grey", "bob@gmail.com");
        
        // Usar saveAll para salvar todos de uma vez
        userRepository.saveAll(Arrays.asList(maria, alex, bob));
    }
}
