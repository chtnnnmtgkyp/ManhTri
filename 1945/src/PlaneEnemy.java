import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by Tdh4vnPC on 3/1/2016.
 */
public class PlaneEnemy extends PlaneAbstract{
    private int count = 0;
    private Vector<Bullet> vecBul = new Vector<Bullet>();
    private int elip=0;
    private PlaneEnemy(){}

    public PlaneEnemy(int positionX,int positionY,int speed,int type) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.speed = speed;
        this.type = type;
        try {
            this.sprite = ImageIO.read(new File("Resources/PLANE1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void shot(){
        Bullet bullet = new Bullet((int)positionX,(int)positionY+45,-1,1);
        Bullet bullet1 = new Bullet((int)positionX+60,(int)positionY+45,-1,1);
        vecBul.add(bullet);
        vecBul.add(bullet1);
    }

    public void shot2(){
        Bullet bullet = new Bullet((int)positionX+10,(int)positionY+59,1,2);
        Bullet bullet1 = new Bullet((int)positionX+20,(int)positionY+59,-1,1);
        Bullet bullet2 = new Bullet((int)positionX+30,(int)positionY+59,-1,2);
        vecBul.add(bullet);
        vecBul.add(bullet1);
        vecBul.add(bullet2);
    }

    public void move(){
        this.positionX += this.speed;
        if(this.positionX <= 0)
        {
            this.speed =- this.speed;
        }
        if(this.positionX >= 400) {
            this.speed =- this.speed;
        }
    }
    public void moveelip(){
        elip++;
        this.positionX += (double)(15*Math.sin(elip*0.09));
        this.positionY += (double)(4*Math.cos(elip*0.09));
        System.out.println("X:" + this.positionX);
        System.out.println("Y:" + this.positionY);
    }

    public void update(){//60 lan 1 giay
        count++;
        if(count >= 120){
            if(this.type==1){
                this.shot();
            }else{
                this.shot2();
            }
            count=0;
        }
        for(Bullet bul : vecBul){
            bul.update();
        }
        if(this.type==1){
            move();
        }else{
            moveelip();
        }
    }

    public void draw(Graphics g){
        for (Bullet bul : vecBul){
            bul.draw(g);
        }
        g.drawImage(this.sprite,(int)this.positionX,(int)this.positionY,null);
    }
}
