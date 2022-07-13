package `in`.project.swaad.repository

import `in`.project.swaad.model.LoginBody
import `in`.project.swaad.model.LoginResponse
import `in`.project.swaad.network.Response
import `in`.project.swaad.network.ServiceBuilder
import `in`.project.swaad.ui.auth.Login
import android.util.Log
import `in`.project.swaad.model.SignupBody

class Repository {
	suspend fun login(email: String, password: String): Response<LoginResponse> {
		return try {
			val response = ServiceBuilder.getInstance().login(LoginBody(email, password))
			Log.e("dddd", response.code().toString())
			when {
				response.isSuccessful -> Response.Success(response.body()!!)

				else -> {
					Log.e("dddd", response.body()?.message.toString())
					Response.Failure(response.body()?.message)
				}
			}

		} catch(e: Exception) {
			Response.Failure(e.message)
		}
	}

	suspend fun signup(name: String, email: String, password: String): Response<LoginResponse> {
		return try {
			val response = ServiceBuilder.getInstance().signup(SignupBody(email, name, password))
			Log.e("dddd", response.code().toString())
			when {
				response.isSuccessful -> {
					Log.e("dddd", response.body().toString())
					Response.Success(response.body()!!)
				}

				else -> {
					Log.e("dddd", response.body()?.message.toString())
					Response.Failure(response.body()?.message)
				}
			}

		} catch(e: Exception) {
			Response.Failure(e.message)
		}
	}
}