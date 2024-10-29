package com.diogodemetrius.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diogodemetrius.mysql.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    // Você pode adicionar métodos de consulta personalizados aqui, se precisar
}
