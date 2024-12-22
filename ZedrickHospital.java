
package zedrickhospital;

import java.util.*;

class PatientDetails {
    String name;
    int severity;

    public PatientDetails(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    @Override
    public String toString() {
        return "Patient{name='" + name + "', severity=" + severity + "}";
    }
}

class PriorityQueueHandler {
    private PriorityQueue<PatientDetails> queue;

    public PriorityQueueHandler() {
        queue = new PriorityQueue<>(Comparator.comparingInt(p -> p.severity));
    }

    public void addPatient(String name, int severity) {
        PatientDetails patient = new PatientDetails(name, severity);
        queue.add(patient);
        System.out.println("Patient added: " + patient);
    }

    public PatientDetails getHighestPriorityPatient() {
        if (queue.isEmpty()) {
            System.out.println("No patients in the queue.");
            return null;
        }
        return queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}

public class ZedrickHospital {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PriorityQueueHandler hospitalQueue = new PriorityQueueHandler();

        while (true) {
            System.out.println("\nLord Zedrick Hospital - Patient Priority Queue Operations:");
            System.out.println("1. Add a patient");
            System.out.println("2. Retrieve highest priority patient");
            System.out.println("3. Exit");

            System.out.print("Choose an operation (1-3): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter patient's name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter severity (1: Critical, 2: Serious, 3: Minor): ");
                    int severity = scanner.nextInt();
                    hospitalQueue.addPatient(name, severity);
                    break;

                case 2:
                    PatientDetails patient = hospitalQueue.getHighestPriorityPatient();
                    if (patient != null) {
                        System.out.println("Patient with highest priority: " + patient);
                    }
                    break;

                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
