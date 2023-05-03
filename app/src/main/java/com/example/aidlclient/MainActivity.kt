package com.example.aidlclient

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.os.RemoteException
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.aidlserver.IAIDLColorInterface


class MainActivity : AppCompatActivity() {

    var iAIDLColorService: IAIDLColorInterface? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent = Intent("AIDLColorService")
        intent.setPackage("com.example.aidlserver")
        bindService(intent, mConnection, BIND_AUTO_CREATE)
        Log.d(TAG, "bindservice called")
        val b = findViewById<Button>(R.id.button)
        b.setOnClickListener { view ->
            try {
                val color: Int? = iAIDLColorService?.getColor()
                val name: String? = iAIDLColorService?.getNames()
                Toast.makeText(this@MainActivity, "VSight Member: $name", Toast.LENGTH_SHORT).show()
                view.setBackgroundColor(color!!)
            } catch (e: RemoteException) {
            }
        }
    }

    companion object {
        private const val TAG = "MainActivity"
    }

    private val mConnection = object : ServiceConnection {

        override fun onServiceConnected(componentName: ComponentName, iBinder: IBinder) {
            iAIDLColorService = IAIDLColorInterface.Stub.asInterface(iBinder)
            Log.d(TAG, "Remote config Service Connected!!")
        }

        override fun onServiceDisconnected(componentName: ComponentName) {
            Log.e(TAG, "Service has unexpectedly disconnected")
            iAIDLColorService = null
        }
    }
}
