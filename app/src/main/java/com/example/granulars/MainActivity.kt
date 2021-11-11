package com.example.granulars

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var actionButton : Button
    lateinit var resetButton : Button
    lateinit var apiInterface: APIInterface
    lateinit var panels: Panels
    private var activationCount: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        actionButton = findViewById(R.id.activation)
        resetButton = findViewById(R.id.reset)

        // Get some data from clouds
        activationCount = 150000

        apiInterface = APIClient.getClient()?.create(APIInterface::class.java) ?: return

        actionButton.setOnClickListener {
            Toast.makeText(this, "This is the activation button", Toast.LENGTH_SHORT).show()

            apiInterface.getPanels().enqueue(object: Callback<Panels> {
                override fun onResponse(call: Call<Panels>, response: Response<Panels>) {
                    Log.i(TAG, "onResponse_1 is successful!")
                    panels = response.body()!!

                    val write = Write()
                    val animation = Animation()
                    animation.command = "display"
                    animation.animType = "static"
                    animation.animData = "13 " +
                            "42798 1 255 255 0 0 5 " + //(0, 400)
                            "28771 1 255 255 0 0 5 " + //(0, 300)
                            "11691 1 255 255 0 0 5 " + //(0, 200)
                            "48040 1 255 255 0 0 5 " + //(100, 200)
                            "47811 1 255 255 0 0 5 " + //(0, 100)
                            "61100 1 255 0 0 0 5 " + //(0, 0)
                            "64867 1 255 0 0 0 5 " + //(100, 0)
                            "47338 1 255 0 0 0 5 " + //(200, 0)
                            "23033 1 255 0 0 0 5 " + //(100, 400)
                            "43080 1 255 0 0 0 5 " + //(200, 400)
                            "4698 1 255 0 0 0 5 " + //(200, 300)
                            "12382 1 255 0 0 0 5 " + //(200, 200)
                            "16366 1 255 0 0 0 5"//(200, 100)
                    animation.loop = false
                    val palette = Palette()
                    palette.hue = 0
                    palette.saturation = 100
                    palette.brightness = 0
                    animation.palette = listOf(palette)
                    animation.colorType = "HSB"

                    animation.animData = Helper.matchSingleDigitOrK("8", animation.animData!!, panels)
                    write.write = animation

                    apiInterface.animate(write).enqueue(object : Callback<Write> {
                        override fun onResponse(call: Call<Write>, response: Response<Write>) {
                            Log.i(TAG, "onResponse_2 is successful!")
                        }

                        override fun onFailure(call: Call<Write>, t: Throwable) {
                            Log.i(TAG, "onFailure_2 is successful!")
                        }
                    })
                }

                override fun onFailure(call: Call<Panels>, t: Throwable) {
                    Log.i(TAG, "onFailure_1 is successful!")
                }

            })

        }

        resetButton.setOnClickListener {
            Toast.makeText(this, "This is the reset button", Toast.LENGTH_SHORT).show()

            apiInterface.getPanels().enqueue(object: Callback<Panels> {
                override fun onResponse(call: Call<Panels>, response: Response<Panels>) {
                    Log.i(TAG, "onResponse_1 is successful!")
                    panels = response.body()!!

                    val write = Write()
                    val animation = Animation()
                    animation.command = "display"
                    animation.animType = "static"
                    animation.animData = "13 " +
                            "42798 1 0 0 0 0 20 " + //(0, 400)
                            "28771 1 0 0 0 0 20 " + //(0, 300)
                            "11691 1 0 0 0 0 20 " + //(0, 200)
                            "48040 1 0 0 0 0 20 " + //(100, 200)
                            "47811 1 0 0 0 0 20 " + //(0, 100)
                            "61100 1 0 0 0 0 20 " + //(0, 0)
                            "64867 1 0 0 0 0 20 " + //(100, 0)
                            "47338 1 0 0 0 0 20 " + //(200, 0)
                            "23033 1 0 0 0 0 20 " + //(100, 400)
                            "43080 1 0 0 0 0 20 " + //(200, 400)
                            "4698 1 0 0 0 0 20 " + //(200, 300)
                            "12382 1 0 0 0 0 20 " + //(200, 200)
                            "16366 1 0 0 0 0 20"//(200, 100)
                    animation.loop = false
                    val palette = Palette()
                    palette.hue = 0
                    palette.saturation = 100
                    palette.brightness = 0
                    animation.palette = listOf(palette)
                    animation.colorType = "HSB"

                    write.write = animation

                    apiInterface.animate(write).enqueue(object : Callback<Write> {
                        override fun onResponse(call: Call<Write>, response: Response<Write>) {
                            Log.i(TAG, "onResponse_2 is successful!")
                        }

                        override fun onFailure(call: Call<Write>, t: Throwable) {
                            Log.i(TAG, "onFailure_2 is successful!")
                        }
                    })
                }

                override fun onFailure(call: Call<Panels>, t: Throwable) {
                    Log.i(TAG, "onFailure_1 is successful!")
                }

            })
        }
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}