package com.example.cakesapikotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.widget.Toast
import retrofit2.Callback
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    var adatper : CustomAdapter = CustomAdapter()
    private val activityCallback = object : Callback<List<CakePoko>>{
        override fun onFailure(call: Call<List<CakePoko>>, t: Throwable) {
            Toast
                .makeText(this@MainActivity,t.message, Toast.LENGTH_SHORT)
                .show()
        }

        override fun onResponse(call: Call<List<CakePoko>>, response: Response<List<CakePoko>>) {
            adatper.setDataset(response.body()!!)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.adapter = adatper
        recyclerView.layoutManager = GridLayoutManager(
            this@MainActivity, 2
        )
        NetworkConnection.initRetrofit(activityCallback)
    }
}
