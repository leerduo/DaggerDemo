package coffee;

import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

/**
 * Created by chenfuduo on 2016/1/26.
 */


//通常情况下， 约定@Provides函数以provide作为前缀， @Module类以Module作为后缀。
//这个对象图表并不知道CoffeeApp这个可注入类。我们需要在@Module注释中显式的声明
@Module(injects = CoffeeApp.class, includes = PumpModule.class)
class DripCoffeeModule {

    //所有的@Provides函数必须属于一个Module。这些Module类使用@Module注释。

    //对那些使用@Inject效率极低或者awkward的情况， 可以使用@Provides注释函数来实现依赖关系。这些函数的返回类型定义其实现的依赖关系。

    //例如， 当需要一个Heater时， Dagger将调用provideHeater()函数获取。

    //给@Provides注释的函数或者可注入的类， 添加注释@Singlton， 构建的这个对象图表将使用唯一的对象实例
    @Provides
    @Singleton
    Heater providerHeater() {
        return new ElectricHeater();
    }
}
