package coffee;


import javax.inject.Inject;

/**
 * Created by chenfuduo on 2016/1/25.
 */
class Thermosiphon implements Pump {
    private final Heater heater;

    // Dagger使用 javax.inject.Inject annotation 标记哪些构造函数和成员变量需要依赖注入
    // Dagger将使用 @Inject 注释的构造函数 创建类对象。 当请求构建新的类对象时， Dagger 将自动获取相应的参数， 并调用构造函数。
    @Inject
    Thermosiphon(Heater heater) {
        this.heater = heater;
    }

    @Override
    public void pump() {
        if (heater.isHot()) {
            System.out.println("=>=> pumping =>=>");
        }
    }
}
