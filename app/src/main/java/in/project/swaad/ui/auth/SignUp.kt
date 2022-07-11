package `in`.project.swaad.ui.auth

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
fun SignUp(navController: NavController? = null) {
	var fullName by rememberSaveable { mutableStateOf("") }
	var email by rememberSaveable { mutableStateOf("") }
	var password by rememberSaveable { mutableStateOf("") }
	var isPasswordVisible by rememberSaveable { mutableStateOf(false) }
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
			val (
				sign_up_image, heading, nameTxtField,
				emailTxtField, passwordTxtField, signUpBtn,
				termsConditions, login,
			) = createRefs()

			Image(painter = painterResource(id = R.drawable.sign_up_image),
				  contentDescription = null, modifier = Modifier.constrainAs(sign_up_image) {
					end.linkTo(parent.end)
					top.linkTo(parent.top, margin = 16.dp)
					start.linkTo(parent.start)
				})

			Text(text = "Create your account", fontSize = 24.sp, modifier = Modifier
				.constrainAs(heading) {
					start.linkTo(parent.start, margin = 24.dp)
					top.linkTo(sign_up_image.bottom, margin = 32.dp)
				}, fontFamily = Poppins, fontWeight = FontWeight.Medium)

			OutlinedTextField(value = fullName, onValueChange = { fullName = it },
							  shape = RoundedCornerShape(32.dp),
							  leadingIcon = {
								  Icon(painter = painterResource(id = R.drawable.ic_profile),
									   contentDescription = null, tint = Color.Black)
							  },
							  label = { Text(text = "Full Name") },
							  modifier = Modifier.constrainAs(nameTxtField) {
								  top.linkTo(heading.bottom, margin = 8.dp)
								  end.linkTo(parent.end, margin = 24.dp)
								  start.linkTo(parent.start, margin = 24.dp)
								  width = Dimension.fillToConstraints
							  }, colors = textFieldColors,
							  singleLine = true,
							  keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next))

			OutlinedTextField(value = email, onValueChange = { email = it },
							  shape = RoundedCornerShape(32.dp),
							  label = { Text(text = "Email") },
							  modifier = Modifier.constrainAs(emailTxtField) {
								  top.linkTo(nameTxtField.bottom, margin = 16.dp)
								  end.linkTo(parent.end, margin = 24.dp)
								  start.linkTo(parent.start, margin = 24.dp)
								  width = Dimension.fillToConstraints
							  },
							  leadingIcon = {
								  Icon(painter = painterResource(id = R.drawable.ic_mail),
									   contentDescription = null, tint = Color.Black)
							  },
							  colors = textFieldColors,
							  keyboardOptions = KeyboardOptions(keyboardType = KeyboardType
								  .Email, imeAction = ImeAction.Next),
							  singleLine = true
			)

			OutlinedTextField(value = password, onValueChange = { password = it },
							  shape = RoundedCornerShape(32.dp),
							  label = { Text(text = "Password") },
							  modifier = Modifier.constrainAs(passwordTxtField) {
								  top.linkTo(emailTxtField.bottom, margin = 16.dp)
								  end.linkTo(parent.end, margin = 24.dp)
								  start.linkTo(parent.start, margin = 24.dp)
								  width = Dimension.fillToConstraints
							  },
							  leadingIcon = {
								  Icon(painter = painterResource(id = R.drawable.ic_lock),
									   contentDescription = null, tint = Color.Black)
							  },
							  colors = textFieldColors,
							  singleLine = true,
							  keyboardOptions = KeyboardOptions(keyboardType = KeyboardType
								  .Password, imeAction = ImeAction.Done),
							  trailingIcon = {
								  Icon(painter = painterResource(id = if (isPasswordVisible)
									  R.drawable.ic_visibility else R.drawable.ic_visibility_off),
									   contentDescription = "Password visibility toggle",
									   tint = Color.Black, modifier = Modifier.clickable {
										  isPasswordVisible = !isPasswordVisible
									  })
							  }, visualTransformation = if (isPasswordVisible)
					VisualTransformation.None else PasswordVisualTransformation()
			)

			Button(onClick = { /*TODO*/ },
				   contentPadding = PaddingValues(vertical = 14.dp),
				   modifier = Modifier.constrainAs
					   (signUpBtn) {
					   top.linkTo(passwordTxtField.bottom, margin = 16.dp)
					   start.linkTo(parent.start, margin = 24.dp)
					   end.linkTo(parent.end, margin = 24.dp)
					   width = Dimension.fillToConstraints
				   },
				   elevation = ButtonDefaults.elevation(0.dp)) {
				Text(text = "Sign up", fontFamily = Poppins)
			}

			Text(buildAnnotatedString {
				append("By signing up you agree to our\n")
				withStyle(SpanStyle(color = CustomYellow)) {
					append("Terms & conditions")
				}
			}, modifier = Modifier.constrainAs(termsConditions) {
				top.linkTo(signUpBtn.bottom, margin = 48.dp)
				end.linkTo(login.end)
				start.linkTo(login.start)
				width = Dimension.fillToConstraints
			}, fontFamily = Poppins, fontSize = 14.sp)

			Text(buildAnnotatedString {
				append("Already have an account?  ")
				withStyle(SpanStyle(CustomYellow)) {
					append("Log in")
				}
			}, modifier = Modifier
				.constrainAs(login) {
					start.linkTo(parent.start)
					end.linkTo(parent.end)
					top.linkTo(termsConditions.bottom, margin = 8.dp)
					bottom.linkTo(parent.bottom, margin = 8.dp)
				}
				.clickable { navController?.navigate("logIn") }, fontFamily = Poppins, fontSize = 14
				.sp)
		}
	}
}
