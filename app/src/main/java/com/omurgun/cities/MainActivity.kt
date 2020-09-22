package com.omurgun.cities

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    private lateinit var cityNames:ArrayList<String>
    private lateinit var cityImages:ArrayList<Int>
    private lateinit var listView:ListView
    private lateinit var adapter:ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        addNames()
        addImage()
        setAdapter()
        goDetailActivity()
    }

    private fun goDetailActivity() {
        listView.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->
            val intent = Intent(applicationContext,DetailsActivity::class.java)
            intent.putExtra("name",cityNames[i])
            intent.putExtra("image",cityImages[i])
            startActivity(intent)
        }
    }
    private fun setAdapter() {
        listView.adapter = adapter
    }
    private fun init() {
        cityNames = ArrayList()
        cityImages = ArrayList()
        listView = findViewById(R.id.listView)
        adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,cityNames)
    }
    private fun addNames() {
        cityNames.add("Kayseri")
        cityNames.add("Istanbul")
        cityNames.add("Mersin")
        cityNames.add("Trabzon")
        cityNames.add("Ankara")

    }
    private fun addImage() {
        val cityKayseri = R.drawable.kayseri
        val cityIstanbul = R.drawable.istanbul
        val cityMersin = R.drawable.mersin
        val cityTrabzon = R.drawable.trabzon
        val cityAnkara = R.drawable.ankara
        cityImages.add(cityKayseri)
        cityImages.add(cityIstanbul)
        cityImages.add(cityMersin)
        cityImages.add(cityTrabzon)
        cityImages.add(cityAnkara)

    }
}