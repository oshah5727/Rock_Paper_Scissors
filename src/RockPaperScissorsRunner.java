import javax.swing.*;

public class
RockPaperScissorsRunner {
    public static void main(String[] args) {
        RockPaperScissorsFrame rpsFrame = new RockPaperScissorsFrame();

        rpsFrame.setTitle("Rock Paper Scissors Game");
        rpsFrame.setSize(800,800);
        rpsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rpsFrame.setVisible(true);
    }
}