package `in`.project.swaad.network

import `in`.project.swaad.model.LoginResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
	@GET("login")
	suspend fun login() : Response<LoginResponse>
}