package com.selva.recyclerviewapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.selva.recyclerviewapp.databinding.ActivityMainBinding
import com.selva.recyclerviewapp.adapter.PersonAdapter
import com.selva.recyclerviewapp.eventlistener.PersonEventSender

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: PersonViewModel by viewModels {
        PersonViewModelFactory()
    }
    private val adapter: PersonAdapter by lazy {
        PersonAdapter(eventSender)
    }

    private val eventSender = PersonEventSender { event ->
        viewModel.handleEvent(event)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            infoRecyclerView.adapter = adapter
            infoRecyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        }
        viewModel.personItemLiveDate.observe(this@MainActivity) {
            adapter.setItems(it)
        }
        viewModel.update()
    }
}