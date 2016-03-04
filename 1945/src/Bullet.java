import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Tdh4vnPC on 3/1/2016.
 */
public class Bullet extends GameObject{

    private int speed;


    private Bullet() {
        this.positionX = 0;
        this.positionY = 0;
    }

    public Bullet(double positionX, double positionY, int speed, int type) {//Alt + Inseart
        this.positionX = positionX;
        this.positionY = positionY;
        this.speed = speed;
        this.type = type;
        try {
            this.sprite = ImageIO.read(new File("Resources/DAN.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void move(){
        this.positionY -= this.speed;
    }

    public void move2(){
        if(this.speed < 0) {
            this.positionX -= this.speed;
            this.positionY -= this.speed;
        }else{
            this.positionX -= this.speed;
            this.positionY += this.speed;
        }
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void update(){
        if(this.type==1){
            this.move();
        }else{
            this.move2();
        }
    }

    public void draw(Graphics g){
        g.drawImage(sprite,(int)positionX,(int)positionY,null);
    }



    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
