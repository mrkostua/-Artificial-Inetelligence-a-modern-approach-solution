
/**
 * @author Kostiantyn Prysiazhnyi on 30.01.2018.
 */
public class Actuators(private val environmentObject: EnvironmentObject) {
    public var DEFAULT_AMOUNT_OF_ENERGY_POINTS = 1000
    var energyPoints: Int

    init {
        energyPoints = DEFAULT_AMOUNT_OF_ENERGY_POINTS
    }

    public fun doAction(actionType: ActionType): EnvironmentObject {
        /**
         * we need to move position of the cleaner and than check if in this room some dirt located
         * if yes clean (+ add points) it or otherwise do nothing(+ -1 energy point)
         */
        when (actionType) {
            ActionType.TurnLeft -> turnLeft()
            ActionType.TurnRight -> turnRight()
            ActionType.GoForward -> goForward()
            ActionType.GoBack -> goBack()
            ActionType.Clean -> TODO()
            ActionType.Idle ->
                return environmentObject
        }
        TODO("finish implementation")
    }

    private fun turnLeft() {

    }

    private fun turnRight() {

    }

    private fun goForward() {

    }

    private fun goBack() {

    }

    private fun suckDirt() {
        TODO("update environment data")
    }


}