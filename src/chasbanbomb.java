
public class Chasbanbomb extends Bombs {
//    private int bombNum=30;

    final int CHASBANBOMB = 30;


    private int power=100;
    Game game;

    public Chasbanbomb(int X, int Y, int direct) {
        super.bombX=X;
        super.bombY=Y;
        super.direct=direct;
    }

    public void destroy() {
        switch (direct){
            case 1:
                if (super.bombX<20 && super.bombY+2>=0 ) {
                    if (p1.posX==super.bombX && p1.posY==super.bombY+2 ){
                        p1.life-=power;
                        p1.turnAccess=false;
                    }
                    if (p2.posX==super.bombX && p2.posY==super.bombY+2 ){
                        p2.life-=power;
                        p2.turnAccess=false;
                    }
                }
            case 2:
                if (super.bombX+2<20 && super.bombY>=0 ){
                    if (p1.posX==super.bombX+2 && p1.posY==super.bombY ){
                        p1.life-=power;
                        p1.turnAccess=false;
                    }
                    if (p2.posX==super.bombX+2 && p2.posY==super.bombY ){
                        p2.life-=power;
                        p2.turnAccess=false;
                    }
                }

            case 3:
                if (super.bombX<20 && super.bombY-2>=0 ){
                    if (p1.posX==super.bombX && p1.posY==super.bombY-2 ){
                        p1.life-=power;
                        p1.turnAccess=false;
                    }
                    if (p2.posX==super.bombX && p2.posY==super.bombY-2 ){
                        p2.life-=power;
                        p2.turnAccess=false;
                    }
                }
            case 4:
                if (super.bombX-2<20 && super.bombY>=0 ){
                    if (p1.posX==super.bombX-2&& p1.posY==super.bombY ){
                        p1.life-=power;
                        p1.turnAccess=false;
                    }
                    if (p2.posX==super.bombX-2 && p2.posY==super.bombY ){
                        p2.life-=power;
                        p2.turnAccess=false;
                    }
                }


        }
    }

    public void duty() {
        destroy();
    }

}
