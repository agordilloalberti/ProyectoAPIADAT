package com.es.desguace.controller

import com.es.desguace.model.Desguace
import com.es.desguace.service.DesguaceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/desguace")
class DesguaceController {

    @Autowired
    private lateinit var desguaceService: DesguaceService

    @PostMapping("/abrir")
    fun crearDesguace(
        @RequestBody desguace: Desguace): Desguace?{
        return desguaceService.createDesguace(desguace)
    }

    @DeleteMapping("cerrar")
    fun cerrarDesguace(
        @RequestBody id: Long){
        desguaceService.deleteDesguace(id)
    }

    @PutMapping("/editar")
    fun editarDesguace(
        @RequestParam id: Long,
        @RequestBody desguace: Desguace
    ){
        desguaceService.updateDesguace(id,desguace)
    }

}