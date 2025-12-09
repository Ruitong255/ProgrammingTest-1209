package Services;
import SourceCode.MedicalNotification;
import SourceCode.HospitalInformation;

import javax.swing.*;

public class ServicePanel extends JPanel {
    private String service;
    private int timeTaken;

    public ServicePanel(String service, int timeTaken){
        this.service = service;
        this.timeTaken = timeTaken;

    }

}
