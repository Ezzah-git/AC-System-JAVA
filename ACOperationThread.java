class ACOperationThread extends Thread{
    private AirConditioner ac;

    public ACOperationThread(AirConditioner ac){
        this.ac = ac;
    }
    @Override
    public void run(){
        synchronized (ac){
            ac.turnOn();
            ac.getTemperature();
            ac.getFanSpeed();
        }
    }
}
