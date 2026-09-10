package plat.plantcare.app.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import plat.plantcare.app.R

// TODO: finish adding the necessary fonts for the app, both in the Family and in the Typography
val PlusJakartaSansFamily = FontFamily(
    Font(resId = R.font.plusjakartasans_bold, weight = FontWeight.Bold),
    Font(resId = R.font.plusjakartasans_light, weight = FontWeight.Light),
    Font(resId = R.font.plusjakartasans_italic, style = FontStyle.Italic),
    Font(resId = R.font.plusjakartasans_medium, weight = FontWeight.Medium),
    Font(resId = R.font.plusjakartasans_regular),
    Font(resId = R.font.plusjakartasans_bold_italic, weight = FontWeight.Bold, style = FontStyle.Italic)
)

val MainTypography = Typography(
    bodyMedium = TextStyle(
        fontFamily = PlusJakartaSansFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)