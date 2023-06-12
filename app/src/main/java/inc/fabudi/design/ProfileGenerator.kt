package inc.fabudi.design

import android.graphics.Color
import java.util.Random

object ProfileGenerator {
    private val profiles = ArrayList<Profile>()
    private var counter = 0
    private val randomGenerator = Random()

    fun generateProfiles(amount: Int) {
        val randomGenerator = Random()
        (0 until amount).forEach { _ ->
            val randomUsersCounter = randomGenerator.nextInt(99)
            val randomColors = ArrayList<Int>()
            (0 until 6).forEach { _ ->
                randomColors.add(getRandomColor())
            }
            profiles.add(
                Profile(
                    randomColors,
                    "${randomGenerator.nextInt(10) + 1} Days Ago",
                    "$randomUsersCounter/${randomUsersCounter + randomGenerator.nextInt(99)} users:",
                    randomGenerator.nextInt(9999).toString(),
                    randomGenerator.nextInt(999).toString(),
                    randomGenerator.nextInt(99).toString(),
                    "+${(randomGenerator.nextInt(80) + 19)}"
                )
            )
        }
    }

    private fun getRandomColor() = Color.argb(
        255,
        randomGenerator.nextInt(256),
        randomGenerator.nextInt(256),
        randomGenerator.nextInt(256)
    )


    fun getNextProfile(): Profile {
        counter++
        if (counter == 10) counter = 0
        return profiles[counter]
    }
}