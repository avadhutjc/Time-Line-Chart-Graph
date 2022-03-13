package com.ajc.time

import com.ajc.time.model.remote.ResponseDTOItem
import com.ajc.time.model.remote.api.ApiService
import com.ajc.time.model.remote.api.Network
import com.ajc.time.repository.DataRepository
import com.ajc.time.viewmodel.MainViewModel
import com.ajc.time.viewmodel.ViewModelFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel2: MainViewModel
    private lateinit var repository: DataRepository
    private var list = mutableListOf<ResponseDTOItem>()

    var manager: LinearLayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        manager = LinearLayoutManager(this)

        val userApi = Network.getInstance().create(ApiService::class.java)
        val factory = ViewModelFactory(repository)
        viewModel2 = ViewModelProviders.of(this, factory).get(MainViewModel::class.java)


        loadApi()

        viewModel2.user .observe(this, Observer {

        })


    }

    private fun loadApi() {
        viewModel2.createTransaction()
        viewModel2.user.observe(this, Observer {
            list.clear()
            if (it != null) {
                CoroutineScope(Dispatchers.IO).launch {
                    it.newCases?.let { it1 ->
                        it.newDeaths
                    }
                }
            }
            list.addAll(it.newCases as MutableList<ResponseDTOItem>)
        })
    }
}