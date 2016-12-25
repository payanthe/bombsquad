
public class Player extends Game{

    final int MONTASHERBOMB = 40;
    final int CHASBANBOMB = 30;
    final int NARENJAK = 20;
    final int ZAMINIBOMB = 10;
    public int life = 600;
    public boolean turnAccess = true;
    public int posX;
    public int posY;
    public int direct;
    public int controller;
    public int moveCounter;
    public int kindBomb;


    public void checkHouse() {

        if (plan[posX][posY]==ZAMINIBOMB){
            kindBomb=ZAMINIBOMB;
            plan[posX][posY]=0;
        }
        if (plan[posX][posY]==NARENJAK){
            kindBomb=NARENJAK;
            plan[posX][posY]=0;
        }
        if (plan[posX][posY]==CHASBANBOMB){
            kindBomb=CHASBANBOMB;
            plan[posX][posY]=0;
        }
        if (plan[posX][posY]==MONTASHERBOMB){
            kindBomb=MONTASHERBOMB;
            plan[posX][posY]=0;
        }
        if (plan[posX][posY]<0){
            life+=plan[posX][posY];
        }

    }

    public void pushBomb() {

        if (kindBomb==ZAMINIBOMB){
            new Zaminibomb(posX,posY,direct).duty();
        }
        if (kindBomb==NARENJAK){
            new Narenjak(posX,posY,direct).duty();
        }
        if (kindBomb == CHASBANBOMB) {
            new Chasbanbomb(posX,posY,direct).duty();

        }
        if (kindBomb==MONTASHERBOMB){
            new Montasherbomb(posX,posY,direct).duty();
        }

    }
}
