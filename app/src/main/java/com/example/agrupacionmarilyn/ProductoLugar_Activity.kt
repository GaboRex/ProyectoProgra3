package com.example.agrupacionmarilyn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule

class ProductoLugar_Activity : AppCompatActivity() {
    lateinit var imagen : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_producto_lugar)

        imagen = findViewById(R.id.imagen1)

        var url : String = "https://z-p3-scontent.flpb2-2.fna.fbcdn.net/v/t1.6435-9/101220345_107515010989216_2695433518334345216_n.jpg?_nc_cat=111&ccb=1-3&_nc_sid=09cbfe&_nc_ohc=WcoUj5LPUnwAX_N8iC2&tn=OdT12UAe4RLhgOYF&_nc_ht=z-p3-scontent.flpb2-2.fna&oh=4d3247f8ed3935c143020c5ef62d62d6&oe=60DBE3DF"
        Glide.with(this)
            .load(url)
            .into(imagen)
    }
}