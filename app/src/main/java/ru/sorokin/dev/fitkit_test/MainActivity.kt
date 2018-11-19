package ru.sorokin.dev.fitkit_test

import android.os.Bundle
import android.support.annotation.IdRes
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;

import kotlinx.android.synthetic.main.activity_main.*
import ru.sorokin.dev.fitkit_test.ui.home.HomeFragment

class MainActivity : AppCompatActivity() {

    @IdRes
    val containerId = R.id.fl_content

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                    .replace(containerId, HomeFragment.newInstance())
                    .commit()
        }

    }

}
