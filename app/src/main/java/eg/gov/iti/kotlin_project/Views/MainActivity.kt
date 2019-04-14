package eg.gov.iti.kotlin_project.Views

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import eg.gov.iti.kotlin_project.R
import eg.gov.iti.kotlin_project.Utilities.MainInjector
import eg.gov.iti.kotlin_project.ViewModels.MainViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initialize()
    }

    private fun initialize()
    {
        val mainFactory = MainInjector.provideMainViewModelFactory()
        val mainViewModel = ViewModelProviders.of(this, mainFactory).get(MainViewModel::class.java)
    }
}
