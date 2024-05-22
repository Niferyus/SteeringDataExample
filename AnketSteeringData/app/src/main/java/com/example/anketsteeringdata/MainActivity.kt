package com.example.anketsteeringdata

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.anketsteeringdata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedpref: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        sharedpref = getSharedPreferences("com.example.anketsteeringdata", MODE_PRIVATE)
        val name = sharedpref.getString("name","-1")
        val surname = sharedpref.getString("surname","-1")
        val email = sharedpref.getString("mail","-1")
        val number = sharedpref.getString("number","-1")

        if(name != "-1" && surname != "-1" && email != "-1" &&number != "-1") {
            binding.nametext.text = "Your name: ${name}"
            binding.surnametext.text = "Your surname: ${surname}"
            binding.mailtext.text = "Your mail: ${email}"
            binding.phonetext.text = "Your phonenumber: ${number}"
        }
        else{
            binding.nametext.text = "Your name: "
            binding.surnametext.text = "Your surname: "
            binding.mailtext.text = "Your mail: "
            binding.phonetext.text = "Your phonenumber: }"
        }
    }


    fun save(view: View){
        val name = binding.editname.text.toString()
        val surname = binding.editsurname.text.toString()
        val email = binding.editTextTextEmailAddress.text.toString()
        val number = binding.editTextPhone.text.toString()

        if(name != null && surname != null && email != null &&number != null){
            binding.nametext.text = "Your name: ${name}"
            binding.surnametext.text = "Your surname: ${surname}"
            binding.mailtext.text = "Your mail: ${email}"
            binding.phonetext.text = "Your phonenumber: ${number}"
            sharedpref.edit().putString("name",name).apply()
            sharedpref.edit().putString("surname",surname).apply()
            sharedpref.edit().putString("mail",email).apply()
            sharedpref.edit().putString("number",number).apply()
        }

    }

    fun delete(view: View){
        binding.nametext.text = "Your name: "
        binding.surnametext.text = "Your surname: "
        binding.mailtext.text = "Your mail: "
        binding.phonetext.text = "Your phonenumber: "
        sharedpref.edit().remove("name").apply()
        sharedpref.edit().remove("surname").apply()
        sharedpref.edit().remove("mail").apply()
        sharedpref.edit().remove("number").apply()
    }
}