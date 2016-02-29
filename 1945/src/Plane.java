import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by chtnnnmtgkyp on 2/28/2016.
 */
public class Plane{
    private int planeX;
    private int planeY;
    private int planeX2;
    private int planeY2;
    private int speed;
    private int hp;
    private int damage;
    private int planeType;
    public BufferedImage sprite;
    public BufferedImage sprite1;

    private int dir;

    public int getPlaneX() {
        return planeX;
    }

    public void setPlaneX(int planeX) {
        this.planeX = planeX;
    }

    public int getPlaneY() {
        return planeY;
    }

    public void setPlaneY(int planeY) {
        this.planeY = planeY;
    }

    public int getPlaneX2() {
        return planeX2;
    }

    public void setPlaneX2(int planeX2) {
        this.planeX2 = planeX2;
    }

    public int getPlaneY2() {
        return planeY2;
    }

    public void setPlaneY2(int planeY2) {
        this.planeY2 = planeY2;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getPlaneType() {
        return planeType;
    }

    public void setPlaneType(int planeType) {
        this.planeType = planeType;
    }

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }

    private void move(){
            if (dir == 0) {
            } else if (dir == 1) {
                this.planeY -= this.speed;

            } else if (dir == 2) {
                this.planeY += this.speed;

            } else if (dir == 3) {
                this.planeX -= this.speed;

            } else if (dir == 4) {
                this.planeX += this.speed;

            }
    }

    public void update(){
        this.move();
    }

    public void draw(Graphics g){
        g.drawImage(this.sprite,this.planeX,this.planeY,null);
    }

}
