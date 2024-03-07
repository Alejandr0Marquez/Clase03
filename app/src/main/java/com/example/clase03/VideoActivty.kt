package com.example.clase03


import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView

class VideoActivty : AppCompatActivity() {
    private var videoView: VideoView? = null
    private var mediaController: MediaController? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)

        videoView = findViewById(R.id.videoView)
        mediaController = MediaController(this)
        mediaController!!.setAnchorView(videoView)

        val uri = Uri.parse("android.resource://"+ packageName +"/" + R.raw.natap4)
        videoView!!.setVideoURI(uri)
        videoView!!.requestFocus()
        videoView!!.start()
        Toast.makeText(this, "Comienza video", Toast.LENGTH_SHORT).show()
        videoView!!.setMediaController(mediaController)
    }
}

