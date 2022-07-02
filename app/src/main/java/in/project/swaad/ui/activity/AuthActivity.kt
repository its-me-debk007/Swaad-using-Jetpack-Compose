package `in`.project.swaad.ui.activity

import `in`.project.swaad.ui.fragment.LoginFragment
import `in`.project.swaad.ui.fragment.ResetPasswordFragment
import `in`.project.swaad.ui.theme.SwaadTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class AuthActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			DefaultPreview()
		}
	}
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
	SwaadTheme {
		LoginFragment().Ui()
	}
}