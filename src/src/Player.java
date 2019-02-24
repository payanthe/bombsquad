
public class Player {
Game game;
    Player(Game g){
        plan=g.plan;
        game=g;

    }


    static final int NARENJAK = 20;
    public int life = 600;
    public boolean turnAccess = true;
    public int posX;
    public int posY;
    public int direct;
    public int controller;
    public int kindBomb;
    public int tas;
    int[][] plan;


    public void checkHouse() {


//        if (plan[posX][posY]<=(-600)){
//
//                life=0;
//            System.out.println(life);
//
//
//        }
        if (plan[posX][posY]<0){
            life+=plan[posX][posY];
            System.out.println(life);
            plan[posX][posY]=0;
        }


        if (plan[posX][posY]==NARENJAK){
            kindBomb=NARENJAK;
            plan[posX][posY]=0;
        }
        if (plan[posX][posY]<0){
            life+=plan[posX][posY];
        }

    }

    public void pushBomb() {


        if (kindBomb==NARENJAK){
            new Narenjak(game,posX,posY,direct).duty();
            kindBomb=0;
        }

    }
}
