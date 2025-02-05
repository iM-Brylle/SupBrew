package com.ctrl.alt.win.supbrew // Replace with your actual package name

import androidx.annotation.DrawableRes

data class PaymentMethod(
    @DrawableRes val icon: Int, // Resource ID of the icon
    val title: String,
    val description: String
)