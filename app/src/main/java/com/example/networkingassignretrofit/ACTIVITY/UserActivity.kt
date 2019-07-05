package com.example.networkingassignretrofit

import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import kotlinx.android.synthetic.main.activity_user.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class UserActivity : AppCompatActivity(), CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        launch {
            val users = getUserRetrofit()

            rView0.layoutManager = LinearLayoutManager(this@UserActivity) as RecyclerView.LayoutManager?
            rView0.adapter = UserAdapter(users)

        }


    }

    suspend fun getUserRetrofit(): List<Users> {
        val userApi = RetrofitClient.userApi

        val response = userApi.getUsers()
        return if (response.isSuccessful) {
            response.body()!!
        } else {
            emptyList()
        }
    }

}
