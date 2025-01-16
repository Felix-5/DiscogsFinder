package com.example.discogsfinder.ui.main

import com.example.discogsfinder.data.network.DiscogsResponse
import com.example.discogsfinder.data.network.DiscogsRelease
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.discogsfinder.data.local.AppDatabase
import com.example.discogsfinder.data.local.MusicReleaseEntity
import com.example.discogsfinder.data.network.RetrofitInstance
import com.example.discogsfinder.databinding.ActivityMainBinding
import com.example.discogsfinder.R
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = AppDatabase.getDatabase(this)
        val dao = db.releaseDao()

        binding.searchButton.setOnClickListener {
            val query = binding.searchEditText.text.toString()
            RetrofitInstance.api.searchReleases(query).enqueue(object : Callback<DiscogsResponse> {
                override fun onResponse(call: Call<DiscogsResponse>, response: Response<DiscogsResponse>) {
                    response.body()?.results?.let { releases ->
                        for (release in releases) {
                            Log.d("Discogs", "ID: ${release.id}, Title: ${release.title}, Year: ${release.year}, Thumb: ${release.thumb}")
                        }
                    }
                }

                override fun onFailure(call: Call<DiscogsResponse>, t: Throwable) {
                    Log.e("API_ERROR", t.message ?: "Unknown error")
                }
            })
        }
    }
}
