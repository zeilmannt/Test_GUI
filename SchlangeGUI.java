
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SchlangeGUI extends Schlange{
    private SchlangeGUI(){
        Schlange s = new Schlange();
        initGUI();
    }


    public void initGUI(){

        // UI
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        frame.setTitle("Struktur - Schlange");
        frame.setSize(400, 250);
        frame.setResizable(false);
        frame.setLocation(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        panel.setLayout(null);

        JLabel inputLabel = new JLabel("Neues Element:");
        inputLabel.setBounds(10, 20, 100, 25);

        JLabel outputLabel = new JLabel("Schlange: (Länge: " + gibLaenge() + ")");
        outputLabel.setBounds(10, 80, 150, 25);

        JLabel outputContent = new JLabel("-------------------");
        outputContent.setBounds(10, 110, 200, 25);

        JTextField elemText = new JTextField();
        elemText.setBounds(110, 20, 165,25);

        JButton inputBtn = new JButton();
        inputBtn.setBounds(280, 20, 100,25);
        inputBtn.setText("Einfügen");
        inputBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                einfuegen(Integer.parseInt(elemText.getText()));
                JOptionPane.showMessageDialog(null, "Element mit Wert " + elemText.getText() + " wurde hinzugefügt!", "Schlange - Meldung", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Element mit Wert " + elemText.getText() + " wurde hinzugefügt!");
                elemText.setText("");
                outputLabel.setText("Schlange: (Länge: " + gibLaenge() + ")");
            }
        });

        JButton displayBtn = new JButton();
        displayBtn.setBounds(10, 190, 100, 25);
        displayBtn.setText("Ausgeben");
        displayBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outputContent.setText(ausgeben());
                System.out.println("Schlange wurde ausgeben");
            }
        });

        JButton deleteBtn = new JButton();
        deleteBtn.setBounds(110, 190, 100, 25);
        deleteBtn.setText("Entfernen");
        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int wert = entfernen();
                if(wert == 0){
                    JOptionPane.showMessageDialog(null, "Schlange ist leer!", "Schlange - Meldung", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    outputContent.setText("-------------------");
                    JOptionPane.showMessageDialog(null, "Element mit Wert " + wert + " wurde entfernt!", "Schlange - Meldung", JOptionPane.INFORMATION_MESSAGE);
                    System.out.println("Element mit " + wert + " wurde entfernt!");
                    outputLabel.setText("Schlange: (Länge: " + gibLaenge() + ")");
                }

            }
        });

        panel.add(inputLabel);
        panel.add(outputLabel);
        panel.add(outputContent);
        panel.add(elemText);
        panel.add(inputBtn);
        panel.add(displayBtn);
        panel.add(deleteBtn);

        frame.setVisible(true);
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SchlangeGUI sgui = new SchlangeGUI();
            }
        });


    }
}
