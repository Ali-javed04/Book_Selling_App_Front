package aust.fyp.learn.and.booksellingapp.StoreRoom

import aust.fyp.learn.and.booksellingapp.Model.CategoryModel
import aust.fyp.learn.and.booksellingapp.R

object Store {




    fun getCategories(): ArrayList<CategoryModel> {
        var list = ArrayList<CategoryModel>()
        list.add(
            CategoryModel(
                "MATRIC",
                R.drawable.a
            )
        )
        list.add(
            CategoryModel(
                "FSC",
                R.drawable.a
            )
        )
        list.add(
            CategoryModel(
                "BS",
                R.drawable.a
            )
        )
        list.add(
            CategoryModel(
                "MS",
                R.drawable.a
            )
        )
        list.add(
            CategoryModel(
                "Phd",
                R.drawable.b
            )
        )
        list.add(
            CategoryModel(
                "css",
                R.drawable.b
            )
        )
        list.add(
                CategoryModel(
                    "pms",
                    R.drawable.b
                )
                )
        list.add(
                CategoryModel(
                    "Others",
                    R.drawable.b
                )
                )
        list.add(
                CategoryModel(
                    "Others",
                    R.drawable.b
                )
                )
        return list
    }
}