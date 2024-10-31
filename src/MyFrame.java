import java.awt.*;

import javax.swing.*;

public class MyFrame extends JFrame {
  MyFrame() {
    panel = new MyPanel();
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(500, 500);
    this.add(panel);
    this.pack();
    this.setLocationRelativeTo(null);
    this.setVisible(true);
  }

  MyPanel panel;
}
