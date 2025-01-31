package com.es.desguace.controller

import com.es.desguace.model.Usuario
import com.es.desguace.service.TokenService
import com.es.desguace.service.UsuarioService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/usuarios")
class UsuarioController {

    @Autowired
    private lateinit var usuarioService: UsuarioService

    @Autowired
    private lateinit var authenticationManager: AuthenticationManager

    @Autowired
    private lateinit var tokenService: TokenService

    @PostMapping("/register")
    fun register(
        @RequestBody newUsuario: Usuario
    ) : ResponseEntity<Usuario?>? {

        if (newUsuario.username== null || newUsuario.password==null || newUsuario.roles==null){
            return ResponseEntity(null, HttpStatus.BAD_REQUEST)
        }else if(newUsuario.roles=="USER_ADMIN"){
            return ResponseEntity(null, HttpStatus.UNAUTHORIZED)
        }

        usuarioService.registerUsuario(newUsuario)

        return ResponseEntity(newUsuario, HttpStatus.CREATED)

    }

    @PostMapping("/login")
    fun login(@RequestBody usuario: Usuario) : ResponseEntity<Any>? {

        val authentication: Authentication
        try {
            authentication = authenticationManager.authenticate(UsernamePasswordAuthenticationToken(usuario.username, usuario.password))
        } catch (e: AuthenticationException) {
            return ResponseEntity(mapOf("mensaje" to "Credenciales incorrectas"), HttpStatus.UNAUTHORIZED)
        }

        var token: String = tokenService.generarToken(authentication)


        return ResponseEntity(mapOf("token" to token), HttpStatus.CREATED)
    }

}