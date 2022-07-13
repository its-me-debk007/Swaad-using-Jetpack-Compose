package `in`.project.swaad.network

sealed class Response<T>(val data: T? = null, val error: String? = null) {

	class Success<T>(successData: T) : Response<T>(successData)

	class Failure<T>(errorMsg: String? = null, errorData: T? = null) : Response<T>(errorData, errorMsg)
}
