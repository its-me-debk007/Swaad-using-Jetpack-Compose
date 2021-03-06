package `in`.project.swaad.ui.theme

import `in`.project.swaad.R
import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val Poppins = FontFamily(
	Font(R.font.poppins_regular, FontWeight.Normal),
	Font(R.font.poppins_medium, FontWeight.Medium),
	Font(R.font.poppins_bold, FontWeight.Bold)
)

val Mulish = FontFamily(
	Font(R.font.mulish_medium, FontWeight.Medium)
)

// Set of Material typography styles to start with
val Typography = Typography(
	defaultFontFamily = Poppins,
//	body1 = TextStyle(
//		fontFamily = FontFamily.Default,
//		fontWeight = FontWeight.Normal,
//		fontSize = 16.sp
//	),
	button = TextStyle(
//		fontFamily = Poppins,
		fontWeight = FontWeight.Bold
	),
	/* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)