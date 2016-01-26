package coffee;

import dagger.Module;
import dagger.Provides;

/**
 * Created by chenfuduo on 2016/1/26.
 */

//通常情况下， 约定@Provides函数以provide作为前缀， @Module类以Module作为后缀。
@Module(complete = false, library = true)
class PumpModule {

    //所有的@Provides函数必须属于一个Module。这些Module类使用@Module注释。
    //@Provides注释的函数也可以有他们自己的依赖关系。下面这个Provides函数依赖于一个Thermosiphon对象：
    @Provides
    Pump providePump(Thermosiphon pump) {
        return pump;
    }
}
