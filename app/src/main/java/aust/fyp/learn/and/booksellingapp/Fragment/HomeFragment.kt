package aust.fyp.learn.and.booksellingapp.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import aust.fyp.learn.and.booksellingapp.Activities.LoginActivity
import aust.fyp.learn.and.booksellingapp.Adopters.CategoryAdopter
import aust.fyp.learn.and.booksellingapp.Model.CategoryModel

import aust.fyp.learn.and.booksellingapp.R
import aust.fyp.learn.and.booksellingapp.StoreRoom.Store
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_home_fragment.view.*


class HomeFragment : Fragment() {

    lateinit var recView: RecyclerView
    lateinit var list: ArrayList<CategoryModel>
    lateinit var adapter: CategoryAdopter
    var TAG = "HomeFragment"


    override fun onCreate(savedInstanceState: Bundle?) {


        list = Store.getCategories()
        adapter = CategoryAdopter(list)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_home_fragment, container, false)

        recView = view.findViewById(R.id.recView)
        recView.layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
        recView.adapter = adapter
        view.findViewById<Button>(R.id.sellbooks).sellbooks.setOnClickListener {
            startActivity(Intent(context,LoginActivity::class.java))
        }

        return view

    }

}

