package com.example.rahul.app

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.rahul.app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        setSupportActionBar(binding.toolbar)
    }

    fun onTodoClick(v: View) {
        Navigation.findNavController(v).navigate(R.id.todoActivity)
    }
}
