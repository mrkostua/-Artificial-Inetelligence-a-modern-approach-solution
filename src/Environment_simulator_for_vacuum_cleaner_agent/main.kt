package Environment_simulator_for_vacuum_cleaner_agent

/**
 * @author Kostiantyn Prysiazhnyi on 05.02.2018.
 */
fun main(args: Array<String>) {
    val environmentObject = EnvironmentObject.getInstance(10, 10, 30)
    val actuators = Actuators(environmentObject)
    println("Initial data : \n" +
            "environment size is : " + environmentObject.getXdimensionWalls() + "x" + environmentObject.getYdimensionWalls() + "\n" +
            "amount of dirt : " + environmentObject.currentAmountOfDirtyRooms + " rooms \n" +
            "randomly generated position of the vacuum cleaner : x=" + environmentObject.positionOfCleaner.first + " y=" + environmentObject.positionOfCleaner.second + "\n" +
            "amount of energy points : " + actuators.amountOfEnergyPoints + "\n\n\n")

    /**
     *Here we need to :
    (create one instances of Environment and Environment_simulator_for_vacuum_cleaner_agent.Actuators) so it is kind of Singletone )
    3) after our agent will use one instance of Environment object and Environment_simulator_for_vacuum_cleaner_agent.Actuators to test his performance

    4) Display performence mesuare for given amount of dirt and agent
    we can display amount of Default/current amount of enegry, initial/current amount of dirt
     *
     */


    println("\n\n\n" + "Results for vacuum cleaner agent simulation \n" +
            "Current amount of dirt :" + environmentObject.currentAmountOfDirtyRooms + "\n" +
            "Energy points : " + actuators.amountOfEnergyPoints + "\n" +
            "Last position of vacuum cleaner : x=" + environmentObject.positionOfCleaner.first + " y=" + environmentObject.positionOfCleaner.second)

}