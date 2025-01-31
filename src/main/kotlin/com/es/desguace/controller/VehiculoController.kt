package com.es.desguace.controller

import com.es.desguace.model.Vehiculo
import com.es.desguace.service.VehiculoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/vehiculos")
class VehiculoController {

    @Autowired
    private lateinit var vehiculoService: VehiculoService

    @PostMapping("/registrar")
    fun registrarVehiculo(
        @RequestBody vehiculo: Vehiculo): Vehiculo? {
        return vehiculoService.addVehiculo(vehiculo)
    }

    @DeleteMapping("/desguazar")
    fun desguazarVehiculo(
        @RequestBody id: Long){
        vehiculoService.deleteVehiculo(id)
    }

    @PutMapping("/actualizar{id}")
    fun editarVehiculo(
        @PathVariable id: Long,
        @RequestBody vehiculo: Vehiculo
    ){
        vehiculoService.updateVehiculo(id,vehiculo)
    }

}