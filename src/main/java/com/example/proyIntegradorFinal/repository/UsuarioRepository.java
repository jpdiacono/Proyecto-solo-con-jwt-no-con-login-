package com.example.proyIntegradorFinal.repository;

import com.example.proyIntegradorFinal.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<User,Long> {

    Optional<User> findByUserName(String userName);
}
