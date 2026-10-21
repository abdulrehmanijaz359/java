import java.util.*;

public class TicketCounterTrace {
    private final static int PROCESS = 120;
    private final static int CASHIERS = 4;
    private final static int NUM_CUSTOMERS = 22;

    public static void main(String[] args) {
        Queue<Customer> customerQueue = new LinkedList<Customer>();
        int[] cashierTime = new int[CASHIERS]; // all start at 0 (free)

        for (int count = 1; count <= NUM_CUSTOMERS; count++)
            customerQueue.add(new Customer(count * 15));

        // header row
        System.out.print("Customer;Arrival");
        for (int c = 1; c <= CASHIERS; c++)
            System.out.print(";Cashier " + c + " free");
        System.out.println(";Wait time;Total time");

        int number = 0;
        int totalTime = 0;

        while (!customerQueue.isEmpty()) {
            for (int c = 0; c < CASHIERS; c++) {
                if (!customerQueue.isEmpty()) {
                    Customer customer = customerQueue.remove();
                    number++;

                    // cashier state at the moment of arrival
                    StringBuilder line = new StringBuilder();
                    line.append(number).append(";").append(customer.getArrivalTime());
                    for (int k = 0; k < CASHIERS; k++)
                        line.append(";").append(cashierTime[k]);

                    int start = Math.max(customer.getArrivalTime(), cashierTime[c]);
                    int wait = start - customer.getArrivalTime();
                    int departs = start + PROCESS;
                    customer.setDepartureTime(departs);
                    cashierTime[c] = departs;
                    totalTime += customer.totalTime();

                    line.append(";").append(wait).append(";").append(customer.totalTime());
                    System.out.println(line);
                }
            }
        }
        System.out.println("\nAverage time in system: " + (totalTime / NUM_CUSTOMERS));
    }
}