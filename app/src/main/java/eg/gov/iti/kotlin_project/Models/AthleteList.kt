package eg.gov.iti.kotlin_project.Models

class AthleteList (private var athletes: ArrayList<Athlete>) {

    fun getAthletes(): ArrayList<Athlete> {
        return athletes
    }

    fun getAthlete(index: Int): Athlete {
        return athletes[index]
    }
}