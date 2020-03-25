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
        System.out.println(string);
        System.out.println((String) frame.configPanel.colorCombo.getSelectedItem());
        if (stringCompare(string, "Random") == 0) {
            Random random = new Random();
            float r = random.nextFloat();
            float g = random.nextFloat();
            float b = random.nextFloat();
            int radius = random.nextInt()%100; //size random , random.nextInt() da numar prea mare asa ca % 100
            int sides = (int) frame.configPanel.sidesField.getValue();
            Color color = new Color(r, g, b);
            graphics.setColor(color);
            graphics.fill(new RegularPolygon(x, y, radius, sides));
        } else if (stringCompare(string, "Red") == 0) {
            Random random = new Random();
            int radius = random.nextInt() % 100;
            int sides = (int) frame.configPanel.sidesField.getValue();

            graphics.setColor(Color.red);
            graphics.fill(new RegularPolygon(x, y, radius, sides));
        } else if (stringCompare(string, "Yellow") == 0) {
            Random random = new Random();
            int radius = random.nextInt() % 100;
            int sides = (int) frame.configPanel.sidesField.getValue();

            graphics.setColor(Color.yellow);
            graphics.fill(new RegularPolygon(x, y, radius, sides));
        } else if (string.equals("Black")) {
            Random random = new Random();
            int radius = random.nextInt() % 100;
            int sides = (int) frame.configPanel.sidesField.getValue();

            graphics.setColor(Color.BLACK);
            graphics.fill(new RegularPolygon(x, y, radius, sides));
        } else if (string.equals("Green")) {
            Random random = new Random();
            int radius = random.nextInt() % 100;
            int sides = (int) frame.configPanel.sidesField.getValue();

            graphics.setColor(Color.GREEN);
            graphics.fill(new RegularPolygon(x, y, radius, sides));
        } else if (string.equals("Pink")) {
            Random random = new Random();
            int radius = random.nextInt() % 100;
            int sides = (int) frame.configPanel.sidesField.getValue();

            graphics.setColor(Color.PINK);
            graphics.fill(new RegularPolygon(x, y, radius, sides));
        }

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
