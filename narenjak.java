
public class Narenjak extends Bombs {
//    private int bombNum=20;

    final int NARENJAK = 20;


    private int power=200;

    public Narenjak(int Y, int X, int direct) {
        super.bombX=X;
        super.bombY=Y;
        super.direct=direct;
    }

    public void destroy() {

        switch (direct){
            case 1:
                if (super.bombX<20 && super.bombY+3>=0 ) {
                    if (p1.posX==super.bombX && p1.posY==super.bombY+3 ){
                        p1.life-=power;
                    }
                    if (p2.posX==super.bombX && p2.posY==super.bombY+3 ){
                        p2.life-=power;
                    }
                }
            case 2:
                if (super.bombX+3<20 && super.bombY>=0 ){
                    if (p1.posX==super.bombX+3 && p1.posY==super.bombY ){
                        p1.life-=power;
                    }
                    if (p2.posX==super.bombX+3 && p2.posY==super.bombY ){
                        p2.life-=power;
                    }
                }

            case 3:
                if (super.bombX<20 && super.bombY-3>=0 ){
                    if (p1.posX==super.bombX && p1.posY==super.bombY-3 ){
                        p1.life-=power;
                    }
                    if (p2.posX==super.bombX && p2.posY==super.bombY-3 ){
                        p2.life-=power;
                    }
                }
            case 4:
                if (super.bombX-3<20 && super.bombY>=0 ){
                    if (p1.posX==super.bombX-3&& p1.posY==super.bombY ){
                        p1.life-=power;
                    }
                    if (p2.posX==super.bombX-3 && p2.posY==super.bombY ){
                        p2.life-=power;
                    }
                }


        }

    }

    public void duty() {
        destroy();
    }

}
