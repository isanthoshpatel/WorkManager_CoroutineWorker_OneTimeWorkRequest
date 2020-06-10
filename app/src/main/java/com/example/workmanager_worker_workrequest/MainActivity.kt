package com.example.workmanager_worker_workrequest

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.work.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineDispatcher
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity() {

    lateinit var work1: OneTimeWorkRequest
    lateinit var workManager: WorkManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt_mywork.setOnClickListener {
            work1 = OneTimeWorkRequest.Builder(MyWork::class.java)
                .addTag("work1").build()
            workManager = WorkManager.getInstance(this)
            workManager.enqueue(work1)

        }
        bt_cancelwork.setOnClickListener {
            workManager.cancelAllWork()
        }

    }

}
