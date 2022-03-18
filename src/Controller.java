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
        //prg.userInterface(prg, helper);
        //I removed setMap as it is called in adventure already
        //prg.setMap();

        //This sout is removed as it is not needed. It is handled in my loop in the Adventure class on line 121
        //System.out.println(prg.currentRoom);

    }
}
