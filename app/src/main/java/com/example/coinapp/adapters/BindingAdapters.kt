package com.example.coinapp.adapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.coinapp.utils.loadImageUrl

@BindingAdapter("load_image")
fun loadImage(imageView: ImageView,coinId:String){
    val url="https://s2.coinmarketcap.com/static/img/coins/64x64/$coinId.png"
    imageView.loadImageUrl(url)
}