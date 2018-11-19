package ru.sorokin.dev.fitkittest.ui.home

import android.widget.Toast
import ru.sorokin.dev.fitkittest.R
import ru.sorokin.dev.fitkittest.ui.base.BaseFragment

class HomeFragment: BaseFragment<HomeViewModel>(HomeViewModel::class){

    override fun getLayoutRes(): Int = R.layout.fragment_home

    override fun initUI() {
        Toast.makeText(requireContext(), viewModel.helloMsg, Toast.LENGTH_LONG).show()
    }

    override fun initObservers() {

    }

    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }

}