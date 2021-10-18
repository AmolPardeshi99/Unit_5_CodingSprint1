package com.example.unit_5_codingsprint1.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.unit_5_codingsprint1.R
import com.example.unit_5_codingsprint1.datamodel.local.ActorDataDAO
import com.example.unit_5_codingsprint1.datamodel.local.ActorRoomDB
import com.example.unit_5_codingsprint1.repository.ActorRepo
import com.example.unit_5_codingsprint1.ui.pagination.ActorAdapter
import com.example.unit_5_codingsprint1.ui.pagination.ActorViewModel
import com.example.unit_5_codingsprint1.viewmodel.ActorDataViewModel
import com.example.unit_5_codingsprint1.viewmodel.ActorViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch

//@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var actorAdapter: ActorAdapter
    lateinit var  actorViewmodel :ActorViewModel

    lateinit var roomDb :ActorRoomDB
    lateinit var actorDataDAO: ActorDataDAO
    lateinit var viewModel:ActorDataViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        roomDb = ActorRoomDB.getDataBaseObject(this)
        actorDataDAO = roomDb.getActorDAO()

        val repo = ActorRepo(actorDataDAO)
        val viewModelFactory = ActorViewModelFactory(repo)
        //viewModel = ViewModelProviders.of(this).get(TasksAdapter.TaskViewHolder::class.java)
        //1st viewmodel
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ActorDataViewModel::class.java)
        // viewModel for pagination
        actorViewmodel= ViewModelProvider(this).get(ActorViewModel::class.java)
        setAdapter()

        viewModel.addDataToRoomDataBase()
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