package com.example.workmanager_worker_workrequest

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import android.widget.Toast
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import kotlinx.android.synthetic.main.activity_main.*

class MyWork(c: Context, wp: WorkerParameters) : CoroutineWorker(c, wp) {
    override suspend fun doWork(): Result {
        return try {

            var c = c as MainActivity
            c.doit {
                return@doit "hello"
            }
            for (i in 0..1000000) {
                Log.i("MyTag", "work$i")
            }


            Result.success()
        } catch (e: Exception) {

            return Result.failure()
        }

    }

}