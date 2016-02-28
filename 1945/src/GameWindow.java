import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * Created by chtnnnmtgkyp on 2/27/2016.
 */
public class GameWindow extends Frame implements KeyListener,MouseMotionListener,Runnable{
    int planeX,planeY,plane2X,plane2Y;
    int direction=0;
    BufferedImage background;
    BufferedImage plane1,plane2;
    JLabel status = new JLabel();
    public GameWindow(){
        planeX = 150;
        planeY = 300;
        this.setTitle("1945");
        this.setSize(400,640);
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        }
        );

        try{
            background = ImageIO.read(new File("Resouces/Background.png"));
            plane1 = ImageIO.read(new File("Resouces/PLANE1.png"));
            plane2 = ImageIO.read(new File("Resouces/PLANE2.png"));
        }catch (IOException e){}

        this.addMouseMotionListener(this);

        this.addKeyListener(this);

        repaint();
    }

    @Override
    public void paint(Graphics g){
        g.drawLine(0,0,100,100);
        g.drawImage(background,0,0,null);
        g.drawImage(plane1,planeX,planeY,null);
        g.drawImage(plane2,plane2X,plane2Y,null);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println(e.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar()=='w'){
            direction=1;
            repaint();
        }else if(e.getKeyChar()=='s'){
            direction=2;
            repaint();
        }else if(e.getKeyChar()=='a'){
            direction=3;
            repaint();
        }else if(e.getKeyChar()=='d'){
            direction=4;
            repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        direction=0;
    }

    @Override
    public void run() {
        while (true){
            if(direction==1){
                planeY-=3;
                repaint();
            }else if(direction==2){
                planeY+=3;
            }else if(direction==3){
                planeX-=3;
            }else if(direction==4){
                planeX+=3;
            }
            repaint();
            try {
                Thread.sleep(17);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        plane2X=e.getX();
        plane2Y=e.getY();
        System.out.println(plane2X+","+plane2Y);
    }

}
