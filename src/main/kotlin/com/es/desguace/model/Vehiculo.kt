package com.es.desguace.model

import jakarta.persistence.*

@Entity
@Table(name = "vehiculo")
data class Vehiculo(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = true)
    var modelo: String? = null,

    @Column(nullable = false)
    var valor: Float? = null,

    @ManyToOne()
    @JoinColumn(name = "usuario_id")
    var idPropietario : Usuario?
)
