package com.codingwithset.hng_stage_two_task

import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import com.codingwithset.hng_stage_two_task.databinding.ActivitySplashBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {
    lateinit var binding:ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
    }

    private fun initAnimationOnLogo() {
        ObjectAnimator.ofFloat(binding.zuriImage, "alpha", 0.4f, 0.9f).apply {
            duration = 3000
            repeatCount = Animation.INFINITE
            start()
        }
    }

    override fun onResume() {
        super.onResume()
        initAnimationOnLogo()
        GlobalScope.launch {
            delay(5000)
            startActivity(Intent(this@SplashActivity,MainActivity::class.java))
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }
    }
}