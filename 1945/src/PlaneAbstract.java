/**
 * Created by chtnnnmtgkyp on 3/3/2016.
 */
public abstract class PlaneAbstract extends GameObject {
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    protected int speed;

}
