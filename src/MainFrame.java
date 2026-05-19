import javax.swing.JFrame;

public class MainFrame extends JFrame implements Runnable {

    private DrawPanel p;
    private Thread windowThread;

    public MainFrame(String display) {
        super(display);

        p = new DrawPanel();
        this.add(p);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 800);
        this.setLocation(100, 10);
        this.setVisible(true);

        startThread();
    }

    public void startThread() {
        windowThread = new Thread(this);
        windowThread.start();
    }

    public void run() {
        while (true) {

            p.update();
            p.repaint();

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}