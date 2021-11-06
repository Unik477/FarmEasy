package com.example.farmeasyproject

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class InfoActivity :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        val titlePlants: TextView=findViewById(R.id.heading)
        val infos: TextView=findViewById(R.id.info)
        val imgs: ImageView=findViewById(R.id.imageView3)

        val bundle:Bundle?=intent.extras
        val title=bundle!!.getString("title")
        val info=bundle!!.getString("info")
        val img=bundle!!.getInt("img")

        titlePlants.text=title
        infos.text=info
        imgs.setImageResource(img)


    }
}