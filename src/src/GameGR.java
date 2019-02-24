import sun.plugin2.message.GetAuthenticationReplyMessage;

import javax.swing.*;
import java.awt.geom.Rectangle2D;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


/**
 * Created by parsa on 12/23/2016.
 */
public class GameGR extends GameLoop {
    Rectangle rectangle=new Rectangle();
    Rectangle rectangle2=new Rectangle();
    Rectangle rectangle3=new Rectangle();
    Image player1OriR = Toolkit.getDefaultToolkit().getImage("p1r.png");
    Image restart = Toolkit.getDefaultToolkit().getImage("restart.png");
    Image playeronewin = Toolkit.getDefaultToolkit().getImage("playeronewin.png");
    Image playertwowin = Toolkit.getDefaultToolkit().getImage("playertwowin.png");
    Image backturn = Toolkit.getDefaultToolkit().getImage("back2.png");
    Image exp = Toolkit.getDefaultToolkit().getImage("exp.gif");
    Image back = Toolkit.getDefaultToolkit().getImage("back.png");
    Image dor = Toolkit.getDefaultToolkit().getImage("dor.png");
    Image bomb1 = Toolkit.getDefaultToolkit().getImage("bomb1.png");
    Image bomb2= Toolkit.getDefaultToolkit().getImage("bomb2.png");
    Image bomb3 = Toolkit.getDefaultToolkit().getImage("bomb3.png");
    Image bomb4 = Toolkit.getDefaultToolkit().getImage("bomb4.png");
    Image skull = Toolkit.getDefaultToolkit().getImage("skull.png");
    Image zamini = Toolkit.getDefaultToolkit().getImage("zamini.png");
    Image player1OriU = Toolkit.getDefaultToolkit().getImage("p1u.png");
    Image player1OriD = Toolkit.getDefaultToolkit().getImage("p1d.png");
    Image player1OriL = Toolkit.getDefaultToolkit().getImage("p1l.png");
    Image player2OriR = Toolkit.getDefaultToolkit().getImage("p2r.png");
    Image player2OriU = Toolkit.getDefaultToolkit().getImage("p2u.png");
    Image player2OriD = Toolkit.getDefaultToolkit().getImage("p2d.png");
    Image player2OriL = Toolkit.getDefaultToolkit().getImage("p2l.png");
    Image player1Ori = Toolkit.getDefaultToolkit().getImage("p1.png");
    Image player2Ori = Toolkit.getDefaultToolkit().getImage("p2.png");
    Image winBomb = Toolkit.getDefaultToolkit().getImage("Bloody-handprint.png");
    Image startBomb = Toolkit.getDefaultToolkit().getImage("game.png");
    Image tass1 = Toolkit.getDefaultToolkit().getImage("1.png");
    Image tass2 = Toolkit.getDefaultToolkit().getImage("2.png");
    Image tass3 = Toolkit.getDefaultToolkit().getImage("3.png");
    Image tass4 = Toolkit.getDefaultToolkit().getImage("4.png");
    Image tass5 = Toolkit.getDefaultToolkit().getImage("5.png");
    Image tass6 = Toolkit.getDefaultToolkit().getImage("6.png");
    Image bacheTarsnak = Toolkit.getDefaultToolkit().getImage("55752.png");

javax.swing.Timer bombtertimer= new javax.swing.Timer(1000, new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        game.ternar=false;
        game.terchasb=false;
        game.termon=false;
    }
});
    JPanel jPanel=new JPanel();
    JPanel jstartPanel=new JPanel();
    JPanel jtassPanel=new JPanel();
    JButton jButton=new JButton("");

    JButton jstartButton=new JButton("START");
    JButton jtassButton2=new JButton("LET'S PLAY");
    JButton jtassButton1=new JButton("SELECT YOUR RANDOM TURN");

    public static String state="start";



    JFrame jFrame=new JFrame();

    int colorwinner =50;
    int imageNum=0;
    int xtaas=320;
    int xtaas2=320;
    int ytaas=140;
    int xSizeTaas=150;
    int ySizeTaas=150;
    int tasShow=0;

    boolean showTass=false;


    Random random=new Random();
    // Timer timer1 = new Timer();



    public Image oriplayerpic(int ori,int player){
        if (ori==Game.RIGHT && player==1){
            return player1OriR;
        }
        if (ori==Game.UP && player==1){
            return player1OriU;
        }
        if (ori==Game.LEFT && player==1){
            return player1OriL;
        }
        if (ori==Game.DOWN && player==1){
            return player1OriD;
        }
        if (ori==Game.RIGHT && player==2){
            return player2OriR;
        }
        if (ori==Game.UP && player==2){
            return player2OriU;
        }
        if (ori==Game.LEFT && player==2){
            return player2OriL;
        }
        if (ori==Game.DOWN && player==2){
            return player2OriD;
        }
        if (ori==0 && player==2){
            return player2Ori;
        }
        if (ori==0 && player==1){
            return player1Ori;
        }
        return player1Ori;

    }
//    Image img = Toolkit.getDefaultToolkit().getImage("images.png");

    GameGR() {
        bombtertimer.setRepeats(false);
        init();

        timer.start();
        jFrame.setUndecorated(true);
        jFrame.setVisible(true);
        jFrame.add(this);

        jFrame.addKeyListener(this);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        //parsa

//        jFrame.setBounds(320,120,810,630);
        jFrame.setBounds(320,50,960,630);
        jFrame.setFocusable(true);
        //parsa
        setOpaque(false);
        jFrame.setBackground(new Color(1.0f,1.0f,1.0f,0f));


        jFrame.getContentPane().setBackground(Color.BLACK);
        setLayout(new BorderLayout());


    }


    public void init() {
        Thread thread=new Thread(this);
        thread.start();
        playSound("horror.wav");
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;
        Graphics2D g2dtaas = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_GASP);
        g2dtaas.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_GASP);
        g2d.setColor(Color.blue);

        System.out.println("arian bebin inp");
        g2d.draw(rectangle);
        g2d.draw(rectangle2);

        if (game.plan[3][18] < -20) {
            g2d.setColor(Color.green);
            rectangle3.setBounds(3 * 30, 4 * 30, 10, 10);
            g2d.draw(rectangle3);

        }

        Rectangle2D rectangle2D = new Rectangle();
        if (state.equals("game")) {
            g2d.setColor(Color.BLACK);
            g2d.fillRect(0, 0, 865, 900);
            g2d.drawImage(back, 765, -11, 200, 283, this);




            //rtfgyuhiok
            switch (game.p2.kindBomb) {
                case 10:
//                    g2d.drawImage(life100,610,400,125,210,null);
                    g2d.drawImage(bomb1, 645, 510, 50, 50, null);

                    break;
                case 20:
                    g2d.drawImage(bomb2, 645, 510, 50, 50, null);
                    break;

                case 30:
                    g2d.drawImage(bomb3, 645, 510, 50, 50, null);
                    break;

                case 40:
                    g2d.drawImage(bomb4, 645, 510, 50, 50, null);
                    break;


            }


            switch (game.p1.kindBomb) {
                case 10:
//                    g2d.drawImage(life100,610,400,125,210,null);
                    g2d.drawImage(bomb1, 775, 510, 50, 50, null);

                    break;
                case 20:
                    g2d.drawImage(bomb2, 775, 510, 50, 50, null);
                    break;

                case 30:
                    g2d.drawImage(bomb3, 775, 510, 50, 50, null);
                    break;

                case 40:
                    g2d.drawImage(bomb4, 775, 510, 50, 50, null);
                    break;


            }
            //dgydyhudhd



            for (int i = 0; i < game.plan.length; i++) {
                for (int j = 0; j < game.plan[0].length; j++) {
                    if (game.plan[i][j] != -600) {
                        if (game.plan[i][j] > -600) {
                            g2d.setColor(Color.GRAY);
                            g2d.fillRect(i * 30 + 15, j * 30 + 15, 20, 20);
                        }

                    }
                    if (game.plan[i][j] == 10) {
                        g2d.setColor(Color.YELLOW);
//                        g2d.fillRect(i * 30 + 15, j * 30 + 15, 20, 20);
                        g2d.drawImage(bomb1, i * 30 + 15, j * 30 + 15, 20, 20, null);
                    }
                    if (game.plan[i][j] == 20) {
                        g2d.setColor(Color.CYAN);
//                        g2d.fillRect(i * 30 + 15, j * 30 + 15, 20, 20);
                        g2d.drawImage(bomb2, i * 30 + 15, j * 30 + 15, 20, 20, null);

                    }
                    if (game.plan[i][j] == 30) {
                        g2d.setColor(Color.MAGENTA);
//                        g2d.fillRect(i * 30 + 15, j * 30 + 15, 20, 20);
                        g2d.drawImage(bomb3, i * 30 + 15, j * 30 + 15, 20, 20, null);

                    }
                    if (game.plan[i][j] == 40) {
                        g2d.setColor(Color.GREEN);
//                        g2d.fillRect(i * 30 + 15, j * 30 + 15, 20, 20);
                        g2d.drawImage(bomb4, i * 30 + 15, j * 30 + 15, 20, 20, null);

                    }
                }
            }


            for (int i = 0; i < game.plan.length; i++) {
                for (int j = 0; j < game.plan[0].length; j++) {

                    if (game.plan[i][j] <= -600) {
//                    g2d.setColor(Color.red);
//                    g2d.fillRect(i*30,j*30,20,20);
                        g2d.drawImage(skull, i * 30 + 15, j * 30 + 15, this);
                    }
                    if (game.plan[i][j] == -100) {
                        g2d.drawImage(zamini, i * 30 + 15, j * 30 + 15, this);
                    }

                }
            }


            g2d.drawImage(oriplayerpic(game.p1.direct, 1), game.p1.posX * 30 + 12, game.p1.posY * 30 + 12, 25, 25, this);
            g2d.drawImage(oriplayerpic(game.p2.direct, 2), game.p2.posX * 30 + 12, game.p2.posY * 30 + 12, 25, 25, this);

            g2d.drawString("p1  " + game.p1.posX + "  " + game.p1.posY, 620, 20);
            g2d.drawString("p2   " + game.p2.posX + "  " + game.p2.posY, 620, 40);
            g2d.drawString("p2   " + game.p2.kindBomb, 620, 60);
            g2d.drawString("p1   " + game.p1.kindBomb, 620, 80);
            g2d.drawString("p1   life" + game.p1.life, 620, 100);
            g2d.drawString("p2   life" + game.p2.life, 620, 120);
            g2d.drawString("Turn acsess   " + game.turn, 620, 140);

            g2d.drawString("DICE :    ", 620, 170);
            if (GameLoop.tasVAlue > 0) {
                tasShow = tasVAlue;
            } else {
                tasShow = random.nextInt(6) + 1;
            }


            //parsa

            g2d.drawImage(oriplayerpic(game.p1.direct, 1), 755, 310, 100, 100, this);
            g2d.drawImage(oriplayerpic(game.p2.direct, 2), 625, 310, 100, 100, this);


            ///////9ishudfdsdiufhusdhufhus
            if (game.ternar) {
//injaaa
                g2d.setColor(Color.pink);
//                g2d.fillRect(100,100,300,300);
                System.out.println(game.xternar + "   " + game.yternar);
//                g2d.fillRect(game.xternar * 30 + 15, game.yternar * 30 + 15, 20, 20);
                g2d.drawImage(exp, game.xternar * 30 + 15, game.yternar * 30 + 15, 20, 20, null);
//                System.out.println(game.xternar * 30 + 15+"  "+game.yternar * 30 + 15);
//                g2d.fillRect()
                bombtertimer.start();

            }

            if (game.termon) {
//injaaa
                g2d.setColor(Color.pink);
//                g2d.fillRect(100,100,300,300);
                System.out.println(game.xternar + "   " + game.yternar);
//                g2d.fillRect(game.xternar * 30 + 15, game.yternar * 30 + 15, 20, 20);
                g2d.drawImage(exp, game.xtermon * 30 + 15, (game.ytermon) * 30 + 15, 20, 20, null);
                if (game.xtermon < 20 && game.ytermon - 1 < 20)
                    g2d.drawImage(exp, game.xtermon * 30 + 15, (game.ytermon - 1) * 30 + 15, 20, 20, null);


                if (game.xtermon + 1 < 20 && game.ytermon < 20)
                    g2d.drawImage(exp, (game.xtermon + 1) * 30 + 15, game.ytermon * 30 + 15, 20, 20, null);
                if (game.xtermon - 1 < 20 && game.ytermon < 20)
                    g2d.drawImage(exp, (game.xtermon - 1) * 30 + 15, game.ytermon * 30 + 15, 20, 20, null);
                if (game.xtermon < 20 && game.ytermon + 1 < 20)
                    g2d.drawImage(exp, game.xtermon * 30 + 15, (game.ytermon + 1) * 30 + 15, 20, 20, null);
//                System.out.println(game.xternar * 30 + 15+"  "+game.yternar * 30 + 15);
//                g2d.fillRect()
                bombtertimer.start();

            }


            if (game.terchasb) {
//injaaa
                g2d.setColor(Color.pink);
//                g2d.fillRect(100,100,300,300);
                System.out.println(game.xternar + "   " + game.yternar);
//                g2d.fillRect(game.xternar * 30 + 15, game.yternar * 30 + 15, 20, 20);
                g2d.drawImage(exp, game.xterchasb * 30 + 15, game.yterchasb * 30 + 15, 20, 20, null);
//                System.out.println(game.xternar * 30 + 15+"  "+game.yternar * 30 + 15);
//                g2d.fillRect()
                bombtertimer.start();

            }


            switch (tasShow) {
                case 1:
                    g2d.drawImage(tass1, 695, 200, 80, 80, null);
                    g2d.dispose();
                case 2:
                    g2d.drawImage(tass2, 695, 200, 80, 80, null);
                    g2d.dispose();

                case 3:
                    g2d.drawImage(tass3, 695, 200, 80, 80, null);
                    g2d.dispose();

                case 4:
                    g2d.drawImage(tass4, 695, 200, 80, 80, null);
                    g2d.dispose();

                case 5:
                    g2d.drawImage(tass5, 695, 200, 80, 80, null);
                    g2d.dispose();

                case 6:
                    g2d.drawImage(tass6, 695, 200, 80, 80, null);
                    g2d.dispose();

            }


            //parsa
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));

            g2d.setColor(getBackground());
            g2d.fill(getBounds());

            //g2d.dispose();

        }



         else if (state.equals("start")) {


            g2d.drawImage(startBomb, 250, 50, 287, 525, null);

            g2d.setFont(new Font(null, Font.PLAIN, 65));
            g2d.setColor(new Color(236, 0, 140));
            g2d.setColor(getBackground());

//            g2d.drawString("BOMB SQUAD  ", 180, 100);

            jstartPanel.setVisible(true);

            jstartPanel.setBounds(0, 0, 810, 630);
            //  jstartPanel.setBackground(new Color(100, 100, 100));
            jstartButton.setBackground(Color.black);
            jstartPanel.add(jstartButton);
            jstartButton.setBorderPainted(false);
            jstartButton.setContentAreaFilled(false);
            jstartButton.setFocusPainted(false);
            jstartButton.setOpaque(false);

            jstartButton.setBounds(300, 400, 200, 180);
            jstartButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    state = "game";
                    game.reset();
                    jButton.setVisible(false);
                    removeAll();

                }
            });
            g2d.setColor(null);
//arian
//            jstartPanel.setBackground(null);
            g2d.dispose();
            jstartPanel.setOpaque(false);
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));

            g2d.setColor(getBackground());
            g2d.fill(getBounds());

            while (true) {
                game.p1.tas = random.nextInt(6) + 1;
                game.p2.tas = random.nextInt(6) + 1;
                if (game.p1.tas != game.p2.tas) {
                    break;
                }
            }

            this.add(jstartPanel);

        }
    }










    public static void main(String[] args) {
        GameGR game=new GameGR();
    }
}
