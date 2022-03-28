public class Controller
{
    Player player = new Player();
    Adventure prg;

    public void go()
    {
        Mainmenu mainmenu = new Mainmenu();
        mainmenu.show(player);

        player.nameOfPlayer();
        player.lookAround();

        prg = new Adventure(player);
        Helper helper = new Helper();

        prg.playTillExit(helper);
    }
}