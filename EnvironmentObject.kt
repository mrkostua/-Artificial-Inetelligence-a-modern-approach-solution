
import java.util.*

/**
 * @author Kostiantyn Prysiazhnyi on 30.01.2018.
 */
class EnvironmentObject(private val dimensionX: Int, private val dimensionY: Int, private val percentOfDirt: Int) {
    private val random = Random()
    var currentEnvironment: Map<Array<IntArray>, Boolean>
    var currentAmountOfDirtyRooms: Int
    var positionOfCleaner: Pair<Int, Int>

    init {
        currentEnvironment = generateInitialEnvironment()
        currentAmountOfDirtyRooms = getInitialAmountOfDirt()
        positionOfCleaner = getInitialPositionOfCleaner()
    }

    public fun isCurrentRoomClean() : Boolean{
        TODO("implement positionOfCleaner  and currentEnvironment")
    }
    private fun generateInitialEnvironment(): Map<Array<IntArray>, Boolean> {
        TODO("randomly generate some 60% of dirty rooms in [][]")
    }

    private fun getInitialAmountOfDirt(): Int = (dimensionX * dimensionY * percentOfDirt) / 100

    private fun getInitialPositionOfCleaner(): Pair<Int, Int> =
            Pair(getRandomNumber(0, dimensionX), getRandomNumber(0, dimensionY))

    private fun getRandomNumber(from: Int, to: Int): Int =
            random.nextInt(to - from) + from

}