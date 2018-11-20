package ru.sorokin.dev.fitkittest

import android.os.Bundle
import android.support.annotation.IdRes
import android.support.v7.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_main.*
import ru.sorokin.dev.fitkittest.ui.home.HomeFragment

class MainActivity : AppCompatActivity() {

    @IdRes
    val containerId = R.id.fl_content

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        setTitle(R.string.title_activity_main)

        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                    .replace(containerId, HomeFragment.newInstance())
                    .commit()
        }

    }

}
