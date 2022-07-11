package `in`.project.swaad.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object ServiceBuilder {
	private const val BASE_URL = "https://cryptic-tor-47801.herokuapp.com/api/"
	private val retrofit = Retrofit.Builder()
		.baseUrl(BASE_URL)
		.addConverterFactory(MoshiConverterFactory.create())

	fun getInstance() = retrofit.build().create(ApiInterface::class.java)
}