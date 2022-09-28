package com.example.dsp_practical_6

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import androidx.core.view.WindowCompat
import com.example.dsp_practical_6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window,false)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        intitvideoplayer()

        binding.btnSwitch.setOnClickListener {
            Intent(this,youtube_activity::class.java).apply { startActivity(this) }

        }

    }
private fun intitvideoplayer(){

    val mediaController=android.widget.MediaController(this)
    val uri=Uri.parse("android.resource://" + packageName + "/"+ R.raw.thestoryoflight)
    binding.myvideoview.setMediaController(mediaController)
    mediaController.setAnchorView(binding.myvideoview)
    binding.myvideoview.setVideoURI(uri)
    binding.myvideoview.requestFocus()
    binding.myvideoview.start()
}

}