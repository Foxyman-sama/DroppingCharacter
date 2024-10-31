
import javax.swing.*;

public class MyThread extends Thread {
  MyThread(MyPanel panel) {
    this.panel = panel;
  }

  public void run() {
    while (true) {
      try {
        Thread.sleep(RandomGenerator.generate_integer(min_wait_time_in_milliseconds, max_wait_time_in_milliseconds));
        panel.update_y_pos();
        panel.repaint();
      } catch (final InterruptedException e) {
        e.printStackTrace();
        return;
      }
    }
  }

  final int min_wait_time_in_milliseconds = 0;
  final int max_wait_time_in_milliseconds = 1_000;

  MyPanel panel;
}
