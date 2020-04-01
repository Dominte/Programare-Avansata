import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

public class DrawingPanel extends JPanel {

    final MainFrame frame;
    final static int W = 1200, H = 800;

    public static int getW() {
        return W;
    }

    public static int getH() {
        return H;
    }

    BufferedImage image;
    Graphics2D graphics;

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        init();
    }

    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();

        graphics.setColor(Color.LIGHT_GRAY);
        graphics.fillRect(0, 0, W, H);
    }

    public static int stringCompare(String str1, String str2) // functie de comparare string-uri de pe net
    { // am uitat ca exista String.equals()

        int l1 = str1.length();
        int l2 = str2.length();
        int lmin = Math.min(l1, l2);

        for (int i = 0; i < lmin; i++) {
            int str1_ch = (int) str1.charAt(i);
            int str2_ch = (int) str2.charAt(i);

            if (str1_ch != str2_ch) {
                return str1_ch - str2_ch;
            }
        }

        // Edge case for strings like
        // String 1="Geeks" and String 2="Geeksforgeeks"
        if (l1 != l2) {
            return l1 - l2;
        }

        // If none of the above conditions is true,
        // it implies both the strings are equal
        else {
            return 0;
        }
    }

    private void init() {
        setPreferredSize(new Dimension(W, H)); //don’t use setSize. Why?
        setBorder(BorderFactory.createEtchedBorder()); //for fun
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawShape(e.getX(), e.getY());
                repaint();
            }
        });
    }

    private void drawShape(int x, int y) {
        String string = new String((String) frame.configPanel.colorCombo.getSelectedItem());
        String shape = null;

        if (frame.configPanel.Polygon.isSelected() == true)
            shape = new String("Polygon");
        else if (frame.configPanel.Circle.isSelected() == true)
            shape = new String("Circle");
        else if (frame.configPanel.Rectangular.isSelected() == true)
            shape = new String("Rectangular");
        else
            shape = new String("notSelected");

        if (shape.equals("Polygon")) {
            if (stringCompare(string, "Random") == 0) {
                Random random = new Random();
                float r = random.nextFloat();
                float g = random.nextFloat();
                float b = random.nextFloat();
                int radius = (int) frame.configPanel.sizeField.getValue();
                if (radius == 0)
                    radius = random.nextInt() % 200 + 1;
                int sides = (int) frame.configPanel.sidesField.getValue();
                Color color = new Color(r, g, b);
                graphics.setColor(color);
                graphics.fill(new RegularPolygon(x, y, radius, sides));
            } else if (stringCompare(string, "Red") == 0) {
                Random random = new Random();
                int radius = (int) frame.configPanel.sizeField.getValue();
                if (radius == 0)
                    radius = random.nextInt() % 200 + 1;
                int sides = (int) frame.configPanel.sidesField.getValue();

                graphics.setColor(Color.red);
                graphics.fill(new RegularPolygon(x, y, radius, sides));
            } else if (stringCompare(string, "Yellow") == 0) {
                Random random = new Random();
                int radius = (int) frame.configPanel.sizeField.getValue();
                if (radius == 0)
                    radius = random.nextInt() % 200 + 1;
                int sides = (int) frame.configPanel.sidesField.getValue();

                graphics.setColor(Color.yellow);
                graphics.fill(new RegularPolygon(x, y, radius, sides));
            } else if (string.equals("Black")) {
                Random random = new Random();
                int radius = (int) frame.configPanel.sizeField.getValue();
                if (radius == 0)
                    radius = random.nextInt() % 200 + 1;
                int sides = (int) frame.configPanel.sidesField.getValue();

                graphics.setColor(Color.BLACK);
                graphics.fill(new RegularPolygon(x, y, radius, sides));
            } else if (string.equals("Green")) {
                Random random = new Random();
                int radius = (int) frame.configPanel.sizeField.getValue();
                if (radius == 0)
                    radius = random.nextInt() % 200 + 1;
                int sides = (int) frame.configPanel.sidesField.getValue();

                graphics.setColor(Color.GREEN);
                graphics.fill(new RegularPolygon(x, y, radius, sides));
            } else if (string.equals("Pink")) {
                Random random = new Random();
                int radius = (int) frame.configPanel.sizeField.getValue();
                if (radius == 0)
                    radius = random.nextInt() % 200 + 1;
                int sides = (int) frame.configPanel.sidesField.getValue();

                graphics.setColor(Color.PINK);
                graphics.fill(new RegularPolygon(x, y, radius, sides));
            }
        } else if (shape.equals("Circle")) {
            Circle circle = new Circle();

            if (stringCompare(string, "Random") == 0) {
                Random random = new Random();

                float r = random.nextFloat();
                float g = random.nextFloat();
                float b = random.nextFloat();
                int radius = (int) frame.configPanel.radiusField.getValue();
                if (radius == 0)
                    radius = random.nextInt() % 200 + 1;
                int sides = (int) frame.configPanel.sidesField.getValue();
                Color color = new Color(r, g, b);
                graphics.setColor(color);
                circle.drawCenteredCircle(graphics, x, y, radius);
            } else if (string.equals("Yellow")) {
                Random random = new Random();
                int radius = (int) frame.configPanel.radiusField.getValue();
                if (radius == 0)
                    radius = random.nextInt() % 200 + 1;
                graphics.setColor(Color.yellow);
                circle.drawCenteredCircle(graphics, x, y, radius);

            } else if (string.equals("Black")) {
                Random random = new Random();
                int radius = (int) frame.configPanel.radiusField.getValue();
                if (radius == 0)
                    radius = random.nextInt() % 200 + 1;
                graphics.setColor(Color.BLACK);
                circle.drawCenteredCircle(graphics, x, y, radius);

            } else if (string.equals("Green")) {
                Random random = new Random();
                int radius = (int) frame.configPanel.radiusField.getValue();
                if (radius == 0)
                    radius = random.nextInt() % 200 + 1;
                graphics.setColor(Color.green);
                circle.drawCenteredCircle(graphics, x, y, radius);

            } else if (string.equals("Pink")) {
                Random random = new Random();
                int radius = (int) frame.configPanel.radiusField.getValue();
                if (radius == 0)
                    radius = random.nextInt() % 200 + 1;
                graphics.setColor(Color.PINK);
                circle.drawCenteredCircle(graphics, x, y, radius);

            } else if (string.equals("Red")) {
                Random random = new Random();
                int radius = (int) frame.configPanel.radiusField.getValue();
                if (radius == 0)
                    radius = random.nextInt() % 200 + 1;
                graphics.setColor(Color.RED);
                circle.drawCenteredCircle(graphics, x, y, radius);
            }
        } else if (shape.equals("Rectangular")) {
            int length = (int) frame.configPanel.lengthField.getValue();
            int width = (int) frame.configPanel.widthField.getValue();
            if (stringCompare(string, "Random") == 0) {
                Random random = new Random();
                float r = random.nextFloat();
                float g = random.nextFloat();
                float b = random.nextFloat();
                Color color = new Color(r, g, b);
                graphics.setColor(color);
                graphics.fillRect(x, y, length, width);
            } else if (string.equals("Yellow")) {
                graphics.setColor(Color.yellow);
                graphics.fillRect(x, y, length, width);
            } else if (string.equals("Black")) {
                graphics.setColor(Color.black);
                graphics.fillRect(x, y, length, width);
            } else if (string.equals("Green")) {
                graphics.setColor(Color.green);
                graphics.fillRect(x, y,  length, width);
            } else if (string.equals("Pink")) {
                graphics.setColor(Color.pink);
                graphics.fillRect(x, y,  length, width);
            } else if (string.equals("Red")) {
                graphics.setColor(Color.red);
                graphics.fillRect(x, y, length, width);
            }
        } else
            System.out.println("Neselectat");
    }


    @Override
    public void update(Graphics g) {
        //paint(g);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }


}
