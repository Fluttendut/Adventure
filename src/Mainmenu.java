import java.util.Scanner;

public class Mainmenu
{
    Scanner input = new Scanner(System.in);
    Helper helper = new Helper();
    Adventure prg;

    public void mainmenu()
    {
        System.out.println("Welcome to the AMAZING GAME OF ADVENTURETIME!");
        System.out.println("please choose what you would like to do");
        System.out.println("1) Embark on your epic adventure \n 2) End your adventure \n 3) help menu");
        String introInput = input.nextLine();
        if (introInput.equals(1))
        {
            //instanciating adventure and starting game
            prg = new Adventure();
        }
        else if (introInput.equals(2))
        {
            //todo insert exit();
        }
        else if (introInput.equals(3))
        {
            helper.help();
        }
        else
        {
            //todo insert loop to redo start up if non of options are chosen.
        }
    }
}