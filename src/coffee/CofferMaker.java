package coffee;

import dagger.Lazy;

import javax.inject.Inject;

/**
 * Created by chenfuduo on 2016/1/25.
 */
class CofferMaker {
    //Dagger 可以直接注入成员变量。在这个例子中， 它获取Heater对象， 并注入到成员变量heater，同时获取Pump对象并注入到成员变量pump。
    //某些情况下需要延迟初始化一个对象。对任意的对象T来说, 你可以使用Lazy实现延迟初始化。
    // Lazy只有当Lazy's get()函数调用时， 才会初始化T对象。
    // 如果T是个单例的对象， Lazy也将使用同一个对象进行注入操作。
    // 否则，每次注入都将生成自己的 Lazy对象。
    // 当然， 任何随后调用Lazy.get()函数将返回之前构建好的T对象。
    @Inject
    Lazy<Heater> heater;
    @Inject
    Pump pump;

    public void brew() {
        heater.get().on();
        pump.pump();
        System.out.println(" [_]P coffee! [_]P ");
        heater.get().off();
    }
}
