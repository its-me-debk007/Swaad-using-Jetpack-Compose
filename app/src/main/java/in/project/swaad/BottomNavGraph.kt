package `in`.project.swaad

import `in`.project.swaad.ui.BottomNavItems
import `in`.project.swaad.ui.fragment.home.Account
import `in`.project.swaad.ui.fragment.home.HomePage
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun BottomNavGraph(navController: NavHostController) {
	NavHost(
		navController = navController,
		startDestination = BottomNavItems.Home.route
	) {
		composable(route = BottomNavItems.Home.route) {
			HomePage()
		}
		composable(route = BottomNavItems.Account.route) {
			Account()
		}
	}
}