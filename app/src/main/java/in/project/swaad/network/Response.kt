package `in`.project.swaad.network

sealed class Response<T>(val data: T? = null, val errorMsg: String? = null) {
	class Success<T>(data: T? = null) : Response<T>(data = data)
	class Failure<T>(errorMsg: String) : Response<T>(errorMsg = errorMsg)
}
