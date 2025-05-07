class Appliance{
    private String brand;
    private boolean powerStatus;

    public Appliance(String brand){
        this.brand = brand;
        this.powerStatus = false;
    }

    public void turnOn(){
        powerStatus = true;
        System.out.println(brand + " appliance is now ON.");
    }

    public void turnOff(){
        powerStatus = false;
        System.out.println(brand + " appliance is now OFF.");
    }

    public boolean isPowerOn(){
        return powerStatus;
    }

    public String getBrand(){
        return brand;
    }
}

