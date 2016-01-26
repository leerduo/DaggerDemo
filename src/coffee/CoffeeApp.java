package coffee;

import dagger.ObjectGraph;

import javax.inject.Inject;

/**
 * Created by chenfuduo on 2016/1/26.
 */
public class CoffeeApp implements Runnable {
    @Inject
    CofferMaker cofferMaker;

    @Override
    public void run() {
        cofferMaker.brew();
    }

    public static void main(String[] args) {
        //@Inject 和 @Provides 注释的类构建了一个对象图表。这些对象与对象之间通过依赖关系相互关联。
        //通过函数ObjectGraph.create()获取这个对象图表, 这个函数可以接受一个或多个Module作为参数：
        ObjectGraph objectGraph = ObjectGraph.create(new DripCoffeeModule());
        //需要引导注入来使用这个对象图表
        //在这个coffer例子中， CoffeeApp被用于引导注入。
        //我们请求这个对象图表构建一个CoffeeApp的对象实例
        //这个对象图表并不知道CoffeeApp这个可注入类。我们需要在@Module注释中显式的声明
        CoffeeApp coffeeApp = objectGraph.get(CoffeeApp.class);
        coffeeApp.run();
    }
}
