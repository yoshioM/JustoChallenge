package com.yoshio.challenge.ui.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.yoshio.challenge.databinding.ActivityMainBinding
import com.yoshio.challenge.ui.view.adapters.UserAdapter
import com.yoshio.challenge.ui.viewmodel.RandomUserViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val randomUserViewModel: RandomUserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        randomUserViewModel.onCreate()

        randomUserViewModel.isLoading.observe(this, Observer {
            binding.progress.isVisible = it
        })

        randomUserViewModel.showMessage.observe(this, Observer {message ->
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

        })

        randomUserViewModel.userModel.observe(this, androidx.lifecycle.Observer { userList ->
            binding.rvUsers.layoutManager = LinearLayoutManager(this)
            binding.rvUsers.adapter = UserAdapter(userList)
        })

        binding.btnAdd.setOnClickListener {
            randomUserViewModel.onCreate()
        }

        binding.btnClear.setOnClickListener {
           randomUserViewModel.clearData()
        }
    }
}