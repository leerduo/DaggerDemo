package coffee;

/**
 * Created by chenfuduo on 2016/1/26.
 */
class ElectricHeater implements Heater {
    boolean isHeating;
    @Override
    public void on() {
        System.out.println("~~~Heating~~~");
        this.isHeating = true;
    }

    @Override
    public void off() {
        this.isHeating = false;
    }

    @Override
    public boolean isHot() {
        return isHeating;
    }
}
