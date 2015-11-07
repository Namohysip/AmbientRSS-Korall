import java.awt.*;
import java.util.ArrayList;
import java.util.List;


import javax.swing.*;

public class Interface {

  /**
   * DrawingBoard Class for adding and displaying circles.
   *
   */
  class DrawingBoard extends JPanel {

    /*
     * The height and width of the window, currently set at 300, 300. May be
     * resized in the future.
     */
    private static final int WIDTH = 300;
    private static final int HEIGHT = 300;
    private int radius = 30;

    // Holds the circles to redraw
    private List<MyCircle> circles;


    /**
     * Adds Circles to the List for drawing Needs a way to resize radius and
     * change color, getters & setters?
     */
    public void addCircles() {

      circles.add(new MyCircle(135, 145, radius, Color.GREEN));
      circles.add(new MyCircle(15, 30, radius , Color.BLUE));
      circles.add(new MyCircle(250, 30, radius, Color.MAGENTA));
      circles.add(new MyCircle(15, 250, radius, Color.RED));
      circles.add(new MyCircle(250, 250, radius, Color.ORANGE));
      DrawingBoard.this.repaint();
    }


    /*
     * DrawingBoard constructor, creates the list and calls addCircles when
     * created.
     */
    public DrawingBoard() {
      super();
      circles = new ArrayList<MyCircle>();
      addCircles();
      setOpaque(true);
    }


    /**
     * Sets the height and width of the window. Tentatively set at 300, 300
     */
    public Dimension getPreferredSize() {
      return new Dimension(WIDTH, HEIGHT);
    }


    /**
     * Iterates through the list of circles to be drawn and calls drawCircle.
     */
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      for (MyCircle circle : circles) {
        circle.drawCircle(g);
      }
    }
  }

  class MyCircle {

    private int x;
    private int y;
    private Color backgroundColour;
    private int radius;


    public MyCircle(int x, int y, int radius, Color backgroundColour) {
      this.x = x;
      this.y = y;
      this.radius = radius;
      this.backgroundColour = backgroundColour;
    }


    /**
     * drawCircle, draws a circle with the given x, y position, radius, and
     * color.
     * 
     */
    public void drawCircle(Graphics g) {
      g.setColor(backgroundColour);
      g.fillOval(x, y, radius, radius);
    }

  }

  private static final int GAP = 5;

  private JPanel drawingBoard;


  private void displayGUI() {
    JFrame frame = new JFrame("AmbientRSS - Korall");
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    JPanel contentPane = new JPanel();

    drawingBoard = new DrawingBoard();
    contentPane.add(drawingBoard);

    frame.setContentPane(contentPane);
    frame.pack();
    frame.setVisible(true);
  }


  public static void main(String[] args) {
    Runnable runnable = new Runnable() {
      @Override
      public void run() {
        new Interface().displayGUI();
      }
    };
    EventQueue.invokeLater(runnable);
  }
}
