package com.es.desguace.service

import com.es.desguace.model.Vehiculo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import com.es.desguace.repository.VehiculoRepository

@Service
class VehiculoService() {

    @Autowired
    private lateinit var vehiculoRepository: VehiculoRepository

    fun addVehiculo(vehiculo: Vehiculo) : Vehiculo? {
        return vehiculoRepository.save(vehiculo)
    }

    fun deleteVehiculo(id: Long){
        try {
            val vehiculo = vehiculoRepository.findById(id).orElseThrow()
            vehiculoRepository.delete(vehiculo)
        }catch (e: Exception){
            throw IllegalArgumentException("Vehiculo not found")
        }

    }

    fun updateVehiculo(id: Long, vehiculoNew: Vehiculo){
        try {
            val vehiculoOld = vehiculoRepository.findById(id).get()
            vehiculoNew.id = vehiculoOld.id
            vehiculoRepository.delete(vehiculoOld)
            vehiculoRepository.save<Vehiculo>(vehiculoNew)
        }catch (e: Exception){
            throw IllegalArgumentException("Vehiculo not found")
        }
    }
}