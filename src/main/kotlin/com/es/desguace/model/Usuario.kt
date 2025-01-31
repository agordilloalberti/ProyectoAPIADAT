package com.es.desguace.model

import jakarta.persistence.*

@Entity
@Table(name = "usuario")
data class Usuario(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var usuarios_id: Long? = null,

    @Column(unique = true, nullable = false)
    var username: String? = null,

    @Column(nullable = false)
    var password: String? = null,

    @Column(nullable = false)
    var roles : String? = null,
//    Roles still WIP
   // var roles: Rol? = null

    @ManyToOne()
    @JoinColumn(name = "desguace_id")
    var desguace: Desguace? = null,

    @OneToMany(mappedBy = "id", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var vehiculos : MutableList<Vehiculo>? = null

)
