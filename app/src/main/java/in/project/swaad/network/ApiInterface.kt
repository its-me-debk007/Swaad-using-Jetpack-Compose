package `in`.project.swaad.network

import `in`.project.swaad.model.LoginBody
import `in`.project.swaad.model.LoginResponse
import `in`.project.swaad.model.SignupBody
import retrofit2.Response
import retrofit2.http.*

interface ApiInterface {
	@POST("login")
	suspend fun login(@Body body: LoginBody): Response<LoginResponse>

	@POST("signup")
	suspend fun signup(@Body body: SignupBody): Response<LoginResponse>
}