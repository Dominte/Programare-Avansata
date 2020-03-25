import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfigPanel extends JPanel implements ActionListener {

    final MainFrame frame;

    JSpinner sidesField;
    JComboBox colorCombo;
    JSpinner sizeField;


    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        JLabel sidesLabel = new JLabel("Number of sides:");
        JLabel sizeLabel = new JLabel("Size:");
        sizeField= new JSpinner(new SpinnerNumberModel(0, 0, 200, 5));
        sidesField = new JSpinner(new SpinnerNumberModel(3, 3, 100, 1));
        sizeField.setValue(0);
        sidesField.setValue(3);
        String[] culori = {"Red", "Black", "Yellow", "Green", "Pink", "Random"};
        colorCombo = new JComboBox(culori);
        colorCombo.setSelectedIndex(5);
        colorCombo.addActionListener(this::actionPerformed);

        add(sizeLabel);
        add(sizeField);
        add(sidesLabel);
        add(sidesField);
        add(colorCombo);
    }

    public void actionPerformed(ActionEvent e) {
        colorCombo.getSelectedIndex();
    }

}
