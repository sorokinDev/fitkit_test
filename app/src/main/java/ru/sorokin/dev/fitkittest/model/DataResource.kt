package ru.sorokin.dev.fitkittest.model

import android.support.annotation.StringRes

sealed class DataResource<T>(val data: T?)

class Success<T>(data: T?): DataResource<T>(data)
class Error<T>(data: T?, val throwable: Throwable?): DataResource<T>(data)
