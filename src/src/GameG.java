//import javax.swing.*;
//import javax.swing.text.html.HTMLDocument;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
//import java.util.Iterator;
//
//
//public class GameG extends JFrame implements KeyListener {
////    JFrame frame = new JFrame("JFrame Example");
//    GameG(){
//        JFrame frame = new JFrame("HelloWorldSwing");
//        final JLabel label = new JLabel("Hello World");
//        frame.add(label);
//        frame.setSize(400,500);
//        frame.setBounds(200,200,500,700);
//        frame.pack();
//        frame.setVisible(true);
//        frame.addKeyListener(this);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        Game game=new Game();
//        for (int j = 0; j<game.plan[0].length; j++) {
//            for (int i = 0; i < game.plan.length; i++) {
//                System.out.println(game.plan[i][j]);
//            }
//        }
//        System.out.println(game.p1.posX  +"  "+game.p1.posY);
//    }
//
//
//
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
//
//    public static void main(String[] args) {
//        GameG g=new GameG();
//
//    }
//
//
//
//}
