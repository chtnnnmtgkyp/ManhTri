import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by chtnnnmtgkyp on 2/29/2016.
 */
public class Bullet {
    private int bulletX;
    private int bulletY;
    private int dir;
    public BufferedImage sprite;

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }

    public int getBulletY() {
        return bulletY;
    }

    public void setBulletY(int bulletY) {
        this.bulletY = bulletY;
    }

    public int getBulletX() {
        return bulletX;
    }

    public void setBulletX(int bulletX) {
        this.bulletX = bulletX;
    }

    public void move(){
        this.bulletY -= 10;
    }

    public void draw(Graphics g){
        g.drawImage(this.sprite,this.bulletX,this.bulletY,null);
    }
}
