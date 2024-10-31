import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class MyPanel extends JPanel {
  MyPanel() {
    set_up_panel();
    make_letter();
    create_threads();
    start_threads();
  }

  void set_up_panel() {
    this.setPreferredSize(new Dimension(panel_width, panel_height));
  }

  void make_letter() {
    letter = new String();
    letter += RandomGenerator.generate_character();
  }

  void create_threads() {
    threads = new ArrayList<MyThread>();
    for (var i = 0; i < 12; ++i) {
      threads.add(new MyThread(this));
    }
  }

  void start_threads() {
    for (MyThread thread : threads) {
      thread.start();
    }
  }

  public void paint(Graphics g) {
    super.paint(g);

    Graphics2D g2d = (Graphics2D) g;
    draw_character(g2d);
  }

  void draw_character(Graphics2D g2d) {
    var x_pos = RandomGenerator.generate_integer(x_min_possible_position, x_max_possible_position);
    g2d.drawString(letter, x_pos, y);
  }

  public synchronized void update_y_pos() {
    y += y_velocity;
    if (y > panel_height) {
      y = 1;
    }
  }

  final int panel_width = 500;
  final int panel_height = 500;

  final int y_velocity = 2;
  final int x_min_possible_position = 10;
  final int x_max_possible_position = panel_width - 10;

  ArrayList<MyThread> threads;
  String letter;
  int y = 1;
}
