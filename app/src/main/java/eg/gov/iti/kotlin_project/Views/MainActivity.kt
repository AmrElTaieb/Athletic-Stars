package eg.gov.iti.kotlin_project.Views

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import eg.gov.iti.kotlin_project.Models.Athlete
import eg.gov.iti.kotlin_project.Models.AthleteList
import eg.gov.iti.kotlin_project.R
import eg.gov.iti.kotlin_project.Utilities.MainInjector
import eg.gov.iti.kotlin_project.ViewModels.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private var athleteList :List<Athlete>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initialize()
    }

    private fun initialize()
    {
        val mainFactory = MainInjector.provideMainViewModelFactory()
        val mainViewModel = ViewModelProviders.of(this, mainFactory).get(MainViewModel::class.java)

        mainViewModel.getAthletes().observe(this, Observer { athleteList ->
            this.athleteList = athleteList

            viewManager = LinearLayoutManager(this)
            viewAdapter = MainViewAdapter(this, athleteList)

            recyclerView = findViewById<RecyclerView>(R.id.main_recycler_view).apply {
                setHasFixedSize(true)
                layoutManager = viewManager
                adapter = viewAdapter
            }
        })
    }
}
