package dev.techie.algo

object Sportd {

    enum class Sport { HIKE, RUN, TOURING_BICYCLE, E_TOURING_BICYCLE }

    data class Summary(val sport: Sport, val distance: Int)

    fun main() {
        val sportStats = listOf(Summary(Sport.HIKE, 92),
            Summary(Sport.RUN, 77),
            Summary(Sport.TOURING_BICYCLE, 322),
            Summary(Sport.E_TOURING_BICYCLE, 656))

        var top: Summary? = null

        sportStats.forEach {
            if (top?.distance ?: 0 < it.distance && it.sport != Sport.E_TOURING_BICYCLE) {
                top = it
            }
        }

        print(top)
    }
}