import java.util.Scanner;

public class Mainmenu
{
    Scanner input = new Scanner(System.in);
    Helper helper = new Helper();
    Adventure prg;
    BackGroundMusic playMusic = new BackGroundMusic();

    public void mainmenu()
    {
        playMusic.playMusic();
        System.out.println("Welcome to the AMAZING GAME OF ADVENTURETIME!");
        System.out.println("please choose what you would like to do");
        System.out.println("1) Embark on your epic adventure \n 2) End your adventure \n 3) help menu");
        //String introInput = input.nextLine(); this was commented out as it makes no sense to use a sting to compare an int. it has been replaced with an int.
        int introInput = input.nextInt();


        if (introInput == 1)
        {
            System.out.println("Pick your class brave adventure!");
            System.out.println("""
                    1) The mighty warrior
                    2) The magnificent wizard
                    3) The noble ranger
                    4) The daring bard                    
                    """);
            int classOfChoise = input.nextInt();

            switch (classOfChoise)
            {
                case 1:
                    warrior();
                case 2:
                    wizard();
                case 3:
                    ranger();
                case 4:
                    bard();
            }

            prg = new Adventure();
        }
        else if (introInput == 2)
        {
            System.out.println("thank you for playing");
            //System.exit ends program
            System.exit(1);

        }
        else if (introInput == 3)
        {
            helper.help();
        }
        else
        {
            //todo insert loop to redo start up if non of options are chosen.
        }
    }

}