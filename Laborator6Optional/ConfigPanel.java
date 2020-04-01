import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfigPanel extends JPanel implements ActionListener {

    final MainFrame frame;

    JSpinner sidesField = new JSpinner(new SpinnerNumberModel(3, 3, 100, 1));
    JSpinner sizeField = new JSpinner(new SpinnerNumberModel(0, 0, 200, 5));
    JSpinner radiusField = new JSpinner(new SpinnerNumberModel(0, 0, 200, 5));
    JSpinner lengthField = new JSpinner(new SpinnerNumberModel(100, 5, 200, 5));
    JSpinner widthField = new JSpinner(new SpinnerNumberModel(100, 5, 200, 5));

    JComboBox shapeCombo;
    JLabel shapeLabel;
    JRadioButton Polygon;
    JRadioButton Circle;
    JRadioButton Rectangular;
    ButtonGroup buttonGroup = new ButtonGroup();
    String[] culori = {"Red", "Black", "Yellow", "Green", "Pink", "Random"};
    JComboBox colorCombo = new JComboBox(culori);
    JLabel sidesLabel = new JLabel("Number of sides:");
    JLabel sizeLabel = new JLabel("Size:");
    JLabel radiusLabel= new JLabel("Radius:");
    JLabel lengthLabel= new JLabel("Length:");
    JLabel widthLabel= new JLabel("Width:");




    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        Circle = new JRadioButton("Circle");
        Polygon = new JRadioButton("Polygon" );
        Rectangular = new JRadioButton("Rectangular");

        buttonGroup.add(Polygon);
        buttonGroup.add(Circle);
        buttonGroup.add(Rectangular);

        add(Polygon);
        add(Circle);
        add(Rectangular);

        Polygon.addActionListener(this::PolygonListener);
        Rectangular.addActionListener(this::RectangularListener);
        Circle.addActionListener(this::CircleListener);

        sizeField.setValue(0);
        sidesField.setValue(3);
        colorCombo.setSelectedIndex(5);
        colorCombo.addActionListener(this::actionPerformed);


    }

    private void CircleListener(ActionEvent actionEvent) {
        frame.configPanel.removeAll();
        add(Polygon);
        add(Circle);
        add(Rectangular);
        add(radiusLabel);
        add(radiusField);
        add(colorCombo);
        this.updateUI();

    }

    private void RectangularListener(ActionEvent actionEvent) {
        frame.configPanel.removeAll();
        add(Polygon);
        add(Circle);
        add(Rectangular);
        add(lengthLabel);
        add(lengthField);
        add(widthLabel);
        add(widthField);
        add(colorCombo);
        this.updateUI();
    }

    private void PolygonListener(ActionEvent actionEvent) {
        frame.configPanel.removeAll();
        add(Polygon);
        add(Circle);
        add(Rectangular);
        add(sizeLabel);
        add(sizeField);
        add(sidesLabel);
        add(sidesField);
        add(colorCombo);
        this.updateUI();
    }


    public void actionPerformed(ActionEvent e) {
        colorCombo.getSelectedIndex();
    }

}
