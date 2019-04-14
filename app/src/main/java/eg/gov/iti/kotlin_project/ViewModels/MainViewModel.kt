package eg.gov.iti.kotlin_project.ViewModels

import android.arch.lifecycle.ViewModel
import eg.gov.iti.kotlin_project.Models.Athlete
import eg.gov.iti.kotlin_project.Repository.AthletesRepository

class MainViewModel (private val athletesRepository: AthletesRepository)
    : ViewModel() {
    fun getAthletes(): ArrayList<Athlete> {
        return athletesRepository.getAthletes()
    }
}