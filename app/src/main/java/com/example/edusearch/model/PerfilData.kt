package com.example.edusearch.model

object PerfilData {
    val perfil = PerfilEstudiante(//llamada al copnstructor
        nombre = "Gabriel Stiven Chavez Castro",
        programa = "Ingeniería de Sistemas",
        semestre = 5,
        descripcion = "Estudiante apasionado por el desarrollo de software...",
        edad = 19,
        ciudad = "Chia Cundinamarca",
        correo = "gschavez@ucundinamarca.edu.co",
        hobbies = listOf("Programar", "Escuchar música", "Leer", "Tocar la guitarra"),
        pasatiempos = listOf("Ver series", "Jugar videojuegos", "Armar rompecabezas"),
        deportes = listOf("Basquet", "Ciclismo", "Voleyball","Futball", "Tenis de mesa" ),
        intereses = listOf("Inteligencia Artificial", "Desarrollo móvil", "Backend con Spring Boot", "Redes","Ciber seguridad","Filosofia","Ciencias")
    )//variables instanciadas
}