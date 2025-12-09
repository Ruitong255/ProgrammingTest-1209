import SourceCode.MedicalNotification;
import SourceCode.HospitalInformation;

import javax.swing.*;
import javax.swing.*;
import java.awt.*;


public class BaysPanel extends JPanel{


    private JLabel label;
    private String bay;
    private String service;
    private String serviceStatus;

    public BaysPanel(String bay, String service, String serviceStatus){

        this.bay = bay;
        this.service = service;

        this.setLayout(new BorderLayout());
        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        label = new JLabel("Loading...", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 14)); // 统一样式
        label.setOpaque(true); // 允许标签也有背景色(如果需要的话)
        label.setBackground(new Color(0,0,0,0)); // 标签背景透明，透出面板背景

        this.add(label, BorderLayout.CENTER);
    }

    public boolean serviceIsOccupied(){
        return false;
    }
    public void update(MedicalNotification m, HospitalInformation h){
        String bay = m.getBay();
        String service = m.getService();
        String serviceStatus = "Service is none";
        Boolean serviceIsOccupied = true;

        if (serviceIsOccupied){
            h.waitAnHour();
            serviceStatus = "Service is Occupied";
        }else{
            h.requestPorter(bay, service);
            serviceIsOccupied = false;
            serviceStatus = "Service is Free";
        }
        String labelText = String.format("<html>Bay Name: %s<br>Service: %s<br>Service Status: %s</html>", bay, service, serviceStatus);
        this. label.setText(labelText);
    }
}
