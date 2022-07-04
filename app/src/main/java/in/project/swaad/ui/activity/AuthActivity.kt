package `in`.project.swaad.ui.activity

import `in`.project.swaad.ui.MainContent
import `in`.project.swaad.ui.fragment.home.HomePage
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class AuthActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			HomePage()
		}
	}
}