package com.example.edusearch.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.edusearch.R
import com.example.edusearch.viewmodel.PerfilViewModel

//Paleta de colores
val BurntUmber = Color(0xFF6D120B)
val Redwood    = Color(0xFFB02A29)
val Macadamia  = Color(0xFFFBF0D8)
val CoolBlue   = Color(0xFF113047)
val LightGrayish = Color(0xFF739AB9)

@Composable
fun PerfilScreen(viewModel: PerfilViewModel = viewModel()) {
    val perfil  = viewModel.perfil
    val mostrar = viewModel.mostrarInfoAdicional

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5EFE6)),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        //HEADER
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        Brush.verticalGradient(listOf(BurntUmber, Redwood))
                    )
                    .padding(top = 48.dp, bottom = 32.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {

                    Box(
                        modifier = Modifier
                            .size(110.dp)
                            .clip(CircleShape)
                            .background(Color.White)
                            .padding(3.dp)
                    ) {
                        Image(//Agrego la imagen de R.drawable
                            painter = painterResource(id = R.drawable.pngegg),
                            contentDescription = "Foto de perfil",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxSize()
                                .clip(CircleShape)
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = perfil.nombre,
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold,
                        color = Macadamia
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "${perfil.programa} · Semestre ${perfil.semestre}",
                        color = LightGrayish,
                        fontSize = 14.sp
                    )
                }
            }
        }

        //DESCRIPCIÓN
        item {
            Spacer(modifier = Modifier.height(16.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .shadow(4.dp, RoundedCornerShape(16.dp)),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        "Sobre mí",
                        fontWeight = FontWeight.Bold,
                        color = CoolBlue,
                        fontSize = 16.sp
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(perfil.descripcion, color = Color.Gray, fontSize = 14.sp)
                }
            }
        }

        //BOTÓN TOGGLE
        item {
            Spacer(modifier = Modifier.height(12.dp))
            Button(
                onClick = { viewModel.toggleInfoAdicional() },
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(containerColor = Redwood),
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    if (mostrar) "Ocultar info adicional" else "Ver info adicional",
                    fontWeight = FontWeight.SemiBold,
                    color = Macadamia
                )
            }
        }

        //INFO ADICIONAL
        if (mostrar) {
            item {
                Spacer(modifier = Modifier.height(8.dp))
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .shadow(4.dp, RoundedCornerShape(16.dp)),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = Macadamia)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            "Información adicional",
                            fontWeight = FontWeight.Bold,
                            color = CoolBlue,
                            fontSize = 16.sp
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        InfoRow(label = "🎂 Edad",    valor = "${perfil.edad} años")
                        InfoRow(label = "📍 Ciudad",  valor = perfil.ciudad)
                        InfoRow(label = "✉️ Correo",  valor = perfil.correo)
                    }
                }
            }
        }

        //SECCIONES/ emojis importados de internet
        item {
            Spacer(modifier = Modifier.height(8.dp))
            SeccionConChips("\uD83C\uDFB8 Hobbies", perfil.hobbies)
        }
        item { SeccionConChips("\uD83C\uDFAD Pasatiempos", perfil.pasatiempos) }
        item { SeccionConChips("\uD83C\uDFC0 Deportes", perfil.deportes) }
        item { SeccionConChips("⭐ Intereses", perfil.intereses) }

        item { Spacer(modifier = Modifier.height(32.dp)) }
    }
}

//InfoRow
@Composable
fun InfoRow(label: String, valor: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(label, fontWeight = FontWeight.Medium, color = CoolBlue, fontSize = 14.sp)
        Text(valor, color = Color.Gray, fontSize = 14.sp)
    }
}

//SeccionConChips
@Composable
fun SeccionConChips(titulo: String, items: List<String>) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 6.dp)
            .shadow(2.dp, RoundedCornerShape(20.dp)),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Macadamia)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                titulo,
                fontWeight = FontWeight.Bold,
                color = CoolBlue,
                fontSize = 16.sp,
                modifier = Modifier.padding(bottom = 10.dp)
            )
            LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                items(items) { item ->
                    Box(
                        modifier = Modifier
                            .border(1.5.dp, Redwood, RoundedCornerShape(50))
                            .padding(horizontal = 14.dp, vertical = 7.dp)
                    ) {
                        Text(
                            text = item,
                            color = BurntUmber,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
        }
    }
}