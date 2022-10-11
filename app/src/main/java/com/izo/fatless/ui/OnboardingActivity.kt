package com.izo.fatless.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.activity.OnBackPressedCallback
import com.izo.fatless.MainActivity
import com.izo.fatless.R
import com.izo.fatless.databinding.ActivityOnboardingBinding
import com.izo.fatless.databinding.ActivitySplashScreenBinding

class OnboardingActivity : AppCompatActivity() {

    lateinit var binding: ActivityOnboardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        val onboardingIllustration = binding.ivOnboardingIllustration
        val imageAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_repeat)

        onboardingIllustration.startAnimation(imageAnimation)

        binding.btnPredict.setOnClickListener {
            startActivity(Intent(this, GenderActivity::class.java))
            overridePendingTransition(androidx.appcompat.R.anim.abc_popup_enter, androidx.appcompat.R.anim.abc_popup_exit)
        }
    }
}