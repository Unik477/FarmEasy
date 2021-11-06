package com.example.farmeasyproject

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<Plant>
    lateinit var title: Array<String>
    lateinit var info: Array<String>
    lateinit var img: Array<Int>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title= arrayOf(
            "Avocado",
            "Ladyfinger",
            "Kiwi",
            "Potato",
            "Beet Root",
            "Grapes",
            "Carrot",
            "Wheat",

            )

        info= arrayOf(

            getString(R.string.info_0),
            getString(R.string.info_1),
            getString(R.string.info_2),
            getString(R.string.info_3),
            getString(R.string.info_4),
            getString(R.string.info_5),
            getString(R.string.info_6),
            getString(R.string.info_7),

            )

        img= arrayOf(

                   R.drawable.avocado,
                   R.drawable.ladyfinger,
                  R.drawable.kiwi,
                  R.drawable.potato,
            R.drawable.beetroot,
                   R.drawable.grapes,
            R.drawable.carrot,
                   R.drawable.wheat,
        )

        newRecyclerView=findViewById(R.id.Plantlist)
        newRecyclerView.layoutManager=LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList= arrayListOf()

        getuserdata()


    }

    private fun getuserdata() {
        for (i in title.indices ){
            val plant = Plant(title[i])
            newArrayList.add(plant)
            var adapter=PlantAdapter(newArrayList)
            newRecyclerView.adapter=adapter
            adapter.setonItemClickListener(object :PlantAdapter.onItemClickListener{
                override fun onitemclick(position: Int) {
//                    Toast.makeText(this@MainActivity, "you clicked on item no. $position", Toast.LENGTH_SHORT).show()

                    val intent= Intent(this@MainActivity,InfoActivity::class.java)
                    intent.putExtra("title", newArrayList[position].title)
                    intent.putExtra("info",info[position])
                    intent.putExtra("img",img[position])
                    startActivity(intent)
                }

            })
        }
    }


}