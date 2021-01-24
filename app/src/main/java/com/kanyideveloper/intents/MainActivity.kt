package com.kanyideveloper.intents

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.kanyideveloper.intents.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var startAnotherActivity: Button

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.btnStartActivity.setOnClickListener {
            val intent = Intent(applicationContext, MainActivity2::class.java)
            startActivity(intent)
        }

        binding.btnDial.setOnClickListener {
            val phone = "+254706003891"
            val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null))
            startActivity(intent)
        }

        binding.btnStartMessage.setOnClickListener {
            val sms_uri = Uri.parse("smsto:+254706003891")
            val sms_intent = Intent(Intent.ACTION_SENDTO, sms_uri)
            sms_intent.putExtra("sms_body", "Good Morning ! how r U ?")
            startActivity(sms_intent)


        }

        binding.btnStartUrl.setOnClickListener {
            val url = "https://github.com/"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }
    }
}