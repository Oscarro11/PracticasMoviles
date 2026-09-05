package plat.practica.lab6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.text.TextAutoSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import plat.practica.lab6.ui.theme.Lab6Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab6Theme {
                Calculator()
            }
        }
    }
}

@Composable
fun Calculator(modifier: Modifier = Modifier) {
    var countState by remember { mutableIntStateOf(0) }
    var increments by rememberSaveable { mutableIntStateOf(0) }
    var decrements by rememberSaveable { mutableIntStateOf(0) }
    var max by rememberSaveable { mutableIntStateOf(0) }
    var min by rememberSaveable { mutableIntStateOf(0) }
    var changesCount by rememberSaveable { mutableIntStateOf(0) }
    val changeList = remember { mutableStateListOf<Change>() }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
                .weight(0.1f)
        ){
            Text(
                text = "Oscar Melchor",
                autoSize = TextAutoSize.StepBased(
                    minFontSize = 20.sp,
                    maxFontSize = 35.sp,
                    stepSize = 1.sp
                ),
                textAlign = TextAlign.Center
            )
        }

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.15f)
        ) {

            IconButton(
                onClick = {
                    countState--
                    decrements++
                    if (min > countState) min = countState
                    changesCount++

                    changeList.add(Change(value = countState, positive = false))
                },
                modifier = Modifier
                    .padding(horizontal = 10.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.baseline_remove_circle_24),
                    contentDescription = null,
                    tint = lerp(start = Color.Blue,  stop = Color.Black,  fraction = 0.4f),
                    modifier = Modifier
                        .size(48.dp)
                )
            }

            Text(
                text = countState.toString(),
                fontWeight = FontWeight.Bold,
                autoSize = TextAutoSize.StepBased(
                    minFontSize = 10.sp,
                    maxFontSize = 70.sp,
                    stepSize = 1.sp
                )
            )

            IconButton(
                onClick = {
                    countState++
                    increments++
                    if (max < countState) max = countState
                    changesCount++

                    changeList.add(Change(value = countState, positive = true))
                },
                modifier = Modifier
                    .padding(horizontal = 10.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.baseline_add_circle_24),
                    contentDescription = null,
                    tint = lerp(start = Color.Blue,  stop = Color.Black,  fraction = 0.4f),
                    modifier = Modifier
                        .size(40.dp)
                )
            }
        }

        Spacer(
            modifier = Modifier
                .border(width = 3.dp, color = Color.Gray)
                .fillMaxWidth()
                .weight(0.001f)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(2.dp)
                .weight(0.36f)
        ){
            Metric( name = "Total incrementos: ", currentValue = increments )
            Metric( name = "Total decrementos: ", currentValue = decrements )
            Metric( name = "Valor máximo: ", currentValue = max )
            Metric( name = "Valor mínimo: ", currentValue = min )
            Metric( name = "Total cambios: ", currentValue = changesCount )
            Metric( name = "Historial: ", currentValue = null)
        }


        LazyVerticalGrid(
            columns = GridCells.Fixed(5),
            contentPadding = PaddingValues(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.44f)
        ) {
            items(changeList) { change ->
                ChangeBox(
                    value = change.value,
                    positive = change.positive
                )
            }
        }

        Button(
            onClick = {
                countState = 0
                increments = 0
                decrements = 0
                max = 0
                min = 0
                changesCount = 0
                changeList.clear()
            },
            colors = ButtonColors(
                containerColor = lerp(start = Color.Blue,  stop = Color.Black,  fraction = 0.4f),
                contentColor = Color.White,
                disabledContainerColor = Color.White,
                disabledContentColor = Color.White
            ),
            modifier = Modifier
                .weight(0.1f)
                .fillMaxWidth()
                .padding(15.dp)
        ) {
            Text(
                text = "Reiniciar",
                color = Color.White,
                autoSize = TextAutoSize.StepBased(
                    minFontSize = 10.sp,
                    maxFontSize = 40.sp,
                    stepSize = 1.sp
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CalculatorPreview(){
    Calculator()
}