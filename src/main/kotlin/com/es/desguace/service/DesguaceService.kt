package com.es.desguace.service

import com.es.desguace.model.Desguace
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import com.es.desguace.repository.DesguaceRepository

@Service
class DesguaceService() {

    @Autowired
    private lateinit var desguaceRepository: DesguaceRepository

    fun createDesguace(desguace: Desguace): Desguace?{
        return desguaceRepository.save(desguace)
    }

    fun deleteDesguace(id: Long){
        try {
            val desguace = desguaceRepository.findById(id).orElseThrow()
            desguaceRepository.delete(desguace)
        }catch (_: Exception){
            throw IllegalArgumentException("Desguace not found")
        }
    }

    fun updateDesguace(id: Long,desguaceNew: Desguace){
        try {
            val desguaceOld = desguaceRepository.findById(id).get()
            desguaceNew.desguaceId = desguaceOld.desguaceId
            desguaceRepository.delete(desguaceOld)
            desguaceRepository.save<Desguace>(desguaceNew)
        }catch (_: Exception){
            throw IllegalArgumentException("Desguace not found")
        }
    }
}