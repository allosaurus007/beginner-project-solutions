import java.lang.Math;
import java.awt.event.*;
import java.awt.*;
import javax.swing.JPanel;
import javax.swing.*;

public class PythagoreanTriples extends JPanel{
    
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JLabel sideA;
    private JTextField sideAField;
    private JLabel sideB;
    private JTextField sideBField;
    private JLabel hyp;
    private JTextField hypField;
    private JButton enter;
    private JLabel answer;

    public PythagoreanTriples(){
        new JPanel(new FlowLayout());

        sideA = new JLabel("Side A:");
        add(sideA);

        sideAField = new JTextField("           ");
        add(sideAField);

        sideB = new JLabel("Side B:");
        add(sideB);

        sideBField = new JTextField("           ");
        add(sideBField);

        hyp = new JLabel("Hypotenuse:");
        add(hyp);

        hypField = new JTextField("           ");
        add(hypField);

        enter = new JButton("Enter");
        enter.addActionListener(new enterListener());
        add(enter);

        answer = new JLabel();
        add(answer);
    }

    public static void main(String[] args){
        JFrame frame = new JFrame("Magic Eight Ball");
        frame.setLocation(100, 50);
        frame.setSize(400, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new PythagoreanTriples());
        frame.setVisible(true);
    }

    private class enterListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int SideA = Integer.parseInt(sideAField.getText());
            int SideB = Integer.parseInt(sideBField.getText());
            int Hyp = Integer.parseInt(hypField.getText());
            if(Math.pow(SideA, 2) + Math.pow(SideB, 2) == Math.pow(Hyp, 2))
                answer.setText("This is a Pythagorean Triple");
            else
                answer.setText("This is not a Pythagorean Triple");
        }
    }


}