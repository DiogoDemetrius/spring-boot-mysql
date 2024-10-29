package com.diogodemetrius.mysql.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diogodemetrius.mysql.domain.User;
import com.diogodemetrius.mysql.dto.UserDTO;
import com.diogodemetrius.mysql.exception.ObjectNotFoundException;
import com.diogodemetrius.mysql.repository.UserRepository;

@Service
public class UserServices {
    
    @Autowired
    private UserRepository repo;
    
    // Método para retornar todos os usuários
    public List<User> findAll() {
        return repo.findAll();
    }
    
    // Método para buscar um usuário pelo ID
    public User findById(String id) {
        Optional<User> user = repo.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
    
    //Metodo POST Usuário
    public User insert(User obj) {
    	return repo.save(obj);
    }
    
    public User fromDTO(UserDTO objDto) {
    	return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }
}
