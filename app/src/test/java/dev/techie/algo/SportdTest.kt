package dev.techie.algo

import junit.framework.TestCase

class SportdTest : TestCase() {


    fun test() {
        val sportStats = listOf(
            Sportd.Summary(Sportd.Sport.HIKE, 92),
            Sportd.Summary(Sportd.Sport.RUN, 77),
            Sportd.Summary(Sportd.Sport.TOURING_BICYCLE, 322),
            Sportd.Summary(Sportd.Sport.E_TOURING_BICYCLE, 656)
        )

        val exp = Sportd.Summary(Sportd.Sport.TOURING_BICYCLE, 322)

        assertEquals(exp, Sportd.main())
    }
}