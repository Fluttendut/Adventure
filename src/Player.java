import java.util.Scanner;

public class Player
{
    String nameOfPlayer;
    Scanner input = new Scanner(System.in);

    void nameOfPlayer()
    {
        System.out.println("What is your name brave adventure?");
        String nameOfPlayer = input.nextLine();

    }

    public void lookAround()
    {
        System.out.println("You looked around");
        //todo insert description for current room and print it
        System.out.println();
    }
}