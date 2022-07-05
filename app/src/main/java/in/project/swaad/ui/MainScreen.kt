package `in`.project.swaad.ui

import `in`.project.swaad.BottomNavGraph
import `in`.project.swaad.ui.theme.BottomNavItemBackground
import `in`.project.swaad.ui.theme.CustomGrey
import `in`.project.swaad.ui.theme.CustomOrange
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun MainScreen() {
	val navController = rememberNavController()
	Scaffold(
		bottomBar = { BottomBar(navController = navController) }
	) {
		BottomNavGraph(navController = navController)
	}
}

@Composable
fun BottomBar(navController: NavHostController) {
	val screens = listOf(
		BottomNavItems.Home,
		BottomNavItems.Account
	)
	val navBackStackEntry by navController.currentBackStackEntryAsState()
	val currentDestination = navBackStackEntry?.destination

	BottomNavigation(backgroundColor = Color.White) {
		screens.forEach { screen ->
			val isSelected = currentDestination?.hierarchy?.any {
				it.route == screen.route
			} == true
			BottomNavigationItem(
				label = {
					Text(text = screen.title, fontSize = 12.sp,
						 color = if (isSelected) CustomOrange else CustomGrey)
				},
				icon = {
					Icon(painterResource(id = if (isSelected) screen.filledIcon
					else screen.outlinedIcon), null,
						 tint = if (isSelected) CustomOrange else CustomGrey)
				},
				selected = isSelected,
				modifier = Modifier
					.drawBehind {
								drawCircle(color = BottomNavItemBackground)
					},
				onClick = {
					navController.navigate(screen.route) {
						popUpTo(navController.graph.findStartDestination().id)
						launchSingleTop = true
					}
				}
			)
		}
	}
}
