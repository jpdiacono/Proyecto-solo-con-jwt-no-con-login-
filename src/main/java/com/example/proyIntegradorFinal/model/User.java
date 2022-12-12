package com.example.proyIntegradorFinal.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Entity
public class User implements UserDetails {
        @Id
        @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
        private Long id;
        private String nombre;
        private String userName;
        private String email;
        private String password;
        @Enumerated(EnumType.STRING)
        private Rol rol;

    public User() {
    }

    public User(String nombre, String userName, String email, String password, Rol rol) {
        this.nombre = nombre;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.rol = rol;
    }

    @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(rol.name());
            return Collections.singletonList(grantedAuthority);
        }

        @Override
        public String getPassword() {
            return password;
        }

        @Override
        public String getUsername() {
            return userName;
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }

}
