package `in`.project.swaad.ui.fragment

import `in`.project.swaad.R
import `in`.project.swaad.ui.theme.Poppins
import `in`.project.swaad.ui.theme.SwaadTheme
import `in`.project.swaad.ui.theme.TextFieldBorderColor
import `in`.project.swaad.ui.theme.TextFieldLabelColor
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.fragment.app.Fragment

class ForgotPasswordFragment : Fragment() {

	override fun onCreateView(inflater: LayoutInflater,
							  container: ViewGroup?,
							  savedInstanceState: Bundle?): View {
		return ComposeView(requireContext()).apply {
			setContent {
				Ui()
			}
		}
	}

	@Preview(showBackground = true)
	@Composable
	fun Ui() {
		var email by rememberSaveable { mutableStateOf("") }
		val scrollState = rememberScrollState()
		val textFieldColors = TextFieldDefaults.outlinedTextFieldColors(
			unfocusedBorderColor = TextFieldBorderColor,
			leadingIconColor = Color.Black,
			trailingIconColor = Color.Black,
			unfocusedLabelColor = TextFieldLabelColor
		)

		SwaadTheme {
			ConstraintLayout(modifier = Modifier
				.fillMaxWidth()
				.verticalScroll(scrollState)) {
				val (image, heading,
					emailTxtField, nextBtn) = createRefs()

				Image(painter = painterResource(id = R.drawable.forgot_password_image),
					  contentDescription = null, modifier = Modifier.constrainAs(image) {
						start.linkTo(parent.start)
						end.linkTo(parent.end)
						top.linkTo(parent.top, margin = 88.dp)
					})

				Text(buildAnnotatedString {
					withStyle(SpanStyle(fontSize = 24.sp)) {
						append("Forgot Password?\n")
					}
					withStyle(SpanStyle(color = Color(0xFF999999), fontSize = 14.sp)) {
						append("Enter the email address associated with your account for OTP.")
					}
				}, modifier = Modifier.constrainAs(heading) {
					start.linkTo(parent.start, margin = 24.dp)
					end.linkTo(parent.end, margin = 24.dp)
					width = Dimension.fillToConstraints
					top.linkTo(image.bottom, margin = 56.dp)
				}, fontFamily = Poppins)

				OutlinedTextField(value = email, onValueChange = { email = it },
								  shape = RoundedCornerShape(32.dp),
								  colors = textFieldColors,
								  singleLine = true,
								  leadingIcon = {
									  Icon(painter = painterResource(id = R.drawable.ic_mail),
										   contentDescription = null)
								  }, label = { Text(text = "Email") },
								  modifier = Modifier.constrainAs(emailTxtField) {
									  start.linkTo(heading.start)
									  end.linkTo(heading.end)
									  width = Dimension.fillToConstraints
									  top.linkTo(heading.bottom, margin = 30.dp)
								  })

				Button(onClick = { /*TODO*/ }, modifier = Modifier.constrainAs(nextBtn) {
					top.linkTo(emailTxtField.bottom, margin = 32.dp)
					start.linkTo(emailTxtField.start)
					end.linkTo(emailTxtField.end)
					width = Dimension.fillToConstraints
					bottom.linkTo(parent.bottom, margin = 8.dp)
				}, contentPadding = PaddingValues(vertical = 14.dp),
					   elevation = ButtonDefaults.elevation(0.dp)) {
					Text(text = "Next", fontFamily = Poppins)
				}
			}
		}
	}
}