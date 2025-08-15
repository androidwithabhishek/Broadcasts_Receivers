package gupta.abhishek.broadcastsreceivers

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var airPlanModeObserver: AirPlanModeObserver
    lateinit var btn1: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


        }
        btn1 = findViewById(R.id.btn1)
        btn1.setOnClickListener {
            val intent = Intent("com.example.MY_CUSTOM_BROADCAST")
            intent.setPackage(packageName)
            sendBroadcast(intent)
        }


    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onStart() {
        super.onStart()
        airPlanModeObserver = AirPlanModeObserver()
//        val intentFilter = IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        val intentFilter = IntentFilter("com.example.MY_CUSTOM_BROADCAST")
        registerReceiver(airPlanModeObserver, intentFilter, Context.RECEIVER_NOT_EXPORTED)


    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(airPlanModeObserver)
    }

}

//registerReceiver
//unregisterReceiver
//sendBroadcast
