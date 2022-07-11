package `in`.project.swaad.ui

import `in`.project.swaad.ui.auth.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavGraph() {
	val navController = rememberNavController()
	Surface(Modifier.fillMaxSize()) {
		NavHost(navController = navController, startDestination = "login") {
			composable("login") { Login(navController) }
			composable("signUp") { SignUp(navController) }
			composable("forgotPassword") { ForgotPassword(navController) }
			composable("resetPassword") { ResetPassword(navController) }
			composable("verifyOtp") { VerifyOtp(navController) }
		}
	}
}