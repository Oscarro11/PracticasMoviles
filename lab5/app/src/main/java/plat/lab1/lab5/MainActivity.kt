@file:Suppress("UnusedImport")
package plat.lab1.lab5

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import plat.lab1.lab5.ui.theme.Lab5Theme

import plat.lab1.lab5.openPlayStoreDetails

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainView()
        }
    }
}

@Composable
fun MainView() {
    Lab5Theme {
        val currentContext = LocalContext.current

        Surface(
            color = MaterialTheme.colorScheme.background,
            shape = RoundedCornerShape(size = 30.dp),
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Surface(
                    shadowElevation = 10.dp,
                    color = MaterialTheme.colorScheme.inversePrimary,
                    modifier = Modifier
                        .weight(0.05f)
                        .fillMaxWidth()
                ) { }
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .weight(0.8f)
                        .fillMaxWidth()
                ) {
                    Surface(
                        shape = RectangleShape,
                        color = MaterialTheme.colorScheme.secondary,
                        modifier = Modifier
                            .weight(0.15f)
                            .fillMaxWidth()
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxSize()
                        ) {
                            IconButton(
                                onClick = {},
                                colors = IconButtonColors(
                                    containerColor = MaterialTheme.colorScheme.tertiary,
                                    contentColor = MaterialTheme.colorScheme.onTertiary,
                                    disabledContainerColor = MaterialTheme.colorScheme.errorContainer,
                                    disabledContentColor = MaterialTheme.colorScheme.onErrorContainer
                                ),
                                modifier = Modifier
                                    .padding(5.dp)
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.baseline_history_24),
                                    contentDescription = null
                                )
                            }

                            Text(
                                text = "Actualización disponible",
                                style = MaterialTheme.typography.bodyMedium
                            )

                            Button(
                                onClick = {
                                    currentContext.openPlayStoreDetails(
                                        appPackageName = "com.netflix.mediaclient"
                                    )
                                },
                                colors = ButtonColors(
                                    containerColor = MaterialTheme.colorScheme.secondary,
                                    contentColor = MaterialTheme.colorScheme.onSecondary,
                                    disabledContainerColor = MaterialTheme.colorScheme.errorContainer,
                                    disabledContentColor = MaterialTheme.colorScheme.onErrorContainer
                                )
                            ) {
                                Text (
                                    text = "Descargar",
                                    color = MaterialTheme.colorScheme.inversePrimary
                                )
                            }
                        }
                    }

                    Row (
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier
                            .weight(0.2f)
                            .fillMaxWidth()
                            .padding(5.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxHeight()
                                .weight(0.4f)
                                .padding(horizontal = 10.dp)
                        ) {
                            Text(
                                text = "Lunes",
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurface,
                                fontSize = 10.em
                            )

                            Text(
                                text = "29 de junio",
                                color = MaterialTheme.colorScheme.onSurface,
                                fontSize = 4.em
                            )
                        }

                        OutlinedButton(
                            onClick = {},
                            shape = RoundedCornerShape(size = 6.dp),
                            modifier = Modifier
                                .padding(horizontal = 15.dp)
                                .align(Alignment.Bottom)
                        ) {
                            Text(
                                text = "Terminar jornada",
                                color = MaterialTheme.colorScheme.primary,
                                fontSize = 3.5.em
                            )
                        }
                    }

                    RouteCard(
                        context = currentContext,
                        modifier = Modifier
                            .weight(0.5f)
                            .padding(horizontal = 15.dp, vertical = 5.dp)
                    )

                    Spacer(
                        modifier = Modifier.weight(1f)
                    )
                }

                Surface(
                    shadowElevation = 10.dp,
                    color = MaterialTheme.colorScheme.inversePrimary,
                    modifier = Modifier
                        .weight(0.05f)
                        .fillMaxWidth()
                ) { }
            }
        }
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun MainViewPreview() {
    MainView()
}