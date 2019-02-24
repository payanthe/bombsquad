import java.util.Random;

public class Game {
    int xternar;
    int yternar;
    boolean ternar;


    int xterchasb;
    int yterchasb;
    boolean terchasb;


    int xtermon;
    int ytermon;
    boolean termon;

    int[][] plan;
    Random rand = new Random();
    int taas;
    static final int UP=1;
    static final int RIGHT=2;
    static final int DOWN=3;
    static final int LEFT=4;


    Player p1;
    Player p2;
    int turn=0;


    Game(){

        this.plan=new int[20][20];

        p1 = new Player(this);
        p2 = new Player(this);
        reset();


    }

    public void reset(){
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                this.plan[i][j] = 0;
            }
        }

        for (int i = 0; i < 20; i++) {
            plan[i][0] = 0;
            plan[0][i] = 0;
            plan[19][i] = 0;
            plan[i][19] = 0;
        }

        for (int i = 3; i <= 16; i++) {
            plan[i][3] = -600;
            plan[i][4] = -600;
            plan[i][7] = -600;
            plan[i][8] = -600;
            plan[i][11] = -600;
            plan[i][12] = -600;
            plan[i][15] = -600;
            plan[i][16] = -600;
            p1.posX = 17;
            p1.posY = 1;
            p1.posX = 18;
            p1.posY = 1;
            p2.posX = 1;
            p2.posY = 18;
            p1.controller=1;
            p2.controller=2;
        }
        p1.life=600;
        p2.life=600;
        GameLoop.lifebefp1 = 600;
        GameLoop.lifebefp2 = 600;
    }






    public void turnOrg()
    {
        if (turn==1){
            if (p2.turnAccess==true){
                turn=2;
            }
            else {
                turn=1;
                p2.turnAccess=true;
            }
        }
        else {
            if (p1.turnAccess==true){
                turn=1;
            }
            else {
                turn=2;
                p1.turnAccess=true;
            }
        }
    }





    public void diceCount(){
        taas= rand.nextInt(6)+1;
    }

    public void bombMaker(){
        while (true) {
            int randX = rand.nextInt(20) + 0;
            int randY = rand.nextInt(20) + 0;
            int randBomb = (rand.nextInt(4) + 1)*10;
//            int randX =  0;
//            int randY = 0;
//            int randBomb = 30;
            if (plan[randX][randY]==0){
                plan[randX][randY]=10;
                break;
            }
        }
    }


    public boolean looser(Player p){
        if(p.life<=0){
            return true;
        }
        return false;
    }
    public void winner(){
        if (looser(p1)==true){
            GameGR.state="start";
        }
        else if (looser(p2)==true){
            GameGR.state="start";
        }
    }
}