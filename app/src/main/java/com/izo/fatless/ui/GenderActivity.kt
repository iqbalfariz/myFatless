package com.izo.fatless.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.izo.fatless.MainActivity
import com.izo.fatless.databinding.ActivityGenderBinding
import com.izo.fatless.databinding.ActivityOnboardingBinding

class GenderActivity : AppCompatActivity() {

    lateinit var binding: ActivityGenderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGenderBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        val buttonBack = binding.btnBack
        val buttonFemale = binding.btnFemale
        val buttonMale = binding.btnMale

        buttonBack.setOnClickListener {
            onBackPressed()
        }

        buttonMale.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            overridePendingTransition(androidx.appcompat.R.anim.abc_popup_enter, androidx.appcompat.R.anim.abc_popup_exit)
        }

         buttonFemale.setOnClickListener {
             startActivity(Intent(this, MainActivity::class.java))
             overridePendingTransition(androidx.appcompat.R.anim.abc_popup_enter, androidx.appcompat.R.anim.abc_popup_exit)
         }
    }
}