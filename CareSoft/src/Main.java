
public class Main {
    public static void main(String[] args) {
        // Physician Implementation Tests
        System.out.println("========== Physician Tests ==========");
        Physician doctor10 = new Physician(10);
        String pinTest1 = doctor10.assignPin(42) ? "PASS" : "FAIL";
        System.out.printf("Physician pin assign test 1: %s\n", pinTest1);

        String pinTest2 = doctor10.assignPin(4000) ? "PASS" : "FAIL";
        System.out.printf("Physician pin assign test 2: %s\n", pinTest2);

        String authTest1 = doctor10.accessAuthorized(1234) ? "PASS" : "FAIL";
        System.out.printf("Physician auth test 1: %s\n", authTest1);

        String authTest2 = doctor10.accessAuthorized(1) ? "PASS" : "FAIL";
        System.out.printf("Physician auth test 2: %s\n", authTest2);

        // AdminUser Implementation Tests
        System.out.println("\n========== AdminUser Tests ==========");
        AdminUser roseTyler = new AdminUser(123, "Admin");
        String pinTest3 = roseTyler.assignPin(42) ? "PASS" : "FAIL";
        System.out.printf("Admin pin assign test 1: %s\n", pinTest3);

        String pinTest4 = roseTyler.assignPin(424242) ? "PASS" : "FAIL";
        System.out.printf("Admin pin assign test 2: %s\n", pinTest4);

        String authTest3 = roseTyler.accessAuthorized(1234) ? "PASS" : "FAIL";
        System.out.printf("Admin auth test 1: %s\n", authTest3);

        String authTest4 = roseTyler.accessAuthorized(1234) ? "PASS" : "FAIL";
        System.out.printf("Admin auth test 2: %s\n", authTest4);

        String authTest5 = roseTyler.accessAuthorized(2) ? "PASS" : "FAIL";
        System.out.printf("Admin auth test 3: %s\n\n", authTest5);

        roseTyler.newIncident("Unauthorized access attempt");
        roseTyler.newIncident("Data breach incident");

        System.out.println(roseTyler.reportSecurityIncidents());
    }
}
