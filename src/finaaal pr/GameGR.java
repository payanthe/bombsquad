import sun.plugin2.message.GetAuthenticationReplyMessage;

import javax.swing.*;
import java.util.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;


/**
 * Created by parsa on 12/23/2016.
 */
public class GameGR extends GameLoop {
    Rectangle rectangle=new Rectangle();
    Rectangle rectangle2=new Rectangle();
    Rectangle rectangle3=new Rectangle();
    Image player1OriR = Toolkit.getDefaultToolkit().getImage("p1r.png");
    Image back = Toolkit.getDefaultToolkit().getImage("back.png");
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

    JPanel jPanel=new JPanel();
    JPanel jstartPanel=new JPanel();
    JPanel jtassPanel=new JPanel();
    JButton jButton=new JButton("RESTART");

    JButton jstartButton=new JButton("START");
    JButton jtassButton2=new JButton("LET'S PLAY");
    JButton jtassButton1=new JButton("SELECT YOUR RANDOM TURN");

    public static String state="start";



    JFrame jFrame=new JFrame();

    int colorwinner =50;
    int imageNum=0;
    int xtaas=130;
    int ytaas=200;
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
        jFrame.setBounds(320,50,910,630);
        jFrame.setFocusable(true);
        //parsa
        setOpaque(false);
        jFrame.setBackground(new Color(1.0f,1.0f,1.0f,0f));


        jFrame.getContentPane().setBackground(Color.BLACK);
        setLayout(new BorderLayout());

        //parsa

    }


    public void init() {
        Thread thread=new Thread(this);
        thread.start();
        playSound("horror.wav");
    }



    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;
        Graphics2D g2dtaas = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_GASP);
        g2dtaas.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_GASP);
//        g2d.drawImage(img,0,0,this);
        g2d.setColor(Color.blue);
//        rectangle.setBounds(game.p1.posX*30,game.p1.posY*30,10, 10);
//        rectangle2.setBounds(game.p2.posX*30,game.p2.posY*30,10, 10);
//        rectangle.setBounds(game.p1.posX*30,game.p1.posY*30,10, 10);


        g2d.draw(rectangle);
        g2d.draw(rectangle2);

        if (game.plan[3][18] < -20) {
            g2d.setColor(Color.green);
            rectangle3.setBounds(3 * 30, 4 * 30, 10, 10);
            g2d.draw(rectangle3);

        }

        if (state.equals("game")) {
//            parsa
            g2d.setColor(Color.BLACK);
            g2d.fillRect(0,0,800,900);
            g2d.drawImage(back, 700, -11,200,283,this);


            for (int i = 0; i < game.plan.length; i++) {
                for (int j = 0; j < game.plan[0].length; j++) {
                    if (game.plan[i][j] != -600) {
                        g2d.setColor(Color.GRAY);
                        g2d.fillRect(i * 30 + 15, j * 30 + 15, 20, 20);
                    }
                    if (game.plan[i][j] == 10) {
                        g2d.setColor(Color.YELLOW);
                        g2d.fillRect(i * 30 + 15, j * 30 + 15, 20, 20);
                    }
                    if (game.plan[i][j] == 20) {
                        g2d.setColor(Color.CYAN);
                        g2d.fillRect(i * 30 + 15, j * 30 + 15, 20, 20);
                    }
                    if (game.plan[i][j] == 30) {
                        g2d.setColor(Color.MAGENTA);
                        g2d.fillRect(i * 30 + 15, j * 30 + 15, 20, 20);
                    }
                    if (game.plan[i][j] == 40) {
                        g2d.setColor(Color.GREEN);
                        g2d.fillRect(i * 30 + 15, j * 30 + 15, 20, 20);
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


            g2d.drawImage(oriplayerpic(game.p1.direct, 1), game.p1.posX * 30 + 15, game.p1.posY * 30 + 15, this);
            g2d.drawImage(oriplayerpic(game.p2.direct, 2), game.p2.posX * 30 + 15, game.p2.posY * 30 + 15, this);

            g2d.drawString("p1  " + game.p1.posX + "  " + game.p1.posY, 620, 20);
            g2d.drawString("p2   " + game.p2.posX + "  " + game.p2.posY, 620, 40);
            g2d.drawString("p2   " + game.p2.kindBomb, 620, 60);
            g2d.drawString("p1   " + game.p1.kindBomb, 620, 80);
            g2d.drawString("p1   life" + game.p1.life, 620, 100);
            g2d.drawString("p2   life" + game.p2.life, 620, 120);
            g2d.drawString("Turn acsess   " + game.turn, 620, 140);

            g2d.drawString("DICE :    " , 620, 170);
            if (GameLoop.tasVAlue>0){
                tasShow=tasVAlue;
            }
            else {
                tasShow=random.nextInt(6)+1;
            }
            switch (tasShow){
                case 1:
                    g2d.drawImage(tass1,680,155,20,20,null);
                    g2d.dispose();
                case 2:
                    g2d.drawImage(tass2,680,155,20,20,null);
                    g2d.dispose();

                case 3:
                    g2d.drawImage(tass3,680,155,20,20,null);
                    g2d.dispose();

                case 4:
                    g2d.drawImage(tass4,680,155,20,20,null);
                    g2d.dispose();

                case 5:
                    g2d.drawImage(tass5,680,155,20,20,null);
                    g2d.dispose();

                case 6:
                    g2d.drawImage(tass6,680,155,20,20,null);
                    g2d.dispose();

            }

        //parsa
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));

            g2d.setColor(getBackground());
            g2d.fill(getBounds());

            //g2d.dispose();

        }






        else if (state.equals("lose")) {


            jPanel.setBackground(Color.BLACK);
            jPanel.setBounds(0, 0, 810, 630);
            g2d.drawImage(winBomb, 180, 150, 320, 512, this);

            if (game.p2.life <= 0) {
                if (colorwinner > 250) colorwinner = 50;
                g2d.setColor(new Color(colorwinner, colorwinner, 255));
                g2d.setFont(new Font(null, Font.PLAIN, 65));
                g2d.drawString("player one is win ", 150, 120);
                colorwinner++;
            }
            if (game.p1.life <= 0) {
                if (colorwinner > 250) colorwinner = 50;
                g2d.setColor(new Color(255, colorwinner, colorwinner));
                g2d.setFont(new Font(null, Font.PLAIN, 65));
                g2d.drawString("player two is win ", 150, 120);
                colorwinner++;
            }

            jButton.setBounds(340, 500, 120, 50);
            jButton.setVisible(true);
            jButton.setBackground(Color.black);
            jButton.setText("RESTART");
            jPanel.add(jButton);
            this.add(jPanel);



            jButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    state = "turn";
                    game.reset();
                    jButton.setVisible(false);
                    removeAll();
                    showTass=false;
                }
            });





        }








        else if (state.equals("start")) {


            g2d.drawImage(startBomb, 250, 50, 287,525, null);

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
                    state = "turn";
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
                        game.p1.tas = random.nextInt(6)+1;
                        game.p2.tas = random.nextInt(6)+1;
                        if (game.p1.tas!=game.p2.tas){break;}
                    }

            this.add(jstartPanel);

        }






//        else if (state.equals("taas")) {
//
//
//            imageNum = random.nextInt(6) + 1;
//            try {
//                Thread.sleep(90);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            if (randTaasAccess) {
//
//                switch (imageNum) {
//                    case 1:
//                        g2d.drawImage(tass1, 330, 200, 150, 150, null);
//                        g2d.dispose();
//
//                    case 2:
//                        g2d.drawImage(tass2, 330, 200, 150, 150, null);
//                        g2d.dispose();
//                    case 3:
//                        g2d.drawImage(tass3, 330, 200, 150, 150, null);
//                        g2d.dispose();
//                    case 4:
//                        g2d.drawImage(tass4, 330, 200, 150, 150, null);
//                        g2d.dispose();
//                    case 5:
//                        g2d.drawImage(tass5, 330, 200, 150, 150, null);
//                        g2d.dispose();
//                    case 6:
//                        g2d.drawImage(tass6, 330, 200, 150, 150, null);
//                        g2d.dispose();
//                }
//            }
//
//            jtassButton1.setVisible(true);
//            jtassButton1.setBounds(275, 430, 250, 80);
//            jtassPanel.add(jtassButton1);
//
//
//            jtassButton1.addActionListener(new ActionListener() {
//                public void actionPerformed(ActionEvent e) {
//                    state = "turn";
//                    while (true) {
//                        game.p1.tas = random.nextInt(6)+1;
//                        game.p2.tas = random.nextInt(6)+1;
//                        if (game.p1.tas!=game.p2.tas){break;}
//                    }
//                    jtassButton1.setVisible(false);
//                    //removeAll();
//                }
//            });
//
//
//            jtassPanel.setVisible(true);
//            jtassPanel.setBounds(0, 0, 810, 630);
//            jtassPanel.setBackground(new Color(100, 100, 100));
//            this.add(jtassPanel);
//        }
//
//
//




        else if (state.equals("turn")) {
            jtassPanel.setVisible(true);
            jtassPanel.setBounds(0, 0, 810, 630);
            jtassPanel.setBackground(new Color(100, 100, 100));
            this.add(jtassPanel);

            jtassButton2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("p1 "+game.p1.tas);
                    System.out.println("p2 "+game.p2.tas);
                    showTass=true;
                  //  g2d.drawString("asdfa",0,0);

                }
            });
            if (showTass)
            g2d.fillRect(0,0,100,100);
            if (showTass){
                System.out.println("asdfas");

            }


            jtassButton2.setVisible(true);
            jtassButton2.setBounds(320, 430, 150, 30);

            jtassPanel.add(jtassButton2);
            if (showTass==true){


                    switch (game.p1.tas) {
                        case 1:
                            g2d.drawImage(tass1, xtaas, ytaas, xSizeTaas, ySizeTaas, null);
                            break;
                        case 2:
                            g2d.drawImage(tass2, xtaas, ytaas, xSizeTaas, ySizeTaas, null);
                            break;

                        case 3:
                            g2d.drawImage(tass3, xtaas, ytaas, xSizeTaas, ySizeTaas, null);
                            break;

                        case 4:
                            g2d.drawImage(tass4, xtaas, ytaas, xSizeTaas, ySizeTaas, null);
                            break;

                        case 5:
                            g2d.drawImage(tass5, xtaas, ytaas, xSizeTaas, ySizeTaas, null);
                            break;

                        case 6:
                            g2d.drawImage(tass6, xtaas, ytaas, xSizeTaas, ySizeTaas, null);
                            break;

                    }
                    switch (game.p2.tas) {
                        case 1:
                            g2d.drawImage(tass1, xtaas+400, ytaas, xSizeTaas, ySizeTaas, null);
                            break;

                        case 2:
                            g2d.drawImage(tass2, xtaas+400, ytaas, xSizeTaas, ySizeTaas, null);
                            break;

                        case 3:
                            g2d.drawImage(tass3, xtaas+400, ytaas, xSizeTaas, ySizeTaas, null);
                            break;

                        case 4:
                            g2d.drawImage(tass4, xtaas+400, ytaas, xSizeTaas, ySizeTaas, null);
                            break;

                        case 5:
                            g2d.drawImage(tass5, xtaas+400, ytaas, xSizeTaas, ySizeTaas, null);
                            break;

                        case 6:
                            g2d.drawImage(tass6, xtaas+400, ytaas, xSizeTaas, ySizeTaas, null);
                            break;
                    }
                javax.swing.Timer timer1=new javax.swing.Timer(2000,new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        state = "game";
                        game.reset();
                        removeAll();

                        System.out.println("Reading SMTP Info.");
                    }
                });
                timer1.setRepeats(false);
                timer1.start();





            }

        }

    }





    public static void main(String[] args) {
        GameGR game=new GameGR();
    }
}
