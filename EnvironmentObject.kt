import java.util.*

/**
 * @author Kostiantyn Prysiazhnyi on 30.01.2018.
 */
class EnvironmentObject(private val dimensionX: Int, private val dimensionY: Int, private val percentOfDirt: Int) {
    private val random = Random()
    private val amountOfRooms = dimensionX * dimensionY
    var currentEnvironment: MutableMap<Pair<Int, Int>, Boolean>
    var currentAmountOfDirtyRooms: Int
    var positionOfCleaner: Pair<Int, Int>
	
    
    init {
        currentEnvironment = generateInitialEnvironment()
        currentAmountOfDirtyRooms = getInitialAmountOfDirt()
        positionOfCleaner = getInitialPositionOfCleaner()

    }

    public fun isCurrentRoomClean(): Boolean = currentEnvironment[positionOfCleaner] ?: true

    private fun generateInitialEnvironment(): MutableMap<Pair<Int, Int>, Boolean> {
		//first of all we need to intial some size of enviroment in our app it can only x/y enviroment with walls and without any obstacles
		//also we need in some way generate percentOfDirt and randomly set it in environment
		val environmentMap = MutableMap<Pair<Int,Int>, Boolean>()
        for(x in 0..dimensionX){
            for(y in 0..dimensionY){
                environmentMap.put(Pair(x,y),false)
            }
        }
       // use method genareteRandomlyDirtyRooms to set random rooms as dirty rooms
        
        return environmentMap
    }
   private val dirtyRoomsLocationList : MutableSet<Pair<Int,Int>> = HashSet<Pair<Int,Int>>() 
    private fun genareteRandomlyDirtyRooms() {
        //here we need to randomly generate some amount of dirty rooms Pair(int,int) and every new generated room need to be unique so we can generate precisely given amount of dirty rooms
   		     val requiredAmountOfDirt = getInitialAmountOfDirt()
       var dirtyRoomLocation : Pair<Int,Int> = Pair<0,0>
        	while(i<requiredAmountOfDirt){
                dirtRoomLocation = Pair(getRandomNumber(0, dimensionX), getRandomNumber(0, dimensionY))
                if(!dirtyRoomsLocationList.contains(dirtRoomLocation)){
                    dirtyRoomsLocationList.put(dirtRoomLocation)
                    i++
                }
            }
    }

    private fun getInitialAmountOfDirt(): Int = (dimensionX * dimensionY * percentOfDirt) / 100

    private fun getInitialPositionOfCleaner(): Pair<Int, Int> =
            Pair(getRandomNumber(0, dimensionX), getRandomNumber(0, dimensionY))

    private fun getRandomNumber(from: Int, to: Int): Int =
            random.nextInt(to - from) + from

    public fun getXdimensionWalls(): Pair<Int, Int> = Pair(0, dimensionX)

    public fun getYdimensionWalls(): Pair<Int, Int> = Pair(0, dimensionY)
}
