import java.util.ArrayList;
import java.util.Arrays;

public class TestCafe {
    public static void main(String[] args) {
        CafeUtil cafeUtil = new CafeUtil();

        System.out.println("\n-Streak Goal Test-");
        System.out.printf("Purchases needed by week 10: %s \n\n", cafeUtil.getStreakGoal());

        System.out.println("- Order Total Test-");
        double[] lineItems = {3.5, 1.5, 4.0, 4.5};
        System.out.printf("Order total: $%.2f \n\n", cafeUtil.getOrderTotal(lineItems));

        System.out.println("-Display Menu Test-");
        ArrayList<String> menu = new ArrayList<String>(Arrays.asList("drip coffee", "cappuccino", "latte", "mocha"));
        cafeUtil.displayMenu(menu);

        System.out.println("\n-Add Customer Test-");
        ArrayList<String> customers = new ArrayList<String>();
        for (int i = 0; i < 4; i++) {
            cafeUtil.addCustomer(customers);
            System.out.println("\n");
        }
    }
}

