
public class Narenjak extends Bombs {
//    private int bombNum=20;

    final int NARENJAK = 20;

    Game game;
    private int power=200;

    public Narenjak(Game game,int X, int Y, int direct) {
        super.bombX=X;
        super.bombY=Y;
        super.direct=direct;
        this.game=game;

    }

    public void destroy() {

        switch (direct){
            case 1:
                if (super.bombX<20 && super.bombY+3>=0 ) {
                    if (game.p1.posX==super.bombX && game.p1.posY==super.bombY+3 ){
                        game.p1.life-=power;
                    }
                    if (game.p2.posX==super.bombX && game.p2.posY==super.bombY+3 ){
                        game.p2.life-=power;
                    }
                    game.xternar=super.bombX;
                    game.yternar=super.bombY-3;
                    game.ternar=true;
                    System.out.println("raft");


                }
                break;
            case 2:
              //  System.out.println("oooooooooooooooo");
                if (super.bombX+3<20 && super.bombY>=0 ){
                    if (game.p1.posX==super.bombX+3 && game.p1.posY==super.bombY ){
                        game.p1.life-=power;
                    }
                    if (game.p2.posX==super.bombX+3 && game.p2.posY==super.bombY ){
                        game.p2.life-=power;
                    }
                    System.out.println(game.p1.direct);

                    game.xternar=super.bombX+3;
                    game.yternar=super.bombY;
                    game.ternar=true;

                }
                break;
            case 3:
                if (super.bombX<20 && super.bombY-3>=0 ){
                    if (game.p1.posX==super.bombX && game.p1.posY==super.bombY-3 ){
                        game.p1.life-=power;
                    }
                    if (game.p2.posX==super.bombX && game.p2.posY==super.bombY-3 ){
                        game.p2.life-=power;
                    }
                    game.xternar=super.bombX;
                    game.yternar=super.bombY+3;
                    game.ternar=true;

                }
                break;
            case 4:
                if (super.bombX-3<20 && super.bombY>=0 ){
                    if (game.p1.posX==super.bombX-3&& game.p1.posY==super.bombY ){
                        game.p1.life-=power;
                    }
                    if (game.p2.posX==super.bombX-3 && game.p2.posY==super.bombY ){
                        game.p2.life-=power;
                    }
                    game.xternar=super.bombX-3;
                    game.yternar=super.bombY;
                    game.ternar=true;
                }
                break;

        }

    }

    public void duty() {
        destroy();
    }

}
