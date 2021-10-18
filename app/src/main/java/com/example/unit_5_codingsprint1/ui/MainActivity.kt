package com.example.unit_5_codingsprint1.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.unit_5_codingsprint1.R
import com.example.unit_5_codingsprint1.ui.pagination.ActorAdapter
import com.example.unit_5_codingsprint1.ui.pagination.ActorViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var actorAdapter: ActorAdapter

    val actorViewmodel :ActorViewModel by

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        actorViewmodel= ViewModelProvider(this).get(ActorViewModel::class.java)
        setAdapter()


        actorViewmodel.searchActor().observe(
            this,{
                it?.let {
                    CoroutineScope(Main).launch {
                        actorAdapter.submitData(it)
                    }
                }
            }
        )
    }

    private fun setAdapter() {
        actorAdapter = ActorAdapter()
        val linearlayoutManager = LinearLayoutManager(this)
        recyclerView.apply {
            layoutManager =linearlayoutManager
            this.adapter = actorAdapter
        }
    }
}