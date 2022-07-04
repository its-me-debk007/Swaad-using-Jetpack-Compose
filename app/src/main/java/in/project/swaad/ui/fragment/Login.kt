package `in`.project.swaad.ui.fragment

import `in`.project.swaad.R
import `in`.project.swaad.ui.theme.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController

@Preview(showBackground = true)
@Composable
fun Login(navController: NavController? = null) {
	var email by rememberSaveable { mutableStateOf("") }
	var txt2 by rememberSaveable { mutableStateOf("") }
	var isPasswordVisible by rememberSaveable { mutableStateOf(false) }
	val textFieldColors = TextFieldDefaults.outlinedTextFieldColors(
		unfocusedBorderColor = TextFieldBorderColor,
		leadingIconColor = Color.Black,
		trailingIconColor = Color.Black,
		unfocusedLabelColor = TextFieldLabelColor
	)

	SwaadTheme {
		ConstraintLayout(Modifier
							 .fillMaxWidth()
							 .verticalScroll(rememberScrollState())) {
			val (image, emailTxtField,
				password, forgotPassword,
				signInBtn, signUp) = createRefs()

			Image(painter = painterResource(id = R.drawable.login_image),
				  contentDescription = null,
				  modifier = Modifier
					  .constrainAs(image) {
						  top.linkTo(parent.top, margin = 16.dp)
						  end.linkTo(parent.end)
						  start.linkTo(parent.start)
					  }
			)

			OutlinedTextField(
				value = email, onValueChange = { email = it },
				modifier = Modifier.constrainAs(emailTxtField) {
					start.linkTo(parent.start, margin = 24.dp)
					end.linkTo(parent.end, margin = 24.dp)
					top.linkTo(image.bottom, margin = 52.87.dp)
					width = Dimension.fillToConstraints
				},
				singleLine = true,
				shape = RoundedCornerShape(32.dp),
				colors = textFieldColors,
				label = { Text(text = "Email", fontWeight = FontWeight.Medium) },
				keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email,
												  imeAction = ImeAction.Next),
				leadingIcon = {
					Icon(painter = painterResource(id = R.drawable.ic_mail),
						 contentDescription = null)
				}
			)

			OutlinedTextField(
				value = txt2, onValueChange = { txt2 = it },
				modifier = Modifier
					.constrainAs(password) {
						start.linkTo(parent.start, margin = 24.dp)
						end.linkTo(parent.end, margin = 24.dp)
						top.linkTo(emailTxtField.bottom, margin = 16.dp)
						width = Dimension.fillToConstraints
					},
				singleLine = true,
				shape = RoundedCornerShape(32.dp),
				label = { Text(text = "Password", fontWeight = FontWeight.Medium) },
				leadingIcon = {
					Icon(painter = painterResource(id = R.drawable.ic_lock),
						 contentDescription = null)
				},
				trailingIcon = {
					Icon(
						painter = painterResource(id = if (!isPasswordVisible) R.drawable.ic_visibility
						else R.drawable.ic_visibility_off),
						contentDescription = "Toggle password visibility",
						modifier = Modifier
							.clickable { isPasswordVisible = !isPasswordVisible },
					)
				},
				colors = textFieldColors,
				keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password,
												  imeAction = ImeAction.Done),
				visualTransformation = if (isPasswordVisible) VisualTransformation.None else
					PasswordVisualTransformation(),
			)

			Text(text = "Forgot Password?", modifier = Modifier
				.constrainAs(forgotPassword) {
					start.linkTo(parent.start, margin = 24.dp)
					top.linkTo(password.bottom, margin = 16.dp)
				}
				.clickable { navController?.navigate("forgotPassword") },
				 fontSize = 14.sp, fontFamily = Poppins)

			Button(
				onClick = { /*TODO*/ },
				modifier = Modifier.constrainAs(signInBtn) {
					end.linkTo(parent.end, margin = 24.dp)
					start.linkTo(parent.start, margin = 24.dp)
					top.linkTo(forgotPassword.bottom, margin = 16.dp)
					width = Dimension.fillToConstraints
				},
				colors = ButtonDefaults.buttonColors(ColorPrimary),
				shape = RoundedCornerShape(32.dp),
				elevation = ButtonDefaults.elevation(0.dp),
				contentPadding = PaddingValues(14.dp),
			) {
				Text(text = "Sign In", fontFamily = Poppins)
			}

			Text(
				buildAnnotatedString {
					append("New here? ")
					withStyle(SpanStyle(CustomYellow, fontWeight = FontWeight.Medium)) {
						append("Sign up")
					}
				},
				modifier = Modifier
					.constrainAs(signUp) {
						top.linkTo(signInBtn.bottom, margin = 32.dp)
						start.linkTo(parent.start)
						end.linkTo(parent.end)
						bottom.linkTo(parent.bottom, margin = 8.dp)
					}
					.clickable { navController?.navigate("signUp") },
				fontFamily = Poppins
			)
		}
	}
}
