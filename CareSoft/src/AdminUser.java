
import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin {
    private String role;
    private ArrayList<String> securityIncidents;

    @Override
    public boolean assignPin(int pin) {
        this.setPin(pin);
        return true;
    }


    @Override
    public boolean accessAuthorized(Integer confirmedAuthID) {
        return true;
    }



    @Override
    public ArrayList<String> reportSecurityIncidents() {
        return securityIncidents;
    }

    public AdminUser(Integer id, String role) {
        super(id);
        this.role = role;
        this.securityIncidents = new ArrayList<>();
    }

    public void newIncident(String notes) {
        String report = String.format("Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", new Date(),
                this.getId(), notes);
        securityIncidents.add(report);
    }

    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), getId(), "Unauthorized access attempt"
        );
        securityIncidents.add(report);
    }



    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public ArrayList<String> getSecurityIncidents() {
        return securityIncidents;
    }

    public void setSecurityIncidents(ArrayList<String> securityIncidents) {
        this.securityIncidents = securityIncidents;
    }
}

