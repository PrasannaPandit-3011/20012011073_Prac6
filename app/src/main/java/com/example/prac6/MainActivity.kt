package com.example.prac6

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import com.example.prac6.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initVideoPlayer()
        binding.fbtn.setOnClickListener{
            Intent(this@MainActivity, YoutubeActivity::class.java).apply{
                startActivity(this)
            }
        }
    }

    private fun initVideoPlayer(){
        val mediaController = MediaController(this)
        val uri : Uri = Uri.parse("android.resource://${packageName}/${R.raw.thestoryoflight}")
        binding.videoView.setMediaController(mediaController)
        mediaController.setAnchorView(binding.videoView)
        binding.videoView.setVideoURI(uri)
        binding.videoView.requestFocus()
        binding.videoView.start()
    }
}