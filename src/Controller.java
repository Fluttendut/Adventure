public class Controller
{
    public void go()
    {
        Mainmenu mainmenu = new Mainmenu();
        Player player = new Player();
        mainmenu.mainmenu();
        player.nameOfPlayer();
        player.lookAround();
        Helper helper = new Helper();
        Adventure prg = new Adventure();
        prg.playTillExit(prg, helper);

    }
}