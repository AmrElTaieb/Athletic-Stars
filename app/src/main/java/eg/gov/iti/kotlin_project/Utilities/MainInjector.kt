package eg.gov.iti.kotlin_project.Utilities

import eg.gov.iti.kotlin_project.Models.Athlete
import eg.gov.iti.kotlin_project.Repository.AthletesRepository
import eg.gov.iti.kotlin_project.ViewModels.MainViewModelFactory

object MainInjector {
    fun provideMainViewModelFactory() : MainViewModelFactory {
        return MainViewModelFactory(AthletesRepository.getSharedInstance(RetrofitBringer()))
    }
}