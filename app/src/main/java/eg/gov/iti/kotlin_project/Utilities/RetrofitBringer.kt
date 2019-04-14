package eg.gov.iti.kotlin_project.Utilities

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import eg.gov.iti.kotlin_project.Models.Athlete
import eg.gov.iti.kotlin_project.Models.AthleteList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBringer {

    private var athleteList = mutableListOf<Athlete>()
    private var athletes = MutableLiveData<List<Athlete>>()
    private val URL = "https://gist.githubusercontent.com/"

    init {
        val retrofit = Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build()
        val gsonResponse = retrofit.create(RetrofitResponse::class.java)
        val call = gsonResponse.getAthletes()
        call.enqueue(object : Callback<AthleteList> {
            override fun onResponse(call: Call<AthleteList>, response: Response<AthleteList>) {
                athleteList = response.body()!!.getAthletes()
//                Log.e("Amr", " ${athleteList.get(0).name} hopaaaaaaaaaaaaaaaaaaa")
                athletes.value = athleteList
//                Log.e("Amr", " ${athletes.value!!.get(0).name} hopaaaaaaaaaaaaaaaaaaa")
            }

            override fun onFailure(call: Call<AthleteList>, t: Throwable) {
                //
            }
        })
    }

    fun getAthletes() = athletes as LiveData<ArrayList<Athlete>>
}