# Eureka 高可用集群配置:  (单节点模式并不适用于生产环境,生产环境推荐使用eureka高可用集群,以避免单点故障带来的机器集群服务注册故障导致整个系统不可用)
#   1. application.yml中配置多个eureka环境 在启动时手动指定激活某个配置环境
#   2. 各个环境中 eureka服务器需要向其他所有eureka节点注册自己
#   3. 在eureka高可用环境中,eureka客户端需要向所有eureka服务端注册
#   4. 若需要在本地测试eureka高可用,需要在hosts文件中添加对应主机名

spring:
  application:
    name: yokimi-ebusiness-cloud-discovery
security:
  basic:
    enabled: true
  user:
    name: root
    password: root
---
server:
  port: 8761
spring:
  profiles: peer1
eureka:
  instance:
    hostname: peer1
    prefer-ip-address: true
    instance-id: ${spring.application.name}:${spring.application.instance_id:${server.port}}
  client:
    serviceUrl:
      defaultZone: http://root:root@peer2:8762/eureka/
---
server:
  port: 8762
spring:
  profiles: peer2
eureka:
  instance:
    hostname: peer2
    prefer-ip-address: true
    instance-id: ${spring.application.name}:${spring.application.instance_id:${server.port}}
  client:
    serviceUrl:
      defaultZone: http://root:root@peer1:8761/eureka/