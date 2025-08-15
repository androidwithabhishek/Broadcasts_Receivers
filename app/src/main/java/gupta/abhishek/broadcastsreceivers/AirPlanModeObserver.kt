package gupta.abhishek.broadcastsreceivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class AirPlanModeObserver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == Intent.ACTION_AIRPLANE_MODE_CHANGED) {
            val isAirplaneModeOn = intent.getBooleanExtra("state", false)

            if (isAirplaneModeOn){
                Toast.makeText(context,"ONN", Toast.LENGTH_SHORT).show()
                Log.d("tag" ,"ONN")
            }else{
                Toast.makeText(context,"OFF", Toast.LENGTH_SHORT).show()
                Log.d("tag" ,"OFF")
            }
        }else if(intent?.action == "com.example.MY_CUSTOM_BROADCAST"){
            Toast.makeText(context,"Custom Broadcast has Received", Toast.LENGTH_SHORT).show()
        }
    }
}