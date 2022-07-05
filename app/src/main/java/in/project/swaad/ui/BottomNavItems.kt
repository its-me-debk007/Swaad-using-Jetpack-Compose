package `in`.project.swaad.ui

import `in`.project.swaad.R
import androidx.annotation.DrawableRes

sealed class BottomNavItems(
	val route: String,
	val title: String,
	@DrawableRes val outlinedIcon: Int,
	@DrawableRes val filledIcon: Int,
) {
	object Home : BottomNavItems(
		route = "home",
		title = "Home",
		outlinedIcon = R.drawable.ic_home_outlined,
		filledIcon = R.drawable.ic_home_filled
	)

	object Account : BottomNavItems(
		route = "profile",
		title = "Profile",
		outlinedIcon = R.drawable.ic_account_outlined,
		filledIcon = R.drawable.ic_account_filled
	)
}