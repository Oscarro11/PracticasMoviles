package plat.lab1.applab4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import plat.lab1.applab4.ui.theme.AppLab4Theme

class MainActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppLab4Theme() {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .border(width = 6.dp, color = Color(red = 6, green = 99, blue = 11))
                        .fillMaxSize()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.escudo_uvg),
                        contentDescription = null,
                        modifier = Modifier
                            .alpha(0.15f)
                            .fillMaxSize(0.8f)
                    )

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxHeight(0.8f)
                            .padding(8.dp)
                    ) {
                        Text (
                            text = "Universidad del Valle de Guatemala",
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            lineHeight = 42.sp,
                            modifier = Modifier.padding(horizontal = 20.dp, vertical = 20.dp)
                        )
                        Text (
                            text = "Programación de plataformas móviles, Sección 30",
                            fontSize = 26.sp,
                            textAlign = TextAlign.Center,
                            lineHeight = 36.sp,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 12.dp)
                        )

                        Row(
                            modifier = Modifier.padding(horizontal = 30.dp, vertical = 15.dp)
                        ) {
                            Text (
                                text = "INTEGRANTES",
                                fontWeight = FontWeight.ExtraBold,
                                modifier = Modifier.padding(horizontal = 30.dp)
                            )

                            Text (
                                text = "Oscar Melchor\nMatias Maximiliano\nDaniel Leal",
                                textAlign = TextAlign.Center
                            )
                        }

                        Row(
                            modifier = Modifier.padding(horizontal = 30.dp)
                        ) {
                            Text (
                                text = "CATEDRÁTICO",
                                fontWeight = FontWeight.ExtraBold,
                                modifier = Modifier.padding(horizontal = 30.dp)
                            )

                            Text (
                                text = "Juan Carlos Durini",
                                textAlign = TextAlign.Center
                            )
                        }

                        Text (
                            text = "Oscar Melchor\ncarnet: 25216",
                            lineHeight = 18.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(vertical = 25.dp)
                        )
                    }
                }
            }
        }
    }
}