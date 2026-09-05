package plat.practica.lab6

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.TextAutoSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp

@Composable
fun Metric(name: String, currentValue: Int?, modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .padding( horizontal = 20.dp, vertical = 7.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = name,
            fontWeight = FontWeight.Bold,
            autoSize = TextAutoSize.StepBased(
                minFontSize = 20.sp,
                maxFontSize = 25.sp,
                stepSize = 1.sp
            )
        )

        Text(
            text = currentValue?.toString() ?: "",
            autoSize = TextAutoSize.StepBased(
                minFontSize = 10.sp,
                maxFontSize = 20.sp,
                stepSize = 1.sp
            )
        )
    }
}

@Composable
fun ChangeBox(value: Int, positive: Boolean, modifier: Modifier = Modifier){
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(width = 0.dp, height = 40.dp)
            .clip(shape = RoundedCornerShape(10.dp))
            .background(color =
                if (positive) {
                    lerp(start = Color.Green, stop = Color.Black, fraction = 0.3f)
                } else {
                    lerp(start = Color.Red, stop = Color.Black, fraction = 0.3f)
                }
            )
    ){
        Text(
            text = value.toString(),
            textAlign = TextAlign.Center,
            fontSize = 6.em,
            color = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MetricPreview(){
    Metric(
        name = "Total incrementos: ",
        currentValue = 3
    )
}

@Preview(showBackground = true)
@Composable
fun ChangeBoxPreview(){
    ChangeBox(
        value = 5,
        positive = false
    )
}