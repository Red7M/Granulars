package com.example.granulars

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var actionButton : Button
    lateinit var apiInterface: APIInterface
    lateinit var panels: Panels

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        actionButton = findViewById(R.id.activation)

        actionButton.setOnClickListener {
            Toast.makeText(this, "This is the activation button", Toast.LENGTH_SHORT).show()
            // In the background thread
            // Make a request to get cloud count
            // Make a request to get canvas meta data
            apiInterface = APIClient.getClient()?.create(APIInterface::class.java) ?: return@setOnClickListener

            apiInterface.getPanels().enqueue(object: retrofit2.Callback<Panels> {
                override fun onResponse(call: Call<Panels>, response: Response<Panels>) {
                    Log.i(TAG, "onResponse is successful!")
                    panels = response.body()!!
                }

                override fun onFailure(call: Call<Panels>, t: Throwable) {
                    Log.i(TAG, "onFailure is successful!")
                }

            })
        }
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}