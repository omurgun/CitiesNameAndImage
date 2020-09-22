package com.omurgun.cities


import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailsActivity : AppCompatActivity() {

    private lateinit var textView:TextView
    private lateinit var imageView:ImageView
    private lateinit var name:String
    private var image: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        init()
        getInfoFromIntent()
        putNameAndImage()

    }

    private fun putNameAndImage() {
        val selectedBitmap = BitmapFactory.decodeResource(applicationContext.resources, image!!)

        imageView.setImageBitmap(selectedBitmap)
        textView.text = name

    }
    private fun getInfoFromIntent() {
        val intent = intent
        name = intent.getStringExtra("name").toString()
        image = intent.getIntExtra("image",0)

    }
    private fun init() {
        textView = findViewById(R.id.textView)
        imageView = findViewById(R.id.imageView)
        name = String()
    }
}