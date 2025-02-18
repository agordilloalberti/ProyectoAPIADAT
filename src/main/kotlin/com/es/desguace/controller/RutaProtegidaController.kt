package com.es.desguace.controller

import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/rutas_protegidas")
class RutaProtegidaController {

    @GetMapping("/recurso1")
    fun getRecursoProtegidoUno () : String {
        return "Este recurso sólo puede ser accedido por usuarios registrados en la BDD \uD83E\uDD75"
    }

    @GetMapping("/recurso2")
    fun getRecursoProtegidoPublico () : String {
        return "Este recurso puede ser accedido por cualquiera \uD83E\uDD75"
    }

    @GetMapping("/recurso/{id}")
    fun getRecursoProtegido (@PathVariable id: String) : String {
        return "Obtener recurso por su id $id \uD83E\uDD75"
    }

    @DeleteMapping("/recurso/{id}")
    fun deleteRecursoProtegido (@PathVariable id: String) : String {
        return "Eliminar recurso por su id $id \uD83E\uDD75"
    }

    @GetMapping("/usuario_autenticado")
    fun saludarUsuarioAutenticado(authentication: Authentication) : String {
        return "Hola ${authentication.name}, qué tal?"
    }
}