import java.util.Scanner;

/**
 * Created by chtnnnmtgkyp on 2/27/2016.
 */
public class Main {
    public static void main(String[] args) {
      GameWindow game = new GameWindow();
        Thread thread = new Thread(game);
        thread.start();
    }
}
