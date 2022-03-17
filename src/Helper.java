public class Helper
{
    public void help()
    {
        System.out.println("""
                Here are some keywords you can use throughout the game:

                look      = Looking around at the current location
                go east   = Moves player towards east
                go west   = Moves player towards west
                go north  = Moves player towards north
                go south  = Moves player towards south
                help      = Opens help menu
                exit      = Game terminates
                """);
    }
}