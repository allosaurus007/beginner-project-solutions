import java.lang.Math;
import java.awt.event.*;
import java.awt.*;
import javax.swing.JPanel;
import javax.swing.*;

public class CoinEstimator extends JPanel{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JLabel pennylbl;
    private JTextField pennyAmt;
    private JLabel nickellbl;
    private JTextField nickelAmt;
    private JLabel dimelbl;
    private JTextField dimeAmt;
    private JLabel quarterlbl;
    private JTextField quarterAmt;
    private JButton enter;

    private JLabel pennyNum;
    private JLabel nickelNum;
    private JLabel dimeNum;
    private JLabel quarterNum;

    private JLabel pennyWrap;
    private JLabel nickelWrap;
    private JLabel dimeWrap;
    private JLabel quarterWrap;

    public double penny;
    public double nickel;
    public double dime;
    public double quarter;

    public int pennyWrapAmt;
    public int nickelWrapAmt;
    public int dimeWrapAmt;
    public int quarterWrapAmt;

    public CoinEstimator(){
        new JPanel(new FlowLayout());

        pennylbl = new JLabel("Penny Amt:");
        add(pennylbl);

        pennyAmt = new JTextField("         ");
        add(pennyAmt);

        nickellbl = new JLabel("Nickel Amt:");
        add(nickellbl);

        nickelAmt = new JTextField("         ");
        add(nickelAmt);

        dimelbl = new JLabel("Dime Amt:");
        add(dimelbl);

        dimeAmt = new JTextField("         ");
        add(dimeAmt);

        quarterlbl = new JLabel("Quarter Amt:");
        add(quarterlbl);

        quarterAmt = new JTextField("         ");
        add(quarterAmt);

        enter = new JButton("Enter");
        enter.addActionListener(new enterListener());
        add(enter);

        pennyNum = new JLabel();
        add(pennyNum);

        nickelNum = new JLabel();
        add(nickelNum);

        dimeNum = new JLabel();
        add(dimeNum);

        quarterNum = new JLabel();
        add(quarterNum);

        pennyWrap = new JLabel();
        add(pennyWrap);

        nickelWrap = new JLabel();
        add(nickelWrap);

        dimeWrap = new JLabel();
        add(dimeWrap);

        quarterWrap = new JLabel();
        add(quarterWrap);
    }

    public static void main(String[] args){
        JFrame frame = new JFrame("Coin Estimator");
        frame.setLocation(100, 50);
        frame.setSize(650, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new CoinEstimator());
        frame.setVisible(true);
    }

    private class enterListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            penny = Double.parseDouble(pennyAmt.getText());
            nickel = Double.parseDouble(nickelAmt.getText());
            dime = Double.parseDouble(dimeAmt.getText());
            quarter = Double.parseDouble(quarterAmt.getText());

            penny = penny / 3.11;
            nickel = nickel / 5.0000;
            dime = dime / 2.268;
            quarter = quarter / 5.670;

            pennyNum.setText("Number of Pennies: " + (int) Math.floor(penny));
            nickelNum.setText("Number of Nickels: " + (int) Math.floor(nickel));
            dimeNum.setText("Number of Dimes: " + (int) Math.floor(dime));
            quarterNum.setText("Number of Quarters: " + (int) Math.floor(quarter));

            pennyWrapAmt = (int) (Math.ceil(penny) / 50);
            nickelWrapAmt = (int) (Math.ceil(nickel) / 40);
            dimeWrapAmt = (int) (Math.ceil(dime) / 50);
            quarterWrapAmt = (int) (Math.ceil(quarter) / 40);

            pennyWrap.setText("Penny Wrappers: " + pennyWrapAmt);
            nickelWrap.setText("Nickel Wrappers: " + nickelWrapAmt);
            dimeWrap.setText("Dime Wrappers: " + dimeWrapAmt);
            quarterWrap.setText("Quarter Wrappers: " + quarterWrapAmt);
        }
    }
    
    
}