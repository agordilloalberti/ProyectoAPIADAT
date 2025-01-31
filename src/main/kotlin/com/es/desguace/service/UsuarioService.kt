package com.es.desguace.service

import com.es.desguace.model.Usuario
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import com.es.desguace.repository.UsuarioRepository

@Service
class UsuarioService() : UserDetailsService {

    @Autowired
    private lateinit var usuarioRepository: UsuarioRepository

    override fun loadUserByUsername(username: String?): UserDetails {
        val usuario: Usuario = usuarioRepository
            .findByUsername(username ?: throw IllegalArgumentException("Username cannot be null"))
            .orElseThrow { IllegalArgumentException("User not found") }

        return User.builder()
            .username(usuario.username)
            .password(usuario.password)
            .roles(usuario.roles)
            .build()
    }

    fun registerUsuario(usuario: Usuario): Usuario {
        if (usuarioRepository.findByUsername(usuario.username.orEmpty()).isPresent) {
            throw IllegalArgumentException("Username is already taken")
        }

        return usuarioRepository.save(usuario)
    }
}
