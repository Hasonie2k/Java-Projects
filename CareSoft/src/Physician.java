
import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser {
    private ArrayList<String> patientNotes;

    @Override
    public boolean assignPin(int pin) {
        this.setPin(pin);
        return true;
    }

    @Override
    public boolean accessAuthorized(Integer confirmedAuthID) {
        return true;
    }

    public Physician(Integer id) {
        super(id);
        this.patientNotes = new ArrayList<>();
    }

    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format("Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.getId());
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }

    public ArrayList<String> getPatientNotes() {
        return patientNotes;
    }

    public void setPatientNotes(ArrayList<String> patientNotes) {
        this.patientNotes = patientNotes;
    }
}
