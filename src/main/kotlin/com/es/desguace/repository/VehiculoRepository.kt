package com.es.desguace.repository

import com.es.desguace.model.Vehiculo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface VehiculoRepository : JpaRepository<Vehiculo, Long> {

    fun findById(id: Int) : Optional<Vehiculo>

}