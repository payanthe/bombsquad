
public class Zaminibomb extends Bombs {


//    private int bombNum=10;

    final int ZAMINIBOMB = 10;
    private int power=100;
    public Zaminibomb(int X, int Y, int direct) {
        super.bombX=X;
        super.bombY=Y;
        super.direct=direct;

    }

    public void destroy() {
        switch (direct){
            case 1:
                if (super.bombX<20 && super.bombY+1>=0 )
                    plan[super.bombX][super.bombY + 1] -= 100;
            case 2:
                if (super.bombX+1<20 && super.bombY>=0 )
                    plan[super.bombX+1][super.bombY]-=100;
            case 3:
                if (super.bombX<20 && super.bombY-1>=0 )
                    plan[super.bombX][super.bombY-1]-=100;
            case 4:
                if (super.bombX-1<20 && super.bombY>=0 )
                    plan[super.bombX-1][super.bombY]-=100;

        }
    }

    public void duty() {
        destroy();
    }

}
