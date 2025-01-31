package com.es.desguace.model

import jakarta.persistence.*

@Entity
@Table(name = "desguace")
data class Desguace(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="desguace_id")
    var desguaceId: Long? = null,

    @Column(nullable = false)
    var capital: Float? = null,

    @OneToMany(mappedBy = "usuarios_id")
    var usuario: MutableList<Usuario>? = null,

    @OneToMany(mappedBy = "id")
    var vehiculos: MutableList<Vehiculo>? = null
)
