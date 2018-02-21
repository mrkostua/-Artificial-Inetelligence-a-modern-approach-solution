package Environment_simulator_for_vacuum_cleaner_agent

import java.util.*

/**
 * @author Kostiantyn Prysiazhnyi on 30.01.2018.
 */

class EnvironmentObject private constructor(private val dimensionX: Int, private val dimensionY: Int, private val percentOfDirt: Int) {
    private val random = Random()
    private val amountOfRooms = dimensionX * dimensionY
    private val dirtyRoomsLocationList: MutableSet<Pair<Int, Int>> = HashSet()

    var currentEnvironment: MutableMap<Pair<Int, Int>, Boolean>
    var currentAmountOfDirtyRooms: Int
    var positionOfCleaner: Pair<Int, Int>
    val initialAmountOfDirt = (dimensionX * dimensionY * percentOfDirt) / 100


    init {
        currentEnvironment = generateInitialEnvironment()
        currentAmountOfDirtyRooms = initialAmountOfDirt
        positionOfCleaner = getInitialPositionOfCleaner()

    }

    companion object {
        @Volatile
        private var INSTANCE: EnvironmentObject? = null

        fun getInstance(dimensionX: Int, dimensionY: Int, percentOfDirt: Int): EnvironmentObject {
            return INSTANCE ?: synchronized(this) {
                INSTANCE
                        ?: EnvironmentObject(dimensionX, dimensionY, percentOfDirt)
            }
        }
    }


    public fun isCurrentRoomClean(): Boolean = currentEnvironment[positionOfCleaner] ?: true

    private fun generateInitialEnvironment(): MutableMap<Pair<Int, Int>, Boolean> {
        val environmentMap: MutableMap<Pair<Int, Int>, Boolean> = HashMap<Pair<Int, Int>, Boolean>()
        for (x in 0..dimensionX) {
            for (y in 0..dimensionY) {
                environmentMap.put(Pair(x, y), false)
            }
        }
        genareteRandomlyDirtyRooms()
        for (dirtLocation in dirtyRoomsLocationList) {
            environmentMap[dirtLocation] = true

        }
        return environmentMap
    }

    private fun genareteRandomlyDirtyRooms() {
        var dirtyRoomLocation = Pair(0, 0)
        var i = 0
        while (i < initialAmountOfDirt) {
            dirtyRoomLocation = Pair(getRandomNumber(0, dimensionX), getRandomNumber(0, dimensionY))
            if (!dirtyRoomsLocationList.contains(dirtyRoomLocation)) {
                dirtyRoomsLocationList.add(dirtyRoomLocation)
                i++

            }
        }
    }

    private fun getInitialPositionOfCleaner(): Pair<Int, Int> =
            Pair(getRandomNumber(0, dimensionX), getRandomNumber(0, dimensionY))

    private fun getRandomNumber(from: Int, to: Int): Int =
            random.nextInt(to - from) + from

    public fun getXdimensionWalls(): Pair<Int, Int> = Pair(0, dimensionX)

    public fun getYdimensionWalls(): Pair<Int, Int> = Pair(0, dimensionY)
}
