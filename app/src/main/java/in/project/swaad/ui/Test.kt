package `in`.project.swaad.ui

import `in`.project.swaad.viewModel.AuthViewModel
import android.util.Log
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember

@Composable
fun Test(viewModel: AuthViewModel) {
	viewModel.signup("Deb K","debashish.joy@gmail.c", "Admin@321")
	val txt by remember { viewModel.txt }
	Log.e("dddd", "txt is $txt")
	Text(text = txt)
}