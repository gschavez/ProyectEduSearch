package com.example.edusearch.model

data class PerfilEstudiante(  //El "data class" lo use para que me genere los getter y setter,ademas del constructor primario
    val nombre: String,       //Esta clase solo guardaran informacion
    val programa: String,
    val semestre: Int,
    val descripcion: String,
    val edad: Int,
    val ciudad: String,
    val correo: String,
    val hobbies: List<String>,
    val pasatiempos: List<String>,
    val deportes: List<String>,
    val intereses: List<String>
)