package com.example.farmeasyproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class PlantAdapter(private val PlantList: List<Plant>) : RecyclerView.Adapter<PlantAdapter.MovieHolder>() {

    private lateinit var mlistener : onItemClickListener
    interface onItemClickListener{
        fun onitemclick(position: Int)
    }
    fun setonItemClickListener(listener:onItemClickListener){
        mlistener=listener
    }


    class MovieHolder(view: View,listener: onItemClickListener ) : RecyclerView.ViewHolder(view) {
        val textplant: TextView = view.findViewById(R.id.textplant)
//        val textdemand: TextView = view.findViewById(R.id.textdemand)
//        val img: ImageView = view.findViewById(R.id.imgId)

        init {

            view.setOnClickListener{
                listener.onitemclick(adapterPosition)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.single_card_item_row, parent, false
        )
        return MovieHolder(view,mlistener)
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        val item: Plant = PlantList[position]
        holder.textplant.text = item.title
//      holder.img.setImageResource(item.image)
//        holder.textdemand.text = item.demand
    }



    override fun getItemCount(): Int {
        return PlantList.size
    }
}