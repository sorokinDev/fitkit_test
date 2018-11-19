package ru.sorokin.dev.fitkittest.ui.home

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_home.*
import ru.sorokin.dev.fitkittest.R
import ru.sorokin.dev.fitkittest.ui.base.BaseFragment

class HomeFragment: BaseFragment<HomeViewModel>(HomeViewModel::class){

    override fun getLayoutRes(): Int = R.layout.fragment_home

    override fun initUI() {
        fab_contact.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(VK_DEV_LINK)))
        }
    }

    override fun initObservers() {

    }

    companion object {
        const val VK_DEV_LINK = "https://vk.me/sorokin_dev"

        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }

}