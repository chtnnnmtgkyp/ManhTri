import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * Created by chtnnnmtgkyp on 2/27/2016.
 */
public class GameWindow extends Frame implements KeyListener,MouseListener,MouseMotionListener,Runnable{
    //start
    Graphics seconds;
    Image image;
    //end
    BufferedImage background;
    Plane plane,plane2;
    Bullet bul, bul2;

    public GameWindow(){
        plane = new Plane();
        plane2 = new Plane();
        bul = new Bullet();
        bul2 = new Bullet();

        plane.setPlaneX(150);
        plane.setPlaneY(300);
        plane.setSpeed(3);

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
            plane.sprite = ImageIO.read(new File("Resouces/PLANE1.png"));
            plane2.sprite = ImageIO.read(new File("Resouces/PLANE2.png"));
            bul.sprite = ImageIO.read(new File("Resouces/DAN.png"));
            bul2.sprite = ImageIO.read(new File("Resouces/DAN.png"));
        }catch (IOException e){}
        //hide
        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB), new Point(0, 0), "cursor"));
        //end
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
        this.addKeyListener(this);

        repaint();
    }

    @Override
    public void update(Graphics g){
        if(image == null){
            image = createImage(this.getWidth(),this.getHeight());
            seconds = image.getGraphics();
        }
        seconds.setColor(getBackground());
        seconds.fillRect(0,0,getWidth(),getHeight());
        seconds.setColor(getForeground());
        paint(seconds);
        g.drawImage(image,0,0,null);
    }

    @Override
    public void paint(Graphics g){
        g.drawLine(0,0,100,100);
        g.drawImage(background,0,0,null);
        plane.draw(g);
        plane2.draw(g);
        bul.draw(g);
        bul2.draw(g);
//        g.drawImage(plane2,plane2X,plane2Y,null);

    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println(e.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar()=='w'){
            plane.setDir(1);
        }else if(e.getKeyChar()=='s'){
            plane.setDir(2);
        }else if(e.getKeyChar()=='a'){
            plane.setDir(3);
        }else if(e.getKeyChar()=='d'){
            plane.setDir(4);
        }
        if(e.getKeyChar()==' '){
            bul.setBulletX(plane.getPlaneX()+29);
            bul.setBulletY(plane.getPlaneY());
            bul.setDir(5);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        plane.setDir(0);
    }

    @Override
    public void run() {
        while (true){
            plane.update();
            if(bul.getDir()==5){
                bul.move();
            }
            if(bul2.getDir()==5){
                bul2.move();
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
        plane2.setPlaneX(e.getX());
        plane2.setPlaneY(e.getY());
//        System.out.println(plane2X+","+plane2Y);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        bul2.setBulletX(plane2.getPlaneX() + 29);
        bul2.setBulletY(plane2.getPlaneY());
        bul2.setDir(5);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
