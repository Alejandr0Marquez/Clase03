package com.example.clase03

import android.annotation.SuppressLint
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageButton
import android.widget.SeekBar
import android.widget.TextView
import java.util.Locale
import java.util.concurrent.TimeUnit

class MusicActivity : AppCompatActivity() {
    private var play: ImageButton? = null
    private var pause: ImageButton? = null
    private var forward: ImageButton? = null
    private var backward: ImageButton? = null
    private var title: TextView? = null
    private var duration: TextView? = null
    private var current: TextView? = null
    private var finalTime = 0
    private var seekBar: SeekBar? = null
    private val time = 5000
    var currentPosition = 0
    private var mediaPlayer: MediaPlayer? = null

    private var handler: Handler? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music)

        play = findViewById(R.id.imbReproducir)
        pause = findViewById(R.id.imbPausa)
        forward = findViewById(R.id.imbAdelante)
        backward = findViewById(R.id.imbRetroceder)
        title = findViewById(R.id.txtMusic_cancion)
        duration = findViewById(R.id.txtMusic_duracion)
        current = findViewById(R.id.txtMusic_tiempo)
        seekBar = findViewById(R.id.sbrMusic_tiempo)

        mediaPlayer = MediaPlayer.create(this, R.raw.natap3)
        handler.apply {  }
        pause!!.isEnabled = false
        play!!.setOnClickListener{
            mediaPlayer!!.start()
            title!!.text = "Natanal cano"
            finalTime = mediaPlayer!!.duration
            seekBar!!.max = finalTime
            duration!!.text = String.format(
                Locale.getDefault(),
                "%d min, %sec",
                TimeUnit.MILLISECONDS.toMinutes(finalTime.toLong()),
                TimeUnit.MILLISECONDS.toSeconds(finalTime.toLong()) % 60
            )
            handler!!.postDelayed(updatime, 100)
            pause!!.isEnabled = true
            play!!.isEnabled = false
        }
        pause!!.setOnClickListener{
            mediaPlayer!!.pause()
            pause!!.isEnabled = false
            play!!.isEnabled = true
        }
        forward!!.setOnClickListener{
            if(currentPosition + time <= finalTime){
                mediaPlayer!!.seekTo((currentPosition + time))
            } else {
                mediaPlayer!!.seekTo(finalTime)
            }
        }
        backward!!.setOnClickListener{
            if(currentPosition - time >= 0){
                mediaPlayer!!.seekTo((currentPosition - time))
            } else {
                mediaPlayer!!.seekTo(0)
            }
        }
    }

    private val updatime: Runnable = object : Runnable{
        override fun run() {
            currentPosition = mediaPlayer!!.currentPosition
            current!!.text = String.format(
                Locale.getDefault(),
                "%d min, %d sec",
                TimeUnit.MILLISECONDS.toMinutes(currentPosition.toLong()),
                TimeUnit.MILLISECONDS.toSeconds(currentPosition.toLong()) % 60
            )
            seekBar!!.progress = currentPosition
            handler!!.postDelayed(this, 100)
        }
    }
}