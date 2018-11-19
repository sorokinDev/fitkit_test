package ru.sorokin.dev.fitkit_test.ui.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.annotation.StringRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.android.viewmodel.ext.android.viewModelByClass
import kotlin.reflect.KClass

abstract class BaseFragment<T: BaseViewModel>(viewModelClass: KClass<T>): Fragment() {
    val viewModel: T by viewModelByClass(viewModelClass)

    @LayoutRes
    abstract fun getLayoutRes(): Int


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutRes(), container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initUI()
        initObservers()
    }

    abstract fun initUI()
    abstract fun initObservers()

}