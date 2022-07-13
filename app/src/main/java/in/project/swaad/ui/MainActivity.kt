package `in`.project.swaad.ui

import `in`.project.swaad.ui.home.Cart
import `in`.project.swaad.ui.theme.SwaadTheme
import `in`.project.swaad.viewModel.AuthViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModelProvider

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		val viewModel =
			ViewModelProvider(this)[AuthViewModel::class.java]
		setContent {
			SwaadTheme {
				Surface(Modifier.background(Color.White)) {
					Cart()
				}
			}
		}
	}
}