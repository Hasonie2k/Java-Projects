
import java.util.ArrayList;

public interface HIPAACompliantAdmin {
    abstract ArrayList<String> reportSecurityIncidents();

    public default void printSecurityIncidents() {
        System.out.println(reportSecurityIncidents());
    }

    public default boolean adminQATest(ArrayList<String> expectedIncidents) {
        if (reportSecurityIncidents().equals(expectedIncidents)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        return reportSecurityIncidents().equals(expectedIncidents);
    }
}
