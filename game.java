import java.util.Random;


public class Game {
    int[][] plan;
    Random rand = new Random();
    int taas;
    final int UP=1;
    final int RIGHT=2;
    final int DOWN=3;
    final int LEFT=4;

    Player p1;
    Player p2;
    private int turn;


    Game(){
        p1 = new Player();
        p2 = new Player();
        this.plan=new int[20][20];


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
            p1.posX = 18;
            p1.posY = 2;
            p2.posX = 2;
            p2.posY = 18;
            p1.controller=1;
            p2.controller=2;



        }


    }


    {



    }
    public void masterGame(){
        int randp1=1+ (int)(Math.random() * ((6 - 1) + 1));
        int randp2=1+ (int)(Math.random() * ((6 - 1) + 1));
        if (p1.turnAccess)
        p1.moveCounter=randp1;


    }

    public void turndo(){
        p1.checkHouse();
        if (this.looser(p1)){}
        if (this.looser(p2)){}

    }

    public void turnOrg()
    {
        if (turn==1){
            if (p2.turnAccess==true){
                turn=2;
            }
            else {
                turn=1;
            }
        }
        else {
            if (p1.turnAccess==true){
                turn=1;
            }
            else {
                turn=2;
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
            if (plan[randX][randY]==0){
                plan[randX][randY]=randBomb;
                break;
            }
        }
    }


    public boolean winner(Player p) {
        if(p.life<=0){
            return false;
        }
        return true;
    }
    public boolean looser(Player p){
        if(p.life<=0){
            return true;
        }
        return false;
    }
}

