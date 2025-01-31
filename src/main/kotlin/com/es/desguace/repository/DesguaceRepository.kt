package com.es.desguace.repository

import com.es.desguace.model.Desguace
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface DesguaceRepository : JpaRepository<Desguace, Long> {

    fun findByDesguaceId(id: Int) : Optional<Desguace>

}