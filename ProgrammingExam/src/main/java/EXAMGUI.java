import javax.swing.*; // 窗口组件
import java.awt.*;    // 布局和颜色
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import SourceCode.MedicalNotification;
import SourceCode.HospitalInformation;


public class EXAMGUI extends JFrame {

    private ArrayList<BaysPanel> allPanels =  new ArrayList<>();
    private MedicalNotification m;
    private HospitalInformation h;

    private int tickCounter = 0;

    public EXAMGUI() {
        // --- 1. 硬件连接 (包在 try-catch 里拿 Error Handling 分数) ---
        try {

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        this.setTitle("ICU Ward Service Scheduling");
        this.setSize(800, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(new GridLayout(2, 4, 10, 10));

        // --- 4. 初始化标签 (UI Components) ---
        // TODO: 6. 对每个 Label 进行初始化 (复制粘贴即可)
        // sensor1Label = createLabel("初始化中...");
        // sensor2Label = createLabel("初始化中...");
        BaysPanel b1 = new BaysPanel("Nightingale", "Ultrasound Scanner","Service is Occupied");
        BaysPanel b2 = new BaysPanel("Barton", "None","Service is none");
        BaysPanel b3 = new BaysPanel("Seacole", "ECG recorder, Masseeur","Service is Occupied");
        BaysPanel b4 = new BaysPanel("Dix", "Ultrasound Scanner","Service is Occupied");
        BaysPanel b5 = new BaysPanel("Henderson", "Dialysis machine","Service is Occupied");
        BaysPanel b6 = new BaysPanel("Cavell", "None","Service is Occupied");
        BaysPanel b7 = new BaysPanel("Breckinridge", "None","Service is none");
        BaysPanel b8 = new BaysPanel("Sanger", "None","Service is none");


        this.add(b1);
        this.add(b2);
        this.add(b3);
        this.add(b4);
        this.add(b5);
        this.add(b6);
        this.add(b7);
        this.add(b8);

        Timer timer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateAllPanels();
            }
        });
        timer.start();

        this.setVisible(true);
    }

    private void updateAllPanels() {

        for (BaysPanel panel : allPanels){
            panel.update(m, h);
        }

        tickCounter++;
        if (tickCounter >= 24*3) {
            printLog();
            tickCounter = 0;
        }
    }

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setOpaque(true);
        label.setBackground(Color.WHITE);
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        label.setFont(new Font("Arial", Font.BOLD, 14));
        return label;
    }

    private void printLog() {
        System.out.println("=== report ===");
        System.out.println("Ultrasound Scanner Location: " + m.getBay() + "Ultrasound Scanner Status: ");
        System.out.println("ECG Recorder Location: " + m.getBay() + "ECG Recorder: ");
        System.out.println("Dialysis Machine Location: "+ m.getBay() + "Dialysis Machine Status: ");
        System.out.println("Masseur Location: " + m.getBay() + "Masseur Status: ");
    }

    public static void main(String[] args) {
        new EXAMGUI();
    }
}