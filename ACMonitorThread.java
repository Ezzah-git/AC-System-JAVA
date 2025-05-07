import java.io.FileWriter; //to write data into a file
import java.io.IOException; //to handle exception.
class ACMonitorThread extends Thread{
    private AirConditioner ac;

    public ACMonitorThread(AirConditioner ac) {
        this.ac = ac;
    }
    @Override
    public void run() {
        synchronized (ac) {
            try (FileWriter writer = new FileWriter("ac_log.txt", true)) {
                writer.write("Monitoring Log:\n");
                writer.write("AC is " + (ac.isPowerOn() ? "ON" : "OFF") + "\n");
                writer.write("Temperature: " + ac.getTemperature() + "°C\n");
                writer.write("Fan Speed: " + ac.getFanSpeed() + "\n");
                writer.write("----------------------\n");
                System.out.println("Log saved to ac_log.txt");
            } catch (IOException e) {
                System.out.println("Error logging to file.");
            }
        }
    }
}
