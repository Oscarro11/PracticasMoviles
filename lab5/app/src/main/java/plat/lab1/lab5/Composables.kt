package plat.lab1.lab5

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em

@Composable
fun RouteCard(context: Context, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        shape = RectangleShape,
        colors = CardColors(
            containerColor = MaterialTheme.colorScheme.background,
            contentColor = MaterialTheme.colorScheme.onBackground,
            disabledContainerColor = MaterialTheme.colorScheme.errorContainer,
            disabledContentColor = MaterialTheme.colorScheme.error
        ),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 10.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(
                    text = "Bonanza",
                    fontWeight = FontWeight.Bold,
                    fontSize = 8.em,
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxHeight()
                )

                IconButton(
                    onClick = {
                        context.openGoogleMapsLocation(
                            query = "Bonanza Fraijanes"
                        )
                    },
                    colors = IconButtonColors(
                        containerColor = MaterialTheme.colorScheme.background,
                        contentColor = MaterialTheme.colorScheme.onBackground,
                        disabledContainerColor = MaterialTheme.colorScheme.errorContainer,
                        disabledContentColor = MaterialTheme.colorScheme.onErrorContainer
                    )
                ) {
                    Icon(
                        painter = painterResource( id = R.drawable.baseline_directions_24),
                        tint = MaterialTheme.colorScheme.primary,
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(0.7f)
                    )
                }
            }

            Text(
                text = "Km 18.5 carretera a Sausalito, Fraijanes",
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 4.em,
                modifier = Modifier
                    .height(20.dp)
            )

            Text (
                text = "7:00 AM / 8:00 PM",
                color = MaterialTheme.colorScheme.outline,
                fontSize = 3.em,
                modifier = Modifier
                    .padding(vertical = 6.dp)
                    .height(18.dp)
            )

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .height(40.dp)
                    .fillMaxWidth()
            ) {
                Button(
                    onClick = {
                        Toast.makeText(
                            context,
                            "Nombre: Oscar Rodrigo Melchor Estrada",
                            Toast.LENGTH_SHORT).show()
                    },
                    shape = RoundedCornerShape(6.dp),
                    modifier = Modifier
                        .weight(0.5f)
                        .padding(horizontal = 2.dp)
                ){
                    Text(
                        text = "Iniciar",
                        fontWeight = FontWeight.Light,
                        fontSize = 4.em
                    )
                }

                Button(
                    onClick = {
                        Toast.makeText(
                            context,
                            "Tipo de comida: Desayunos y carnes\nPrecio: Normal (QQ)",
                            Toast.LENGTH_SHORT
                        ).show()
                    },
                    shape = RoundedCornerShape(6.dp),
                    colors = ButtonColors(
                        containerColor = MaterialTheme.colorScheme.background,
                        contentColor = MaterialTheme.colorScheme.onBackground,
                        disabledContentColor = MaterialTheme.colorScheme.inversePrimary,
                        disabledContainerColor = MaterialTheme.colorScheme.inverseOnSurface
                    ),
                    modifier = Modifier
                        .weight(0.5f)
                        .padding(horizontal = 2.dp)
                ){
                    Text(
                        text = "Detalles",
                        fontWeight = FontWeight.Light,
                        fontSize = 4.em
                    )
                }
            }
        }
    }
}