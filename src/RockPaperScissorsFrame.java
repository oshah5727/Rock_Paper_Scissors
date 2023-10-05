import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RockPaperScissorsFrame extends JFrame implements ActionListener {
    private JPanel mainPnl;
    private JPanel buttonPnl;
    private JPanel statsPnl;
    private JPanel resultsPnl;
    private JLabel playerWinLbl;
    private JLabel computerWinLbl;
    private JLabel tieLbl;

    private JTextField playerWinFld;
    private JTextField computerWinFld;
    private JTextField tieFld;
    private JTextArea resultTA;

    private JScrollPane scroller;

    private JButton rockBtn;

    private JButton paperBtn;

    private JButton scissorBtn;

    private JButton quitBtn;

    private ImageIcon rockIcon;

    private ImageIcon paperIcon;

    private ImageIcon scissorIcon;

    private ImageIcon quitIcon;

    private int playerWinsCount = 0;

    private int computerWinsCount = 0;

    private int tiesCount = 0;

    private Random randomSelection = new Random();

    public RockPaperScissorsFrame() {
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());

        createButtonPanel();
        mainPnl.add(buttonPnl, BorderLayout.NORTH);

        createStatsPanel();
        mainPnl.add(statsPnl, BorderLayout.CENTER);

        createResultsPanel();
        mainPnl.add(resultsPnl, BorderLayout.SOUTH);

        add(mainPnl);
    }

    private void createButtonPanel() {
        buttonPnl = new JPanel();
        buttonPnl.setLayout(new GridLayout());
        buttonPnl.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        rockIcon = new ImageIcon("src/rockPaperScissorsRockImg.png");
        paperIcon = new ImageIcon("src/rockPaperScissorsPaperImg.png");
        scissorIcon = new ImageIcon("src/rockPaperScissorsScissorImg.png");
        quitIcon = new ImageIcon("src/rockPaperScissorsQuitImg.png");

        Image rockIconImage = rockIcon.getImage();
        Image rockImg = rockIconImage.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH);
        rockIcon = new ImageIcon(rockImg);


        Image paperIconImage = paperIcon.getImage();
        Image paperImg = paperIconImage.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH);
        paperIcon = new ImageIcon(paperImg);


        Image scissorIconImage = scissorIcon.getImage();
        Image scissorImg = scissorIconImage.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH);
        scissorIcon = new ImageIcon(scissorImg);


        Image quitIconImage = quitIcon.getImage();
        Image quitImg = quitIconImage.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH);
        quitIcon = new ImageIcon(quitImg);


        rockBtn = new JButton(rockIcon);
        rockBtn.addActionListener(this);

        paperBtn = new JButton(paperIcon);
        paperBtn.addActionListener(this);

        scissorBtn = new JButton(scissorIcon);
        scissorBtn.addActionListener(this);

        quitBtn = new JButton(quitIcon);
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));

        buttonPnl.add(rockBtn);
        buttonPnl.add(paperBtn);
        buttonPnl.add(scissorBtn);
        buttonPnl.add(quitBtn);

    }

    private void createStatsPanel() {
       statsPnl = new JPanel();
       statsPnl.setLayout(new FlowLayout());

       playerWinLbl = new JLabel("Player Wins", JLabel.LEFT);
       computerWinLbl = new JLabel("Computer Wins", JLabel.LEFT);
       tieLbl = new JLabel("Ties", JLabel.LEFT);

       playerWinFld = new JTextField(5);
       playerWinFld.setEditable(false);

       computerWinFld = new JTextField(5);
       computerWinFld.setEditable(false);

       tieFld = new JTextField(5);
       tieFld.setEditable(false);

        statsPnl.add(playerWinLbl);
        statsPnl.add(playerWinFld);
        statsPnl.add(computerWinLbl);
        statsPnl.add(computerWinFld);
        statsPnl.add(tieLbl);
        statsPnl.add(tieFld);

    }

     private void createResultsPanel() {
       resultsPnl = new JPanel();
       resultTA = new JTextArea(10, 50);
       resultTA.setEditable(false);
       resultTA.setFont(new Font("Serif", Font.PLAIN, 15));
       scroller = new JScrollPane(resultTA);

       resultsPnl.add(scroller);
    }

    private String playRPSGame(String playerChoice) {
        String computerChoice = randomSelection.nextInt(3) == 0 ? "Rock" : randomSelection.nextInt(3) == 1 ? "Paper" : "Scissors";
        String result = "";
        if (playerChoice.equals("Rock") && computerChoice.equals("Scissors")) {
            result = "Rock breaks Scissors (Player Wins)";
        } else if (playerChoice.equals("Paper") && computerChoice.equals("Rock")) {
            result = "Paper covers Rock (Player Wins)";
        } else if (playerChoice.equals("Scissors") && computerChoice.equals("Paper")) {
            result = "Scissors covers Paper (Player Wins)";
        } else if (playerChoice.equals(computerChoice)) {
            result = "It's a Tie!";
        } else {
             if (computerChoice.equals("Rock") && playerChoice.equals("Scissors")) {
                result = "Rock breaks Scissors (Computer Wins)";
            }
            else if(computerChoice.equals("Paper") && playerChoice.equals("Rock")) {
                result = "Paper covers Rock (Computer Wins)";
            }
            else if(computerChoice.equals("Scissors") && playerChoice.equals("Paper")) {
                result = "Scissors covers Paper (Computer Wins)";
             }
            else if(computerChoice.equals(playerChoice)) {
                result = "It's a Tie!";
             }
        }

        return result;
    }

    private void updateStats(String result) {
        if (result.contains("Player Wins")) {
            playerWinsCount++;
        } else if (result.contains("Computer Wins")) {
            computerWinsCount++;
        } else {
            tiesCount++;
        }

        playerWinFld.setText(String.valueOf(playerWinsCount));
        computerWinFld.setText(String.valueOf(computerWinsCount));
        tieFld.setText(String.valueOf(tiesCount));
    }

    private void appendResult(String result) {
        resultTA.append(result + "\n");
    }

    private void rockButtonClick() {
        String result = playRPSGame("Rock");
        updateStats(result);
        appendResult(result);
    }

    private void paperButtonClick() {
        String result = playRPSGame("Paper");
        updateStats(result);
        appendResult(result);
    }

    private void scissorButtonClick() {
        String result = playRPSGame("Scissors");
        updateStats(result);
        appendResult(result);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == rockBtn) {
            rockButtonClick();

        }

        else if(e.getSource() == paperBtn) {
            paperButtonClick();

        }
        else if (e.getSource() == scissorBtn) {
            scissorButtonClick();

        }
    }
}
