package UI;

import com.formdev.flatlaf.FlatDarculaLaf;
import lab02.operations.Score;
import lab02.operations.Solution;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static UI.Reader.*;
import static java.lang.Integer.parseInt;
import static lab02.operations.ListInitialization.getSkiList;
import static lab02.operations.Score.getListOfMatches;
import static lab02.operations.Solution.findMinimum;

public class MainFrame extends JFrame implements ActionListener
{
    private JPanel panel1;
    private JButton button1;
    private JTextArea textArea1;
    private JLabel insertValueLabel;
    private JLabel skiesNum;
    private JTextArea textArea2;
    private JButton stopButton;
    private JTextArea textArea3;
    private JTextArea preferences;
    private JTextArea wykaz;
    private JTextArea znizki;

    public MainFrame() {
        setContentPane(panel1);
        setVisible(true);
        pack();
        button1.addActionListener(this);
        stopButton.addActionListener(this);

    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatDarculaLaf());
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }
        new MainFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(button1)){

        insertValueLabel.setText("People num " + textArea1.getText());
        setPplNum(parseInt(textArea1.getText()));

        skiesNum.setText("Ski num " + textArea2.getText());
        setSkiNum(parseInt(textArea2.getText()));

        setPreferencje(preferences.getText());
        setWykaz(wykaz.getText());
        setZnizki(znizki.getText());

        entry.Main.start();

        textArea3.setText(getText3());

        pack();
        }
        if(e.getSource().equals(stopButton)){
            System.exit(0);
        }
    }
        private String getText3() {
            int id = findMinimum();
            String text = "Best match = \n";

            for (int i = 0; i < Solution.getRange(); i++) {
                text += " id = " + getListOfMatches().get(id).get(i).getId() + " Preferences = ["
                        + getListOfMatches().get(id).get(i).getPreferredType() + ", "
                        + getListOfMatches().get(id).get(i).getPreferredLength() + "] matched Skies ["
                        + getListOfMatches().get(id).get(i).getSkiLength() + ", "
                        + getListOfMatches().get(id).get(i).getSkiType() + "]\n";
            }
            if(Solution.getRange() == getSkiList().size()) text += "Couldnt find a match for the rest of people, that is " + Score.getNotServed() + " clients";

            return text;
        }
}
//modul
//do jara
