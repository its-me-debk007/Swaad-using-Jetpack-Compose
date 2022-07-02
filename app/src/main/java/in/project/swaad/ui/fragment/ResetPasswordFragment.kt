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
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
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
import androidx.fragment.app.Fragment

class ResetPasswordFragment : Fragment() {
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
		var password by rememberSaveable { mutableStateOf("") }
		var confirmPassword by rememberSaveable { mutableStateOf("") }
		var isPasswordVisible by rememberSaveable { mutableStateOf(false) }
		var isConfirmPasswordVisible by rememberSaveable { mutableStateOf(false) }
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
				val (image, heading, passwordTxtField,
					resetPasswordBtn, confirmPasswordTxtField,
					passwordTxt, confirmPasswordTxt) = createRefs()

				Image(painter = painterResource(id = R.drawable.reset_password_image),
					  contentDescription = null, modifier = Modifier.constrainAs(image) {
						end.linkTo(parent.end)
						top.linkTo(parent.top, margin = 60.dp)
						start.linkTo(parent.start)
					})

				Text(buildAnnotatedString {
					withStyle(SpanStyle(fontSize = 24.sp)) {
						append("Create new password\n")
					}
					withStyle(SpanStyle(color = Color(0xFF999999), fontSize = 14.sp)) {
						append("Your new password must be different from previous used password")
					}
				}, modifier = Modifier.constrainAs(heading) {
					start.linkTo(parent.start, margin = 24.dp)
					end.linkTo(parent.end, margin = 24.dp)
					width = Dimension.fillToConstraints
					top.linkTo(image.bottom, margin = 56.dp)
				}, fontFamily = Poppins)

				Text(text = "Password", modifier = Modifier.constrainAs(passwordTxt) {
					start.linkTo(heading.start)
					top.linkTo(heading.bottom, margin = 24.dp)
				}, fontFamily = Poppins)

				OutlinedTextField(value = password, onValueChange = { password = it },
								  shape = RoundedCornerShape(32.dp),
								  label = { Text(text = "Password", fontSize = 14.sp) },
								  textStyle = TextStyle(fontSize = 14.sp),
								  modifier = Modifier.constrainAs(passwordTxtField) {
									  top.linkTo(passwordTxt.bottom, margin = 4.dp)
									  end.linkTo(heading.end)
									  start.linkTo(heading.start)
									  width = Dimension.fillToConstraints
								  },
								  leadingIcon = {
									  Icon(painter = painterResource(id = R.drawable.ic_lock),
										   contentDescription = null, tint = Color.Black)
								  },
								  colors = textFieldColors,
								  singleLine = true,
								  keyboardOptions = KeyboardOptions(keyboardType = KeyboardType
									  .Password, imeAction = ImeAction.Next),
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

				Text(text = "Confirm Password",
					 modifier = Modifier.constrainAs(confirmPasswordTxt) {
						 start.linkTo(heading.start)
						 top.linkTo(passwordTxtField.bottom, margin = 32.dp)
					 }, fontFamily = Poppins)

				OutlinedTextField(value = confirmPassword, onValueChange = { confirmPassword = it },
								  shape = RoundedCornerShape(32.dp),
								  label = { Text(text = "Confirm Password", fontSize = 14.sp) },
								  textStyle = TextStyle(fontSize = 14.sp),
								  modifier = Modifier.constrainAs(confirmPasswordTxtField) {
									  top.linkTo(confirmPasswordTxt.bottom, margin = 4.dp)
									  end.linkTo(passwordTxtField.end)
									  start.linkTo(passwordTxtField.start)
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
									  Icon(painter = painterResource(id = if (isConfirmPasswordVisible)
										  R.drawable.ic_visibility else R.drawable.ic_visibility_off),
										   contentDescription = "Password visibility toggle",
										   tint = Color.Black, modifier = Modifier.clickable {
											  isConfirmPasswordVisible = !isConfirmPasswordVisible
										  })
								  }, visualTransformation = if (isConfirmPasswordVisible)
						VisualTransformation.None else PasswordVisualTransformation()
				)

				Button(onClick = { /*TODO*/ },
					   contentPadding = PaddingValues(vertical = 14.dp),
					   modifier = Modifier.constrainAs
						   (resetPasswordBtn) {
						   top.linkTo(confirmPasswordTxtField.bottom, margin = 32.dp)
						   start.linkTo(parent.start, margin = 24.dp)
						   end.linkTo(parent.end, margin = 24.dp)
						   width = Dimension.fillToConstraints
						   bottom.linkTo(parent.bottom, margin = 8.dp)
					   },
					   elevation = ButtonDefaults.elevation(0.dp)) {
					Text(text = "Reset Password", fontFamily = Poppins)
				}
			}
		}
	}
}