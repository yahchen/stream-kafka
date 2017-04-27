# stream-kafka

# 简介
Spring Cloud Stream 是基于消息驱动微服务应用框架。

Spring Cloud Stream is a framework for building message-driven microservice applications. Spring Cloud Stream builds upon Spring Boot to create standalone, production-grade Spring applications, and uses Spring Integration to provide connectivity to message brokers. It provides opinionated configuration of middleware from several vendors, introducing the concepts of persistent publish-subscribe semantics, consumer groups, and partitions.

#1.1 术语：

*bindding：连接channel和binder的组件
*binder：粘合剂，对外连接brokers
*group：对消费者分组，实现类似于active mq中topic的发布订阅
*out: 输出channel
*input: 输入channel


#1.2 搭建工程

1.2.1  idea创建： File -> new -> spring initializr -> next -> 填写工程名，maven路径，next -> 选择spring boot 版本，选择spring组件（本工程选择spring-cloud，spring-web）

1.2.2  spring boot cli创建：spring init -dweb,cloud(该命令需要安装spring boot cli,默认创建为maven结构的工程-d为maven依赖)  

1.2.3 jdk版本，官方建议为1.6以上。推荐使用1.7+。

#1.3 版本问题
本文选择的spring cloud stream的版本为Chelsea.SR1，对应的kafka版本为0.10.1.1,对接的kafka集群最好是0.10版本以上的。如果低于0.10，会出现工程启动失败的错误。有2种解决方案：
1）、加验证，具体操作请参考，连接：验证
2）、降低spring cloud stream版本至1.0.2.RELEASE,该版本对应的kafka-client版本为0.8.2.2

#1.4 配置
spring cloud stream默认提供了一套基础配置，broker为localhost:9092,zkNode为localhost:2181，其他选项也均为默认值（所以，如果你为本地部署，原则上不需要添加任何配置项）。具体可参考spring-scloud-stream jar中的org.springframework.cloud.stream.config包中的javaconfig

spring 1.x xml配置，spring 2.x 注解配置，spring 3.x java 配置，spring boot习惯性配置。官方推荐为java config+习惯性配置

#1.5 注解
SpringBootApplication:继承了EnableAutoConfiguration、ComponentScan。主要完成自动化配置和路径扫描。

EnableBinding:开启stream功能。参数可以source、sink、process。也可以自己实现（主要为声明channel）。

RestController:开启web功能。与Controller类似。官方解释：@RestController is a stereotype annotation that combines @ResponseBody and @Controller.

RequestMapping:开启绑定url功能，url可通过参数指定。

StreamListener:开启监听channel功能，参数为默认或实现的channel接口。

EnableAutoConfiguration：开启自动配置功能。继承自

ComponentScan：开启扫描功能，主要针对bean和配置文件。

#1.6 问题

1.6.1 私服问题

spring cloud stream应用中大部分的jar包，maven中央仓库因国内环境下载速度过慢。建议仓库配置添加国内地址。
添加方法：修改maven根目录conf 文件夹中的 server.xml；或复制该文件到本地.m2文件夹中；或者项目pom中添加。


http://maven.aliyun.com/nexus/content/groups/public/
http://uk.maven.org/maven2/
http://maven.oschina.net/content/groups/public/
http://maven.aliyun.com/nexus/content/repositories/snapshots/
        

1.6.2 actuator监控问题
问题:type=Unauthorized, status=401

添加配置参数：

actuator j监控运行jar信息，关闭验证
management.health.mail.enabled=false
management.security.enabled=false


#1.7 actuator 使用说明
/beans:查看当前应用Ioc容器bean状态

/mappings:查看web url和方法映射

/trace:查看最近http请求

/env:查看环境变量

/configprops:查看配置变量

/info:查看基础信息

/dump:查看线程堆栈生成的信息

/shutdown:优雅关闭

/autoconfig:自动装配信息

/health:当前健康状况（可自定义配置）

排查问题神器，建议搭建spring boot应用整合actuator。
