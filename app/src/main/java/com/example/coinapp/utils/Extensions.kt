package com.example.coinapp.utils

import android.content.Context
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import coil.load
import coil.transform.CircleCropTransformation
import com.example.coinapp.R

fun ImageView.loadImageUrl(url:String?){
    val holder= createPlaceHolder(this.context)
    this.load(url){
        crossfade(true)
        placeholder(R.drawable.ic_android_black_24dp)
        transformations(CircleCropTransformation())
    }
}

private fun createPlaceHolder(context: Context):CircularProgressDrawable{
    return CircularProgressDrawable(context).apply {
        strokeWidth= 8f
        centerRadius=40f
        start()
    }
}

