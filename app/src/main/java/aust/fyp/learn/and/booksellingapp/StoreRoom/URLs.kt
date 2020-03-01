package aust.fyp.learn.and.booksellingapp.StoreRoom

object URLs {

    val IP_ADDRESS = "192.168.43.169:"
    val PORT = "3306"
    val PROTOCOL = "http://"

    // users
    val CREATE_ACCOUNT = PROTOCOL + IP_ADDRESS + PORT + "/users/create"
    val LOGIN = PROTOCOL + IP_ADDRESS + PORT + "/users/sign_in"

    fun getImageUrl(image_name: String?): String {
        return PROTOCOL + IP_ADDRESS + PORT + "/uploadedFiles/$image_name"
    }

    val UPLOAD = PROTOCOL + IP_ADDRESS + PORT + "/upload"

}