
public class Montasherbomb extends Bombs {
//    private int bombNum=40;
    final int MONTASHERBOMB = 40;

    private int power=200;
    private int powerSide=100;

    public Montasherbomb(int X, int Y, int direct) {
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

                    if (p2.posX==super.bombX && p2.posY==super.bombY+4){
                        p2.life-=powerSide;
                    }
                    if (p2.posX==super.bombX && p2.posY==super.bombY+2){
                        p2.life-=powerSide;
                    }
                    if (p2.posX==super.bombX+1 && p2.posY==super.bombY+3){
                        p2.life-=powerSide;
                    }
                    if (p2.posX==super.bombX-1 && p2.posY==super.bombY+3){
                        p2.life-=powerSide;
                    }

                    if (p1.posX==super.bombX && p1.posY==super.bombY+4){
                        p1.life-=powerSide;
                    }
                    if (p1.posX==super.bombX && p1.posY==super.bombY+2){
                        p1.life-=powerSide;
                    }
                    if (p1.posX==super.bombX+1 && p1.posY==super.bombY+3){
                        p1.life-=powerSide;
                    }
                    if (p1.posX==super.bombX-1 && p1.posY==super.bombY+3){
                        p1.life-=powerSide;
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
//
                    if (p2.posX==super.bombX +4&& p2.posY==super.bombY){
                        p2.life-=powerSide;
                    }
                    if (p2.posX==super.bombX+2 && p2.posY==super.bombY){
                        p2.life-=powerSide;
                    }
                    if (p2.posX==super.bombX+3 && p2.posY==super.bombY+1){
                        p2.life-=powerSide;
                    }
                    if (p2.posX==super.bombX+3 && p2.posY==super.bombY-1){
                        p2.life-=powerSide;
                    }

                    if (p1.posX==super.bombX +4&& p1.posY==super.bombY){
                        p1.life-=powerSide;
                    }
                    if (p1.posX==super.bombX+2 && p1.posY==super.bombY){
                        p1.life-=powerSide;
                    }
                    if (p1.posX==super.bombX+3 && p1.posY==super.bombY+1){
                        p1.life-=powerSide;
                    }
                    if (p1.posX==super.bombX+3 && p1.posY==super.bombY-1){
                        p1.life-=powerSide;
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

                    //
                    if (p2.posX==super.bombX && p2.posY==super.bombY-4){
                        p2.life-=powerSide;
                    }
                    if (p2.posX==super.bombX && p2.posY==super.bombY-2){
                        p2.life-=powerSide;
                    }
                    if (p2.posX==super.bombX-1 && p2.posY==super.bombY-3){
                        p2.life-=powerSide;
                    }
                    if (p2.posX==super.bombX+1 && p2.posY==super.bombY-3){
                        p2.life-=powerSide;
                    }

                    if (p1.posX==super.bombX && p1.posY==super.bombY-4){
                        p1.life-=powerSide;
                    }
                    if (p1.posX==super.bombX && p1.posY==super.bombY-2){
                        p1.life-=powerSide;
                    }
                    if (p1.posX==super.bombX-1 && p1.posY==super.bombY-3){
                        p1.life-=powerSide;
                    }
                    if (p1.posX==super.bombX+1 && p1.posY==super.bombY-3){
                        p1.life-=powerSide;
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
                    //
                    if (p2.posX==super.bombX -4&& p2.posY==super.bombY){
                        p2.life-=powerSide;
                    }
                    if (p2.posX==super.bombX-2 && p2.posY==super.bombY){
                        p2.life-=powerSide;
                    }
                    if (p2.posX==super.bombX-3 && p2.posY==super.bombY+1){
                        p2.life-=powerSide;
                    }
                    if (p2.posX==super.bombX-3 && p2.posY==super.bombY-1){
                        p2.life-=powerSide;
                    }

                    if (p1.posX==super.bombX -4&& p1.posY==super.bombY){
                        p1.life-=powerSide;
                    }
                    if (p1.posX==super.bombX-2 && p1.posY==super.bombY){
                        p1.life-=powerSide;
                    }
                    if (p1.posX==super.bombX-3 && p1.posY==super.bombY+1){
                        p1.life-=powerSide;
                    }
                    if (p1.posX==super.bombX-3 && p1.posY==super.bombY-1){
                        p1.life-=powerSide;
                    }
                }


        }

    }

    public void duty() {
        destroy();
    }

}
