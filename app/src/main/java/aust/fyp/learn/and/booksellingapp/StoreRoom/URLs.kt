package aust.fyp.learn.and.booksellingapp.StoreRoom

object URLs {

    val IP_ADDRESS = "192.168.43.169"
    val PORT = ":8080"
    val PROTOCOL = "http://"

    // users
    val CREATE_ACCOUNT = PROTOCOL + IP_ADDRESS + PORT + "/users/create"
    val LOGIN = PROTOCOL + IP_ADDRESS + PORT + "/users/login"

    fun getImageUrl(image_name: String?): String {
        return PROTOCOL + IP_ADDRESS + PORT + "/uploadedFiles/$image_name"
    }

    val UPLOAD = PROTOCOL + IP_ADDRESS + PORT + "/upload"

}