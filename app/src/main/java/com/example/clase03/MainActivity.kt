package com.example.clase03

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botonMusic = findViewById<Button>(R.id.btnMusic)
        val botonMedia = findViewById<Button>(R.id.btnMedia)
        val botonVideo = findViewById<Button>(R.id.btnVideo)
        botonMusic.setOnClickListener{v:View ->
            val intent = Intent(applicationContext, MusicActivity::class.java)
            startActivity(intent)
        }
        botonMedia.setOnClickListener{v:View ->
            val intent = Intent(applicationContext, MediaActivity::class.java)
            startActivity(intent)
        }
        botonVideo.setOnClickListener{v:View ->
            val intent = Intent(applicationContext, VideoActivty::class.java)
            startActivity(intent)
        }
    }
}