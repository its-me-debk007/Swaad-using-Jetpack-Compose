package `in`.project.swaad.ui.auth

import `in`.project.swaad.R
import `in`.project.swaad.ui.theme.CustomYellow
import `in`.project.swaad.ui.theme.Poppins
import `in`.project.swaad.ui.theme.SwaadTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController

@Preview(showBackground = true)
@Composable
fun VerifyOtp(navController: NavController? = null) {
	val scrollState = rememberScrollState()

	SwaadTheme {
		ConstraintLayout(modifier = Modifier
			.fillMaxWidth()
			.verticalScroll(scrollState)) {
			val (image, heading, verifyBtn,
				dash1, dash2, dash3,
				dash4, timer, resendOtp) = createRefs()

			Image(painter = painterResource(id = R.drawable.verify_otp_image),
				  contentDescription = null, modifier = Modifier.constrainAs(image) {
					start.linkTo(parent.start)
					end.linkTo(parent.end)
					top.linkTo(parent.top, margin = 88.dp)
				})

			Text(buildAnnotatedString {
				withStyle(SpanStyle(fontSize = 24.sp)) {
					append("OTP Verification\n")
				}
				withStyle(SpanStyle(color = Color(0xFF999999), fontSize = 14.sp)) {
					append("Enter the OTP sent to your mail.")
				}
			}, lineHeight = 25.sp, modifier = Modifier.constrainAs(heading) {
				start.linkTo(parent.start, margin = 24.dp)
				end.linkTo(parent.end, margin = 24.dp)
				width = Dimension.fillToConstraints
				top.linkTo(image.bottom, margin = 56.dp)
			}, fontFamily = Poppins)

			Spacer(modifier = Modifier
				.width(40.dp)
				.height(3.dp)
				.background(Color.Black)
				.constrainAs(dash1) {
					top.linkTo(heading.bottom, margin = 72.dp)
				})
			Spacer(modifier = Modifier
				.width(40.dp)
				.height(3.dp)
				.background(Color.Black)
				.constrainAs(dash2) {
					top.linkTo(dash1.top)
				})
			Spacer(modifier = Modifier
				.width(40.dp)
				.height(3.dp)
				.background(Color.Black)
				.constrainAs(dash3) {
					top.linkTo(dash1.top)
				})
			Spacer(modifier = Modifier
				.width(40.dp)
				.height(3.dp)
				.background(Color.Black)
				.constrainAs(dash4) {
					top.linkTo(dash1.top)
				})

			constrain(createHorizontalChain(dash1, dash2, dash3, dash4)) {
				start.linkTo(parent.start, margin = 48.dp)
				end.linkTo(parent.end, margin = 48.dp)
			}

			Button(onClick = { /*TODO*/ }, modifier = Modifier.constrainAs(verifyBtn) {
				top.linkTo(dash1.bottom, margin = 32.dp)
				start.linkTo(parent.start, margin = 24.dp)
				end.linkTo(parent.end, margin = 24.dp)
				width = Dimension.fillToConstraints
			}, contentPadding = PaddingValues(vertical = 14.dp),
				   elevation = ButtonDefaults.elevation(0.dp)) {
				Text(text = "Verify", fontFamily = Poppins)
			}

			Text(text = "0:28", fontSize = 14.sp, fontWeight = FontWeight.Medium,
				 modifier = Modifier.constrainAs(timer) {
					 top.linkTo(verifyBtn.bottom, margin = 16.dp)
					 start.linkTo(parent.start)
					 end.linkTo(parent.end)
				 }, fontFamily = Poppins)

			Text(buildAnnotatedString {
				append("Didn't receive the code? ")
				withStyle(SpanStyle(CustomYellow)) {
					append("Resend Now")
				}
			}, fontSize = 12.sp, fontFamily = Poppins, fontWeight = FontWeight.Medium,
				 modifier = Modifier.constrainAs(resendOtp) {
					 start.linkTo(parent.start)
					 end.linkTo(parent.end)
					 bottom.linkTo(parent.bottom, margin = 8.dp)
					 top.linkTo(timer.bottom, margin = 8.dp)
				 })
		}
	}
}
