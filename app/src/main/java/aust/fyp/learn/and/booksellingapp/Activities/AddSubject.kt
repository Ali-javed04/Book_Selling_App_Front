package aust.fyp.learn.and.booksellingapp.Activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import aust.fyp.learn.and.booksellingapp.R
import aust.fyp.learn.and.booksellingapp.StoreRoom.PreferenceManager
import aust.fyp.learn.and.booksellingapp.StoreRoom.URLs
import com.squareup.picasso.Picasso


class AddSubject : AppCompatActivity() {

    lateinit var book_image : ImageView
    lateinit var categories : Spinner
    lateinit var book_title : EditText
    lateinit var description : EditText
    lateinit var price : EditText




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_subject)


        book_image = findViewById(R.id.book_image)
        categories = findViewById(R.id.categories)
        book_title = findViewById(R.id.book_title)
        description = findViewById(R.id.description)
        price = findViewById(R.id.price)




    }

    fun save(view : View){

    }
    fun Add_picture(view : View){

        startActivity(Intent(applicationContext,AddPicture::class.java))

    }

    override fun onResume() {
        super.onResume()



        Picasso.get()
            .load(URLs.getImageUrl(PreferenceManager.getInstance(applicationContext!!)!!.getUserProfile()))
            .into(book_image)

    }
}

