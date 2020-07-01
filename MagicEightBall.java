import java.lang.Math;
import java.awt.event.*;
import java.awt.*;
import javax.swing.JPanel;
import javax.swing.*;

public class MagicEightBall extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JLabel label;
    private JTextField question;
    private JButton ask;
    private JButton clear;
    private JButton playAgain;
    private JButton quit;

    String[] responses = new String[20];
    {
        responses[0] = "As I see it, yes.";
        responses[1] = "Ask again later.";
        responses[2] = "Better not tell you now.";
        responses[3] = "Cannot predict now.";
        responses[4] = "Concentrate and ask again.";
        responses[5] = "Don’t count on it.";
        responses[6] = "It is certain.";
        responses[7] = "It is decidedly so.";
        responses[8] = "Most likely.";
        responses[9] = "My reply is no.";
        responses[10] = "My sources say no.";
        responses[11] = "Outlook not so good.";
        responses[12] = "Outlook good.";
        responses[13] = "Reply hazy, try again.";
        responses[14] = "Signs point to yes.";
        responses[15] = "Very doubtful.";
        responses[16] = "Without a doubt.";
        responses[17] = "Yes.";
        responses[18] = "Yes – definitely.";
        responses[19] = "You may rely on it.";
    }

    public MagicEightBall() {
        new JPanel();
        setLayout(new FlowLayout());

        label = new JLabel("What Question Do You Have?");
        add(label);

        question = new JTextField("          ");
        add(question);

        ask = new JButton("Ask");
        add(ask);
        ask.addActionListener(new askListener());

        clear = new JButton("Clear");
        add(clear);
        clear.addActionListener(new clearListener());

        playAgain = new JButton("Play Again");
        add(playAgain);
        playAgain.addActionListener(new playAgainListener());

        quit = new JButton("Quit");
        add(quit);
        quit.addActionListener(new quitListener());
    }

    public static void main(String[] args){
        JFrame frame = new JFrame("Magic Eight Ball");
        frame.setLocation(100, 50);
        frame.setSize(400, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new MagicEightBall());
        frame.setVisible(true);
    }

    private class askListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            label.setText("Thinking...");
            try
            {
                Thread.sleep(3000);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
            int num = (int) Math.random() * 19;
            label.setText(responses[num]);
        }
    }

    private class clearListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            question.setText("          ");
        }
    }

    private class playAgainListener implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            label.setText("What Question Do You Have?");
        }
    }

    private class quitListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
    }
}




