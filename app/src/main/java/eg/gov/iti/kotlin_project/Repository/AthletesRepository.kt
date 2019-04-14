package eg.gov.iti.kotlin_project.Repository

import eg.gov.iti.kotlin_project.Models.Athlete
import eg.gov.iti.kotlin_project.Models.AthleteList

class AthletesRepository private constructor(private val athlete: Athlete){
    companion object {
        @Volatile private var sharedInstance: AthletesRepository? = null

        fun getSharedInstance(athlete: Athlete) =
                sharedInstance ?: synchronized(this) {
                    sharedInstance ?: AthletesRepository(athlete).also { sharedInstance = it }
                }
    }

    fun getAthletes(): AthleteList? {
        var list: AthleteList? = null;
        return list
    }
}