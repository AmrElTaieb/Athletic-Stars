package eg.gov.iti.kotlin_project.ViewModels

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import eg.gov.iti.kotlin_project.Repository.AthletesRepository

class MainViewModelFactory (private val athletesRepository: AthletesRepository)
    :ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(athletesRepository) as T
    }
}