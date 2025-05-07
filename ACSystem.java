import java.util.Scanner;
public class ACSystem{
    public static void main(String[] args){
        RemoteControl remote = new RemoteControl();
        AirConditioner ac = new AirConditioner("Dawlance", remote);

        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("\n--- Air Conditioner Console ---");
            System.out.println("1. Turn ON");
            System.out.println("2. Turn OFF");
            System.out.println("3. Set Temperature");
            System.out.println("4. Set Fan Speed");
            System.out.println("5. Show Status");
            System.out.println("6. Run Threads (Operate & Monitor)");
            System.out.println("7. Exit"); // Added new option
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice){
                case 1 -> ac.turnOn();
                case 2 -> ac.turnOff();
                case 3 ->{
                    System.out.print("Enter temperature: ");
                    int temp = sc.nextInt();
                    ac.setTemperature(temp);
                }
                case 4 ->{
                    System.out.print("Enter fan speed (LOW / MEDIUM / HIGH): ");
                    sc.nextLine();
                    String speed = sc.nextLine();
                    ac.setFanSpeed(speed);
                }
                case 5 -> ac.showStatus();
                case 6 ->{
                    Thread opThread = new ACOperationThread(ac);
                    Thread monThread = new ACMonitorThread(ac);
                    opThread.start();
                    monThread.start();
                    try {
                        opThread.join(); // Wait for operation thread to finish
                        monThread.join(); // Wait for monitor thread to finish
                    } catch (InterruptedException e) {
                        System.out.println("Thread interrupted: " + e.getMessage());
                    }
                }
                case 7-> exit = true;
                default -> System.out.println("Invalid choice.");
            }
        }
        System.out.println("Exiting AC application.");
    }
}

