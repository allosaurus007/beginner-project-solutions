import java.util.Random;
import java.awt.event.*;
import java.awt.*;
import javax.swing.JPanel;
import javax.swing.*;

public class RockPaperScissors extends JPanel{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JLabel choice;
    private JButton rock;
    private JButton paper;
    private JButton scissors;
    private JLabel score;
    private JLabel scorePlayer;
    private JLabel scoreCom;
    private JLabel result;

    public String player;
    public String computer;
    public Random generator = new Random();
    public int playerWins;
    public int comWins;
    public String outcome;
    public String[] computerChoices = new String[3];{
        computerChoices[0] = "Rock";
        computerChoices[1] = "Paper";
        computerChoices[2] = "Scissors";
    }
    public String[][] outcomes = new String[3][3];{
        outcomes[0][0] = "tie";
        outcomes[0][1] = "player loss";
        outcomes[0][2] = "player win";
        outcomes[1][0] = "player win";
        outcomes[1][1] = "tie";
        outcomes[1][2] = "player loss";
        outcomes[2][0] = "player loss";
        outcomes[2][1] = "player win";
        outcomes[2][2] = "tie";
    }

    public RockPaperScissors(){
        new JPanel(new FlowLayout());

        choice = new JLabel("Make Your Choice.");
        add(choice);

        rock = new JButton("Rock");
        rock.addActionListener(new rockListener());
        add(rock);

        paper = new JButton("Paper");
        paper.addActionListener(new paperListener());
        add(paper);

        scissors = new JButton("Scissors");
        scissors.addActionListener(new scissorListener());
        add(scissors);

        result = new JLabel();
        add(result);

        score = new JLabel("Score:");
        add(score);

        scorePlayer = new JLabel("0");
        add(scorePlayer);

        scoreCom = new JLabel("0");
        add(scoreCom);
    }

    public static void main(String[] args){
        JFrame frame = new JFrame("Rock, Paper, Scissors Game");
        frame.setLocation(100, 50);
        frame.setSize(400, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new RockPaperScissors());
        frame.setVisible(true);
    }

    private class rockListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            player = "Rock";
            computer = comMove();
            outcome = duel(player, computer);
            result.setText(outcome);
            score(outcome);
        }
    }

    private class paperListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            player = "Paper";
            computer = comMove();
            outcome = duel(player, computer);
            result.setText(outcome);
            score(outcome);
        }
    }

    private class scissorListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            player = "Scissors";
            computer = comMove();
            outcome = duel(player, computer);
            result.setText(outcome);
            score(outcome);
        }
    }

    public String comMove(){
        int choice = generator.nextInt(3);
        return computerChoices[choice];
    }

    public String duel(String play, String com){
        int playNum = 0;
        int comNum = 0;

        switch (play) {
            case "Rock":
                playNum = 0;
                break;
        
            case "Paper":
                playNum = 1;
                break;

            case "Scissors":
                playNum = 2;
                break;
            
            default:
                playNum = 0;
                break;
        }

        switch (com) {
            case "Rock":
                comNum = 0;
                break;
        
            case "Paper":
                comNum = 1;
                break;

            case "Scissors":
                comNum = 2;
                break;
            
            default:
                comNum = 0;
                break;
        }

        return outcomes[playNum][comNum];
    }

    public void score(String s){
        switch (s) {
            case "tie":
                break;
            
            case "player loss":
                comWins++;
                scoreCom.setText("" + comWins);
                break;

            case "player win":
                playerWins++;
                scorePlayer.setText("" + playerWins);
                break;
        
            default:
                break;
        }
    }
    
}