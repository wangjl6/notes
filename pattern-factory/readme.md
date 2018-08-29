####工厂模式
#####普通工厂模式
    个人认为普通工厂模式并不是一个设计模式
    更像是同类型方法的封装，根据调用方的需求实例话或选择工厂提供不通的入口
    得到返回的内容，跟普通分装的方法不同的地方可能就在于工厂模式提供的入口或方法
    都必须遵守统一的规范，也就是接口。
    普通工厂是一种纵向的归类。
#####抽象工厂模式
    抽象工厂的概念相对比较模糊，抽象的工厂模式应该是对不同产品组(类似品牌、商家这样的分类)
    比如：小米、苹果、华为这种不同的产品组进行一层抽象。
    不同产品组有各自的工程类或方法实现。
    抽象工厂方法更像是一种纵向的归类
    比如
        小米：手机  电脑  电视
        华为：手机  电脑  电视
        苹果：手机  电脑  电视
    那么，小米、华为和苹果都有各自的工厂来生产自己的产品。
    当我们去获取同一个产品组的产品时应该根据不同的工厂去获取
    当然，各自产品组的工厂都要按照抽象工厂的规范来实现。
    
####疑问
    听了老师讲抽象工厂模式，其实不太理解。视频中的抽象方法其实改成普通的类是不是也是成立的。
    或者说作为工厂模式，就必须要有规范作为前提。也就是接口
    
####补充
    今天晚上看了几篇关于工厂模式的文章，感觉抽象工厂模式最大的作用在于代码的组合，类似于高级的多态解耦
    定义了不同产品组的工厂可以在runtime的时候决定实际调用的工厂类，而不同产品组的工厂能够让代码真正做到组合
    而并非一味的if/else。
    为什么不用if/else，我觉得最后一句概括的很好。
    作者：chao wang
    链接：https://www.zhihu.com/question/30351872/answer/80390123
    来源：知乎
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    
    接Volley的例子下去。如果只有一个工厂，但同一个Service在不同环境下会有不同的实现，那么如果环境很多，这个ServiceFactory会变成什么样呢，大概这样：class ServiceFactory{
      Environment env;
      //假设MY_SQL, ORACLE是类型为Environment的全局常量
      public static Service getService(){
        if(env == MY_SQL){
          retrun new ServiceA(arg1, arg2...);
        } else if (env == ORACLE){
          retrun new ServiceB(arg1, arg2...);
        } else if (evn == BIG_TABLE){
          return new ServiceC(arg2, arg2...);
        } ....
      }
    }
    那么就会遇到Volley答案中同样的问题，if/else越来越多，每次修改都需要重新编译整个Factory。而且，一般情况下，实现这些Service的往往是不同组的人。每个组都往这个类里面加参数/状态，大家合并代码时会出现无数个冲突，还可能互相用错参数从而影响别人代码的情况，简直美如画。抽象工厂把大家的实现分开到了不同的类里面，让大家各改各的文件，互不影响：//小组1的文件：
    class MySqlFactory implements ServiceFactory{
      public static Service getService(){
        //计算arg1, arg2...
        return new ServiceA(arg1, arg2);
      }
    }
    
    //小组2的文件：
    class OracleFactory implements ServiceFactory{
      public static Service getService(){
        //计算arg1, arg2...
        return new ServiceB(arg1, arg2);
      }
    }
    ....
    然后这些工厂一般不需要使用时才new，只需要事先new好，存入一个Map，根据具体环境随时调用。Map<Environment, ServiceFactory> factoryMap = new HashMap<>();
    factoryMap.put(MY_SQL, new MySqlFactory());
    factoryMap.put(ORACLE, new OracleFactory());
    ...
    然后调用serviceConsumer的那个地方只需要根据具体的环境这么用：Environment env = ...//获得环境变量env
    ServiceFactory factory = factoryMap.get(env);
    serviceConsumer(factory);
    就这么简单，以后万一有新的数据库，重新写一个ServiceFactory的实现类，编译一下放一块儿就行，在factoryMap里放入实例就好了，别的代码完全不需要动，甚至不需要重新编译，是不是很酷。（我已经觉得自己像在背书了。。。）你问我可不可以不要Factory，直接弄一个ServiceMap呢？Map<Environment, Service> serviceMap = new HashMap<>();
    serviceMap.put(MY_SQL, new ServiceA(...));
    serviceMap.put(ORACLE, new ServiceB(...));
    基本是不行的，首先Service的初始化一般需要很多参数，这些参数基本是不可能在程序刚载入的时候就有了的。另外Service的实例会new很多个，也不满足一一对应的关系。但Factory的构造函数一般不需要参数的，初始化Service所需的数据Factory会临时获取（从这点看Factory类也不是那么好写的）。而且相比于Service，Factory内部保存的仅仅是一些参数，占用内存小得多，长时间驻留在内存中也没有太大的损害。最后的最后，设计模式已经是面向对象中较高层次的知识了，在这个阶段请不要再抱有“用XXX也能达到效果”这样的想法了。绝大部分高级语言能做的事情，C语言都能够做到，或者说“用C语言也能达到这样的效果”。我们面向对象编程，是为了让程序的扩展性更强，出错率更小，让上千人能合作写一个项目也能做到有条不紊。遇到新的设计模式，往这几点想一想能略知一二，就基本学到家了。