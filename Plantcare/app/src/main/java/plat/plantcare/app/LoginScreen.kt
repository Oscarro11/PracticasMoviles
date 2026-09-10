package plat.plantcare.app

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import plat.plantcare.app.ui.theme.PlusJakartaSansFamily

@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen(){
    LoginScreen()
}

@Composable
fun LoginScreen(modifier: Modifier = Modifier){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier.then(
            other = Modifier
                .background(color = MaterialTheme.colorScheme.secondary)
                .fillMaxSize()
        )
    ) {
        Text(
            text = "Hello"
        )
    }
}