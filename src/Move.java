import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Move {
    final int UP=1;
    final int RIGHT=2;
    final int DOWN=3;
    final int LEFT=4;


    public Move(Player p) {
        int key = 0;
        if (key == key) {
            p.posX++;
            p.direct = UP;
        }
        if (key == key) {
            p.posY++;
            p.direct = RIGHT;
        }
        if (key == key) {
            p.posX--;
            p.direct =DOWN;
        }
        if (key == key) {
            p.posY--;
            p.direct = LEFT;
        }
        p.checkHouse();

    }


}

//    //implements KeyListener
//    @Override
//    public void keyTyped(KeyEvent e) {
//
//    }
//
//    @Override
//    public void keyPressed(KeyEvent e) {
//
//        if (e.getKeyCode() == KeyEvent.VK_RIGHT ) {
//            System.out.println("Right pressed.");
//            //p.posX++;
//            //p.direct = 4;
//
//        }
//        else if (e.getKeyCode() == KeyEvent.VK_LEFT ) {
//            System.out.println("Left pressed.");
//        }
//        else if (e.getKeyCode() == KeyEvent.VK_UP ) {
//            System.out.println("Up pressed.");
//        }
//        else if (e.getKeyCode() == KeyEvent.VK_DOWN ) {
//            System.out.println("Down pressed.");
//        }
//        else{
//            System.out.println("Key pressed: " + e.getKeyChar());
//        }
//    }
//
//    @Override
//    public void keyReleased(KeyEvent e) {
//
//    }

