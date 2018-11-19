package ru.sorokin.dev.fitkit_test.di

import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import ru.sorokin.dev.fitkit_test.ui.home.HomeViewModel

val mainModule = module {
    viewModel { HomeViewModel() }
}