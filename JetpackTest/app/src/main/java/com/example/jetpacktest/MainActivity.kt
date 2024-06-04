package com.example.jetpacktest

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.edit
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.work.BackoffPolicy
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkInfo
import androidx.work.WorkManager
import com.example.jetpacktest.databinding.ActivityMainBinding
import java.util.concurrent.TimeUnit
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    lateinit var viewModel: MainViewModel
    lateinit var sp: SharedPreferences
    lateinit var myObserver: MyObserver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        myObserver = MyObserver(lifecycle)
        lifecycle.addObserver(myObserver)

        sp = getPreferences(Context.MODE_PRIVATE)
        val countReserved = sp.getInt("count_reserved", 0)

        viewModel = ViewModelProvider(
            this,
            MainViewModelFactory(countReserved)
        ).get(MainViewModel::class.java)
        mainBinding.plusOneBtn.setOnClickListener {
            viewModel.plusOne()
        }
        mainBinding.clearBtn.setOnClickListener {
            viewModel.clear()
        }
//        viewModel.counter.observe(this, Observer { count ->
//            mainBinding.infoText.text = count.toString()
//        })

        viewModel.counter.observe(this) {
            mainBinding.infoText.text = it.toString()
        }

        mainBinding.currentActivityState.setOnClickListener {
            Log.d("MainActivity", lifecycle.currentState.toString())
        }

        mainBinding.getUserBtn.setOnClickListener {
            val userId = (0..1000).random().toString()
            viewModel.getUser(userId)
        }
        viewModel.user.observe(this) { user ->
            mainBinding.infoText.text = user.firstName
        }


        val userDao = AppDatabase.getDatabase(this).userDao()
        val user1 = User("Tom", "Brady", 40)
        val user2 = User("Tom", "Hanks", 63)
        mainBinding.addDataBtn.setOnClickListener {
            thread {
                user1.id = userDao.insertUser(user1)
                user2.id = userDao.insertUser(user2)
            }
        }
        mainBinding.updateDataBtn.setOnClickListener {
            thread {
                user1.age = 42
                userDao.updateUser(user1)
            }
        }
        mainBinding.deleteDataBtn.setOnClickListener {
            thread {
                userDao.deleteUserByLastName("Hanks")
            }
        }
        mainBinding.queryData.setOnClickListener {
            thread {
                for (user in userDao.loadAllUsers()) {
                    Log.d("MainActivity", user.toString())
                }
            }
        }

        mainBinding.doWorkBtn.setOnClickListener {
            val request = OneTimeWorkRequestBuilder<SimpleWorker>()
                .setInitialDelay(5, TimeUnit.MINUTES)
                .addTag("simple")
                .setBackoffCriteria(BackoffPolicy.LINEAR, 10, TimeUnit.SECONDS)
                .build()

            val request2 = OneTimeWorkRequestBuilder<SimpleWorker>().build()
            val request3 = OneTimeWorkRequestBuilder<SimpleWorker>().build()
            WorkManager.getInstance(this).enqueue(request)

            WorkManager.getInstance(this).cancelAllWorkByTag("simple")
            WorkManager.getInstance(this).cancelWorkById(request.id)


            WorkManager.getInstance(this)
                .getWorkInfoByIdLiveData(request.id).observe(this) { workInfo ->
                    if (workInfo.state == WorkInfo.State.SUCCEEDED) {
                        Log.d("MainActivity", "do work succeed")
                    } else if (workInfo.state == WorkInfo.State.FAILED) {
                        Log.d("MainActivity", "do work failed")
                    }
                }

            WorkManager.getInstance(this).beginWith(request)
                .then(request2)
                .then(request3)
                .enqueue()
        }


    }

    private fun refreshCounter() {
        mainBinding.infoText.text = viewModel.counter.toString()
    }

    override fun onPause() {
        super.onPause()
        sp.edit {
            putInt("count_reserved", viewModel.counter.value ?: 0)
        }
    }
}