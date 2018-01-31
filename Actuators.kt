package com.mrkostua.mathalarm

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
        when (actionType) {
            ActionType.TurnLeft -> {
                updateCleanerLocation(actionType)
                energyPoints -= 1

            }
            ActionType.TurnRight -> {
                updateCleanerLocation(actionType)
                energyPoints -= 1

            }
            ActionType.GoForward -> {
                updateCleanerLocation(actionType)
                energyPoints -= 1

            }
            ActionType.GoBack -> {
                updateCleanerLocation(actionType)
                energyPoints -= 1

            }
            else -> {
                throw UnsupportedOperationException("probably this action is not support at this moment")
            }
        }

        if (!environmentObject.isCurrentRoomClean()) {
            suckDirt()

        }
        return environmentObject
    }

    private fun updateCleanerLocation(actionType: ActionType): EnvironmentObject {
        when (actionType) {
            ActionType.TurnLeft -> {
                if (environmentObject.getXdimensionWalls().first != environmentObject.positionOfCleaner.first) {
                    environmentObject.positionOfCleaner = Pair(environmentObject.positionOfCleaner.first - 1, environmentObject.positionOfCleaner.second)

                } else {
                    //todo inform agent that he had meet the wall
                }
            }
            ActionType.TurnRight -> {
                if (environmentObject.getXdimensionWalls().second != environmentObject.positionOfCleaner.first) {
                    environmentObject.positionOfCleaner = Pair(environmentObject.positionOfCleaner.first + 1, environmentObject.positionOfCleaner.second)

                } else {
                    //todo inform agent that he had meet the wall
                }

            }
            ActionType.GoBack -> {
                if (environmentObject.getYdimensionWalls().first != environmentObject.positionOfCleaner.first) {
                    environmentObject.positionOfCleaner = Pair(environmentObject.positionOfCleaner.first, environmentObject.positionOfCleaner.second - 1)

                } else {
                    //todo inform agent that he had meet the wall
                }
            }
            ActionType.GoForward -> {
                if (environmentObject.getYdimensionWalls().second != environmentObject.positionOfCleaner.second) {
                    environmentObject.positionOfCleaner = Pair(environmentObject.positionOfCleaner.first, environmentObject.positionOfCleaner.second + 1)

                } else {
                    //todo inform agent that he had meet the wall
                }
            }
            else -> {
                //todo wrong action to change Cleaner position
            }
        }

        return environmentObject
    }

    private fun suckDirt() {
        environmentObject.currentEnvironment.replace(environmentObject.positionOfCleaner, false)
        energyPoints += 10

    }


}