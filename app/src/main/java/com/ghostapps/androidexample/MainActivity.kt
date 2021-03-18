package com.ghostapps.androidexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ghostapps.androidexample.data.UserHttp
import com.ghostapps.androidexample.model.UserModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainActivity() : AppCompatActivity(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    private var loadUsersJob: Job? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainLoadContactsButton.setOnClickListener {
            loadUsers()
        }

        mainContactList.layoutManager = LinearLayoutManager(this)
    }

    override fun onDestroy() {
        loadUsersJob?.cancel()
        super.onDestroy()
    }

    private fun loadUsers() {
        loadUsersJob = launch {
            val users = withContext(Dispatchers.IO) {
                UserHttp.loadUsers().toList()
            }
            mainContactList.adapter = UserAdapter(users)
        }
    }
}