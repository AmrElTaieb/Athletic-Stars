package eg.gov.iti.kotlin_project.Repository

import android.arch.lifecycle.LiveData
import android.util.Log
import eg.gov.iti.kotlin_project.Models.Athlete
import eg.gov.iti.kotlin_project.Models.AthleteList
import eg.gov.iti.kotlin_project.Utilities.RetrofitBringer

class AthletesRepository private constructor(private val bringer: RetrofitBringer){
    companion object {
        @Volatile private var sharedInstance: AthletesRepository? = null

        fun getSharedInstance(bringer: RetrofitBringer) =
                sharedInstance ?: synchronized(this) {
                    sharedInstance ?: AthletesRepository(bringer).also { sharedInstance = it }
                }
    }

    fun getAthletes() = bringer.getAthletes()
}