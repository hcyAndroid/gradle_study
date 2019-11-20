# task action
# doLast
- 是task执行的最后一个action
- << 可以代替 doLast
- 在Gradle 4.x中被弃用（deprecated），并且在Gradle 5.0 被移除（removed）
# gradle-wrapper.properties
#下载gradle压缩包解压后存储的主目录
distributionBase=GRADLE_USER_HOME
#相对于distributionBase，gralde解压后的路径
distributionPath=wrapper/dists
#压缩包路径
zipStoreBase=GRADLE_USER_HOME
zipStorePath=wrapper/dists
#gradle发行版的下载地址,决定当前gradle的版本
distributionUrl=https\://services.gradle.org/distributions/gradle-5.4.1-all.zip
# 执行gradle的语句
 ## gradle -q  taskName

 # 打印
   ant.echo(message: "循环打印$it")
   println  'hcy2019'
   logger.quiet('打印quiet日志信息')

 # 循环 times
 ```gradle
   3.times {
    ant.echo(message: "循环打印$it")
    task "hcy$it" <<{
       println  'hcy2019'
    }
  }
```
## 定义方法 def
def 方法名(){

}

## ./gradlew 权限不允许
cd到对应的项目目录， chmod 775 gradlew

# 命令行

|命令行||
|--|--|
|gradle -q 任务名|执行某个task|
|gradle -q tasks|查看构建脚本和显示每个可以使用的task|
|gradle -q tasks --all|查看task的更多信息|
|gradle task1 task2|先执行任务1再执行任务2|
|grade task1 -x task2|在执行task1时排除一个任务task2|
|gradle -?|打印所有的可用的命令行选项|
| gradle -b test.gradle fun1|执行指定gradle文件的指定task|


|||
|--|--|
|./gradlew tasks|查看构建脚本和显示每个可以使用的task|
| ./gradlew help 任务名|查看任务帮助|
|./gradlew --refresh-dependencies assemble|强制刷新依赖|
|./gradlew -b test.gradle fun1|执行指定gradle文件的指定task|


## 任务组
多个task的集合

## 守护进程 --daemon
- 以后台进程方式运行
- 守护的进程只会车床件一次，三个小时空闲时间后自动过期


|||
|--|--|
|gradle task --daemon|开启守护进程|
|gradle task --no-daemon|构建时不使用守护进程|
|gradle task --stop|手动停止手动进程|


## 如何定义变量
```groovy
task fun1 <<{
    def tag="hcy2019"
    def tag1='1111'
    println("这是test.gradle里的fun1:${tag}")
    logger.quiet('打印quiet日志信息${tag1}')
    logger.quiet("打印quiet日志信息${tag1}")
}
```
## '' 和""的区别
都表示字符串，但“”可以用于写表达式,这一点和kt很像
## 遍历集合
- 有类似kt的风格，但不是kt
### 遍历list

```groovy
task arr << {
    def arr = [1, 2, 3, "444"]
    println "${arr.getClass().name}"
    logger.quiet("${arr[arr.size() - 1]}")
    println "${arr[0..3]}" //获取0~3的元素
    arr.forEach {
        println "${it}"
    }
    for (value in arr) {
        println value

    }
    for (value in 1..2){

        println arr[value]
    }
}
```
### 遍历map
```groovy
task map << {
    def map = ["name": "hcy2019", "age": 10,"sex":"男","address":"guangzhou"]
    //遍历map
    println "${map["name"]}===${map["age"]}"
    logger.quiet(map.sex)
    map.each{
        println "${it.key}===${it.value}"
    }
}
```
## 方法
- 方法的返回值，return 是可以省略的
- 方法调用时，（）也可以省略

```groovy
def fun1(int a, int b) {
     a + b
}

task method << {
    println fun1(1,2)
    println "${fun1 2,3}"
}
```
# 闭包
## 闭包委托
### thisObject
### owner
### delegate

- thisObject 指的是当前的上下文，而delegate指的是当前内部类的上下文
- 目前看来owner和delegate是相等的
- 目前看来thisObject owner delegate 并没有一定的编译顺序，顺序还是从你的编译task里从上向下执行
- 如果委托的时候指定了一个类为delegate 说明他是内部类，委托方法里的属性应该是先从内部类找，找不到才从当前的上下文找

### Closure
- 用于委托，注意它的路径是import groovy.lang.*   IJ有编译bug，注意
```groovy
class Dog {
    private String name = "灰灰"
    private String sex = "公的"

    def fei() {
        println("这只叫${name}的狗，它在叫")
    }
}

def dog(Closure<Dog> dogc) {
    Dog dog = new Dog()
    dogc.delegate=dog
    dogc.setResolveStrategy(Closure.DELEGATE_FIRST)
    dogc(dog)

}

task fun5<<{
    dog{
        name="666"
        sex="母的"
        fei()
    }
}
```

# 任务 task
## 创建任务
```groovy
def Task task1 = task("task1")
task1.doLast {
    println("创建任务task1")
}
```

```groovy
def Task task2 = task("task2", group: BasePlugin.BUILD_GROUP)
task2.doLast {
    println("创建任务task2")
}
```

```groovy
task task3{
    println("这是task3的任务")
}
def Task task2 = task("task2",
        group: BasePlugin.BUILD_GROUP,
        description: "这是task2的任务的功能描述",
dependsOn: task3)
task2.doLast {
    println("配置任务的分组===${task2.group}")
    println("配置任务的描述===${task2.description}")
    println("配置任务的依赖===${task2.dependsOn}")
}
```

```groovy
task task4{
    println("这是task4的任务")
}
task task3{
    description "这是task3的任务的功能描述"
    dependsOn task4
    println("这是task3的任务")
    println("${task3.description}")
}
```

```groovy
tasks.create("task5"){
    description "这是task5的描述"
}
```

## mustRunAfter
task1.mustRunAfter(task2)
- 在task2执行完task1才会继续执行
## 任务的启用与禁用
task6.enabled=false

# 插件
## 二进制插件
## 脚本插件
## DSL 应用插件




