class AirConditioner extends Appliance{
    private int temperature;
    private String fanSpeed = "MEDIUM";
    private Compressor compressor;
    private RemoteControl remote;

    public AirConditioner(String brand, RemoteControl remote){
        super(brand);
        this.temperature = 24;
        this.compressor = new Compressor();
        this.remote = remote;
    }

    public void setTemperature(int temp){
        this.temperature = temp;
        System.out.println("Temperature set to " + temp + "°C.");
    }

    public int getTemperature(){
        return temperature;
    }
    public void setFanSpeed(String speed){
        if (speed.equalsIgnoreCase("LOW") || speed.equalsIgnoreCase("MEDIUM") || speed.equalsIgnoreCase("HIGH")) {
            this.fanSpeed = speed.toUpperCase();
            System.out.println("Fan speed set to " + this.fanSpeed);
        } else {
            System.out.println("Invalid fan speed. Choose LOW, MEDIUM, or HIGH.");
        }
    }

    public String getFanSpeed(){
        return fanSpeed;
    }

    @Override
    public void turnOn(){
        super.turnOn();
        remote.sendSignal("Power ON");
        compressor.start();
    }

    @Override
    public void turnOff() {
        super.turnOff();
        remote.sendSignal("Power OFF");
        compressor.stop();
    }
    public void showStatus(){
        System.out.println("AC Brand: "+getBrand());
        System.out.println("Power: "+(isPowerOn() ? "ON" : "OFF"));
        System.out.println("Temperature: "+temperature + "°C");
        System.out.println("Fan Speed: "+fanSpeed);
    }
}
