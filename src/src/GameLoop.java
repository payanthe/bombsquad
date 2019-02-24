import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * Created by parsa on 12/23/2016.
 */
public class GameLoop extends JPanel implements Runnable ,KeyListener {
    boolean shift = false;


int ertefa=-100;
    boolean ertefaflag=false;
    public static int lifebefp1 = 600;
    public static int lifebefp2 = 600;
    int p1bomb = 0;
    int p2bomb = 0;

    public static int tasVAlue=0;

    Random random=new Random();


    public void gameSound(){
        if (game.p1.life < lifebefp1) {
            playSound("aaah.wav");
            lifebefp1 = game.p1.life;
        }
        if (game.p2.life < lifebefp2) {
            playSound("aaah.wav");
            lifebefp2 = game.p2.life;
        }
        if (game.p1.kindBomb != p1bomb) {
            if (game.p1.kindBomb!=0)
            playSound("bombim.wav");
            p1bomb = game.p1.kindBomb;
        }


        if (game.p2.kindBomb != p2bomb) {
            if (game.p1.kindBomb!=0)
            playSound("bombim.wav");
            p2bomb = game.p2.kindBomb;
        }

    }


    public static synchronized void playSound(final String url) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    Clip clip = AudioSystem.getClip();
                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                            getClass().getResource(url));
                    clip.open(inputStream);
                    clip.start();
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        }).start();
    }


    Game game = new Game();
    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.bombMaker();
        }
    });




    public void makeTaas(){
        game.turnOrg();
        tasVAlue=random.nextInt(6)+1;
//        System.out.println("tasva: "+tasVAlue);
//        System.out.println("game.turn : "+game.turn);

    }



    public void run() {
        while (true) {
            if (ertefaflag){
                if (ertefa<150)
                ertefa++;
                if (ertefa==300)
                    ertefaflag=false;
            }
            repaint();

            if (GameGR.state.equals("game")) {
                game.p1.checkHouse();
                game.p2.checkHouse();
                gameSound();
                game.winner();
            }
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }



    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

//        System.out.println("taaaaaaas value: "+ tasVAlue); //////////////////////
//        System.out.println("tuuuuuuurns: "+ game.turn);

        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
      //      System.out.println(game.p2.kindBomb);
            if (game.turn==2) {
                if (game.p2.kindBomb != 0) {


//                        playSound("bombim.wav");
                    if (game.p2.kindBomb!=10) {
                        playSound("bip.wav");

                        System.out.println(game.p2.kindBomb);
                    }
                    game.p2.pushBomb();
                    //game.turnOrg();
                }
            }


        } else if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
            shift = true;
            System.out.println(shift);

        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            game.p2.direct = Game.RIGHT;
            if (game.p2.posX != 19) {
                if (shift != true) {
                    if (game.turn==2&&tasVAlue>0) {
                        tasVAlue--;
                        game.p2.posX++;
                    }
                    if (tasVAlue==0&&game.p2.kindBomb==0){
                        makeTaas();
                    }
                }
            }

        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            game.p2.direct = Game.LEFT;
            if (game.p2.posX != 0) {
                if (shift != true) {
                    if (game.turn==2&&tasVAlue>0) {
                        tasVAlue--;
                        game.p2.posX--;
                    }
                    if (tasVAlue==0&&game.p2.kindBomb==0){
                        makeTaas();
                    }
                }
            }
        } else if (e.getKeyCode() == KeyEvent.VK_W) {
            game.p2.direct = Game.UP;
            if (game.p2.posY != 0) {
                if (shift != true) {
                    if (game.turn==2&&tasVAlue>0) {
                        tasVAlue--;
                        game.p2.posY--;
                    }
                    if (tasVAlue==0&&game.p2.kindBomb==0){
                        makeTaas();
                    }
                }
            }

        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            game.p2.direct = Game.DOWN;
            if (game.p2.posY != 19) {
                if (shift != true) {
                    if (game.turn==2&&tasVAlue>0) {
                        tasVAlue--;
                        game.p2.posY++;
                    }
                    if (tasVAlue==0&&game.p2.kindBomb==0){
                        makeTaas();
                    }
                }
            }
        }
        //p1

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            //     check--;
            game.p1.direct = Game.UP;
            if (game.p1.posY != 0) {
                if (shift != true) {
                    if (game.turn==1&&tasVAlue>0) {
                        tasVAlue--;
                        game.p1.posY--;
                    }
                    if (tasVAlue==0&&game.p1.kindBomb==0){
                        makeTaas();
                    }
                }
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            //    check--;

            game.p1.direct = Game.LEFT;
            if (game.p1.posX != 0) {
                if (shift != true) {
                    if (game.turn==1&&tasVAlue>0) {
                        tasVAlue--;
                        game.p1.posX--;
                    }
                    if (tasVAlue==0&&game.p1.kindBomb==0){
                        makeTaas();
                    }
                }
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            //    check--;

            game.p1.direct = Game.DOWN;
            if (game.p1.posY != 19) {
                if (shift != true) {
                    if (game.turn==1&&tasVAlue>0) {
                        tasVAlue--;
                        game.p1.posY++;
                    }
                    if (tasVAlue==0&&game.p1.kindBomb==0){
                        makeTaas();
                    }
                }
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

            game.p1.direct = Game.RIGHT;
            if (game.p1.posX != 19) {
                if (shift != true) {
                    if (game.turn==1&&tasVAlue>0) {
                        tasVAlue--;
                        game.p1.posX++;
                    }
                    if (tasVAlue==0&&game.p1.kindBomb==0){
                        makeTaas();
                    }
                }
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_ENTER) {


            if (game.turn==1) {
                if (game.p1.kindBomb != 0) {


//                        playSound("bombim.wav");
                    if (game.p1.kindBomb != 10) {
                        playSound("bip.wav");

//                        System.out.println(game.p1.kindBomb);
                    }
                    game.p1.pushBomb();

                    //game.turnOrg();
                }

            }


        }
        if (e.getKeyCode() == KeyEvent.VK_T) {
            if (tasVAlue==0) {
                makeTaas();
            }

        }
//        if (e.getKeyCode() == KeyEvent.VK_U) {
//            System.out.println(game.p2.posX + "  " + game.p2.posX);
//            System.out.println(game.p2.life);
//            System.out.println(game.p1.life);
//
//
//        }


    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
            shift = false;
            System.out.println(shift);
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {

        } else if (e.getKeyCode() == KeyEvent.VK_UP) {

        }
    }
}
