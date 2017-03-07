# test-dubbo
Dubbo与Zookeeper、Spring整合使用

 
Dubbo采用全Spring配置方式，透明化接入应用，对应用没有任何API侵入，只需用Spring加载Dubbo的配置即可，Dubbo基于Spring的Schema扩展进行加载。
 
一：单机模式安装zookeeper

 
1,下载zookeeper注册中心，下载地址：http://www.apache.org/dyn/closer.cgi/zookeeper/ 下载后解压即可，进入E:\zookeeper-3.3.6\zookeeper-3.3.6\bin，
双击zkServer.cmd启动注册中心服务。
zkServer.sh【Linux】或zkServer.cmd【Windows】
 
2,在你执行启动脚本之前，还有几个基本的配置项需要配置一下，Zookeeper的配置文件在 conf 目录下，这个目录下有 zoo_sample.cfg 和 log4j.properties，你需要做的就是将zoo_sample.cfg 改名为 zoo.cfg，因为 Zookeeper在启动时会找这个文件作为默认配置文件。下面详细介绍一下，这个配置文件中各个配置项的意义。

 

   •tickTime：这个时间是作为Zookeeper 服务器之间或客户端与服务器之间维持心跳的时间间隔，也就是每个 tickTime 时间就会发送一个心跳。
   •dataDir：顾名思义就是 Zookeeper保存数据的目录，默认情况下，Zookeeper 将写数据的日志文件也保存在这个目录里。
   •dataLogDir：顾名思义就是Zookeeper 保存日志文件的目录
   •clientPort：这个端口就是客户端连接Zookeeper 服务器的端口，Zookeeper 会监听这个端口，接受客户端的访问请求
 
配置好后，zookeeper会监听本机的2181端口。
当这些配置项配置好后，你现在就可以启动 Zookeeper 了，启动后要检查 Zookeeper 是否已经在服务，可以通过 netstat – ano 命令查看是否有你配置的 clientPort 端口号在监听服务。
 
二：服务提供者
 
定义服务接口:(该接口需单独打包，在服务提供方和消费方共享)
在服务提供方实现接口：(对服务消费方隐藏实现)
用Spring配置声明暴露服务：具体实现看spring.xml

加载Spring配置，启动服务（或者将项目建为web项目，然后在web.xml中配置好spring的启动，然后扔到tomcat中即可提供服务）：

三：服务消费者
 
通过Spring配置引用远程服务：具体实现看consumer-spring.xml

调用服务测试：Consumer 

附：Dubbo的管理页面
 
需要下载：dubbo-admin-2.5.3的war包
下载地址：http://download.csdn.net/detail/u013286716/7041185
 
操作如下：

1，替换掉tomcat/webapps下自带的ROOT文件夹内容（即替换tomcat的启动主页），将下载的war包解压到webapps/ROOT中，直接替换即可
 
2，启动tomcat，访问ip:8080即可或者如果是本地的话使用localhost:8080
输入用户名密码，在E:\apache-tomcat-7.0.6-dubbo\webapps\ROOT\WEB-INF下的dubbo.properties文件中即可查看到

3，访问 http://localhost:8080

4，启动我们的服务提供者和消费者即可查看到


优点：
    服务提供者和服务消费者只需要知道注册中心即可，它们之间打交道需通过注册中心这个第三方，只要是注册中心中已经注册的服务，我们均可以使用，实现了服务提供者和服务消费者间的解耦。
