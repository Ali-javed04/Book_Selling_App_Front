package aust.fyp.learn.and.booksellingapp.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.viewpager.widget.ViewPager
import aust.fyp.learn.and.booksellingapp.Adopters.ViewPagerAdapter
import aust.fyp.learn.and.booksellingapp.Fragment.AccountFragment
import aust.fyp.learn.and.booksellingapp.Fragment.BooksFragment
import aust.fyp.learn.and.booksellingapp.Fragment.HomeFragment
import aust.fyp.learn.and.booksellingapp.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var viewPager : ViewPager

    lateinit var bottomNav: BottomNavigationView
    lateinit var viewPagerAdapter: ViewPagerAdapter
    var currentFragment = "home"
    var TAG = "MainActivity"
    var previousItem: MenuItem? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.viewPager)
        bottomNav = findViewById(R.id.bottomNav)

        supportActionBar!!.hide()

        viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)
        viewPagerAdapter.addFragment(HomeFragment(), "Home")
        viewPagerAdapter.addFragment(BooksFragment(), "Books")
        viewPagerAdapter.addFragment(AccountFragment(), "Account")

        viewPager.adapter = viewPagerAdapter

        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {

                if (previousItem == null) {
                    bottomNav.menu.getItem(0).setChecked(false)
                } else {
                    previousItem?.setChecked(false)
                }
                bottomNav.menu.getItem(position).setChecked(true)
                previousItem = bottomNav.menu.getItem(position)

                currentFragment = when (position) {
                    0 -> "home"
                    1 -> "books"
                    2 -> "account"
                    else -> "some_other_frag"
                }

            }

        })

        bottomNav.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {

                R.id.home -> {
                    viewPager.setCurrentItem(0)
                    currentFragment = "home"
                }
                R.id.books -> {
                    viewPager.currentItem = 1
                    currentFragment = "books"
                }
                R.id.account -> {
                    viewPager.setCurrentItem(2)
                    currentFragment = "account"
                }

            }
            true

        }





    }
    override fun onBackPressed() {
        if (currentFragment.equals("home")) {
            super.onBackPressed()
        } else {
            viewPager.setCurrentItem(0)
            bottomNav.selectedItemId = R.id.home
            currentFragment = "home"
        }
    }

}
