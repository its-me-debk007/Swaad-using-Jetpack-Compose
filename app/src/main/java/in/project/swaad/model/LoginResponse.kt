package `in`.project.swaad.model

data class LoginResponse(
    val message: String,
    val access: String,
    val refresh: String
)