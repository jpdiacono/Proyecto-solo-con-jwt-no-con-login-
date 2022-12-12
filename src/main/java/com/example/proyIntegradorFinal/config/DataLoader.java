package com.example.proyIntegradorFinal.config;

import com.example.proyIntegradorFinal.model.Rol;
import com.example.proyIntegradorFinal.model.User;
import com.example.proyIntegradorFinal.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class DataLoader implements ApplicationRunner {
    private UsuarioRepository userRepository;
    @Override
    public void run(ApplicationArguments args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode("password");
        BCryptPasswordEncoder passwordEncoder2 = new BCryptPasswordEncoder();
        String hashedPassword2 = passwordEncoder2.encode("password2");
        userRepository.save(new User("Juan","Ju","hola@gmail.com",hashedPassword,Rol.ADMIN));
        userRepository.save(new User("Pablo","PA","hola2@gmail.com",hashedPassword2,Rol.USER));
    }


}
