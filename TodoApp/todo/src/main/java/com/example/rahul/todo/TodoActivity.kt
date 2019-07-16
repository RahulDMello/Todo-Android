package com.example.rahul.todo

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.rahul.todo.databinding.ActivityTodoBinding

class TodoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityTodoBinding>(this, R.layout.activity_todo)
        Glide.with(this).load(Uri.parse("https://img.freepik.com/free-photo/man-jumping-impossible-possible-cliff-sunset-background-business-concept-idea_1323-265.jpg?size=626&ext=jpg")).into(binding.image)
    }
}
