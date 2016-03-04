import java.awt.image.BufferedImage;

/**
 * Created by Tdh4vnPC on 3/1/2016.
 */
public abstract class GameObject {
    public double positionX;
    public double positionY;



    public int type;
    public BufferedImage sprite;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public BufferedImage getSprite() {
        return sprite;
    }

    public void setSprite(BufferedImage sprite) {
        this.sprite = sprite;
    }
}