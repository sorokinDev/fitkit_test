package ru.sorokin.dev.fitkittest.di

import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import ru.sorokin.dev.fitkittest.ui.home.HomeViewModel

val mainModule = module {
    viewModel { HomeViewModel() }
}