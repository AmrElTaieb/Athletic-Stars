package eg.gov.iti.kotlin_project.Models

class AthleteList (private var athletes: ArrayList<Athlete>) {

    fun setAthletes(athletes: ArrayList<Athlete>){
        this.athletes = athletes
    }

    fun getAthletes(): ArrayList<Athlete> {
        return athletes
    }

    fun getAthlete(index: Int): Athlete {
        return athletes[index]
    }
}