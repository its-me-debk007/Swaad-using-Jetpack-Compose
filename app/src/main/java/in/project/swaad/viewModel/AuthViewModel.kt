package `in`.project.swaad.viewModel

import `in`.project.swaad.network.Response
import `in`.project.swaad.repository.Repository
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class AuthViewModel: ViewModel() {
	val txt = mutableStateOf("")
	private val repository = Repository()

	fun login(email: String, password: String) {
		viewModelScope.launch {
			val response = repository.login(email, password)
			txt.value = if (response is Response.Success) response.data!!.message else
				response.error!!
		}
	}

	fun signup(name: String, email: String, password: String) {
		viewModelScope.launch {
			val response = repository.signup(name, email, password)
			txt.value = if (response is Response.Success) response.data!!.message else
				response.error!!
		}
	}
}