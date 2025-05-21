package com.example.kotlincoroutines

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class BasicsOfCoroutine : AppCompatActivity() {
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println("Main Program starts"+Thread.currentThread().name)

        GlobalScope.launch{  // Execute on T1
            println("Fake Program starts"+Thread.currentThread().name) // Execute T1
            delay(1000)                                 // Coroutine is suspended but T1 is not blocked
            println("Fake Program finished"+Thread.currentThread().name) // Execute on T1 or may be some other
        }

        runBlocking {
            delay(2000)
        }
        println("Main Program ends"+Thread.currentThread().name)

    }
}