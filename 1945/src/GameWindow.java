
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by hungtran on 2/26/16.
 */
public class GameWindow extends Frame implements Runnable {
    Graphics seconds;
    Image image;
    BufferedImage background;
    Plane planeMoveByKey,planeMoveByMouse;
    //PlaneEnemy planeEnemy;
    Vector<PlaneEnemy> vectorPlaneEnemy = new Vector<PlaneEnemy>();
    int direction = 0;

    public GameWindow() {

        //thiet lap tieu de cho cua so
        this.setTitle("TechKids - code the change");
        //thiet lap kich thuoc cho cua so
        this.setSize(400, 640);
        //thiet lap xem cua so co hien thi hay khong
        this.setVisible(true);
        //khi an vao nut X thi thoat
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
        //hide
        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB), new Point(0, 0), "cursor"));
        //end
        //load Image tu thu muc Resource
        try {
            background = ImageIO.read(new File("Resources/Background.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        initPlane();
        //bat su kien di chuyen chuot
        //this.addMouseListener();
        //doan code de bat su kien bam phim
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if(e.getModifiers()==InputEvent.BUTTON1_MASK){
                    planeMoveByMouse.shot();

                }
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
        });
        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                planeMoveByMouse.move(e.getX(),e.getY());
            }
        });
        this.addKeyListener(new KeyListener() {
            //truoc khi bam
            @Override
            public void keyTyped(KeyEvent e) {

            }
            //khi dang giu phim
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_A) {
                    planeMoveByKey.setDirection(3);
                } else if(e.getKeyCode() == KeyEvent.VK_D) {
                    planeMoveByKey.setDirection(4);
                } else if(e.getKeyCode() == KeyEvent.VK_W) {
                    planeMoveByKey.setDirection(1);
                } else if(e.getKeyCode() == KeyEvent.VK_S) {
                    planeMoveByKey.setDirection(2);
                } else if(e.getKeyCode() == KeyEvent.VK_SPACE){
                    planeMoveByKey.shot();
                }
            }
            //khi nhac phim len
            @Override
            public void keyReleased(KeyEvent e) {
                planeMoveByKey.setDirection(0);
            }
        });
    }
    private void initPlane(){

        planeMoveByKey = new Plane(200,200,3,4);
        planeMoveByMouse = new Plane(300,300,4,2);
        // planeEnemy = new PlaneEnemy(200,200,5);
        vectorPlaneEnemy.add(new PlaneEnemy(100, 50, 1,1));
        vectorPlaneEnemy.add(new PlaneEnemy(0, 200, 2,2));
//        vectorPlaneEnemy.add(new PlaneEnemy(100, 150, 3));
//        vectorPlaneEnemy.add(new PlaneEnemy(250, 120, 4));
//        vectorPlaneEnemy.add(new PlaneEnemy(300, 90, 5));
//        planeMoveByKey.setPositionX(300);
//        planeMoveByKey.setPositionY(400);
//        planeMoveByKey.setSpeed(4);
//        //planeImage = ImageIO.read(new File("Resources/PLANE1.png"));
//        try {
//            planeMoveByKey.setSprite(ImageIO.read(new File("Resources/PLANE1.png")));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Plane planeMoveByMouse = new Plane();

    }
    //ham ve
    //ve~ moi. thu o day
    @Override
    public void update(Graphics g){
        if(image == null){
            image = createImage(this.getWidth(), this.getHeight());
            seconds= image.getGraphics();
        }
        seconds.setColor(getBackground());
        seconds.fillRect(0,0,getWidth(),getHeight());
        seconds.setColor(getForeground());
        paint(seconds);
        g.drawImage(image,0,0,null);
    }
    @Override
    public void paint(Graphics g) {

        super.paint(g);

        g.drawImage(background, 0, 0, null);

        planeMoveByKey.draw(g);
        planeMoveByMouse.draw(g);
        for(PlaneEnemy planeEnemy : vectorPlaneEnemy){
            planeEnemy.draw(g);
        }
        //g.drawLine(0,0, 100, 100);
    }
    //Game Loop
    //Vong Lap game
    @Override
    public void run() {

        while(true) {

            planeMoveByKey.update();
            planeMoveByMouse.update();
            for(PlaneEnemy planeEnemy : vectorPlaneEnemy){
                planeEnemy.update();
            }
            repaint();

            try {
                Thread.sleep(17);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}