package eg.gov.iti.kotlin_project.Repository

import eg.gov.iti.kotlin_project.Models.Athlete

class AthletesRepository private constructor(private val athlete: Athlete){
    companion object {
        @Volatile private var sharedInstance: AthletesRepository? = null

        fun getSharedInstance(athlete: Athlete) =
                sharedInstance ?: synchronized(this) {
                    sharedInstance ?: AthletesRepository(athlete).also { sharedInstance = it }
                }
    }
}