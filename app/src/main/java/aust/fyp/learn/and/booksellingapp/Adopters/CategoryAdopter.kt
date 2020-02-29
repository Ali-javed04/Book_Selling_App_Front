package aust.fyp.learn.and.booksellingapp.Adopters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import aust.fyp.learn.and.booksellingapp.Model.CategoryModel
import aust.fyp.learn.and.booksellingapp.R

class CategoryAdopter(var list: ArrayList<CategoryModel>):RecyclerView.Adapter<CategoryAdopter.myViewHolder>() {
    lateinit var context: Context


    class myViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var title: TextView = itemView.findViewById(R.id.title)
        var image: ImageView = itemView.findViewById(R.id.image)

    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryAdopter.myViewHolder {


        var view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.single_view_category, null)

        context = view.context

        val scale: Float = context.getResources().getDisplayMetrics().density
        val pixels = (165 * scale + 0.5f).toInt()

        view.layoutParams = LinearLayout.LayoutParams(
            pixels,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )



        return CategoryAdopter.myViewHolder(view)

    }

    override fun getItemCount(): Int {

        return list.size
    }

    override fun onBindViewHolder(holder: CategoryAdopter.myViewHolder, position: Int) {

        holder.title.setText(list.get(position).title)
        holder.image.setImageResource(list.get(position).image)
    }
}