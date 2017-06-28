# 网站流量统计服务端

此服务端使用SpringBoot搭建,可快速打包为docker镜像,数据库使用使用`/bin/db/start_db.sh`在docker快速配置

插件项目地址[1]: [counter-web](https://github.com/xdmdpz/counter-web)      
项目后台地址[2]: [counter-backStage](https://github.com/xdmdpz/counter-backStage)
项目服务端地址[3]: [counter-web](https://github.com/xdmdpz/counter-web)

```
│  pom.xml 
│  README.md
│  
├─bin
│  │  buildDocker.sh            //打包docker镜像
│  │  buildPackage.sh           //打包可运行jar包
│  │  
│  └─db
│          counter.sql    
│          init_data.sql  
│          Dockerfile           //docker配置
│          Dockerfile.postgres  //docker配置
│          init_db.sh           //初始化数据库
│          start_db.sh          //建立一个带有mysql5.6的镜像 用户名密码均为root  端口3306
│          
├─src
│  ├─main
│  │  ├─docker
│  │  │      Dockerfile         //docker配置
│  │  │      
│  │  ├─java
│  │  │  └─com
│  │  │      └─focus
│  │  │          └─Counter
│  │  │              │  Application.java  //服务入口
│  │  │              │  
│  │  │              ├─aop  
│  │  │              │      ServiceLogAspect.java               //AOP
│  │  │              │      
│  │  │              ├─controller
│  │  │              │      CounterController.java              //负责插件接口
│  │  │              │      CounterRecordController.java        //后台数据接口
│  │  │              │      
│  │  │              ├─dao
│  │  │              │  │  ICounterRecordDao.java               //DAO接口    
│  │  │              │  │  
│  │  │              │  └─impl
│  │  │              │          BaseDao.java                    //DAO基类
│  │  │              │          CounterRecordDao.java           //DAO实现
│  │  │              │          
│  │  │              ├─entity
│  │  │              │      CounterRecord.java
│  │  │              │      PagedResult.java                    //分页对象
│  │  │              │      RestResponse.java                   //Rest风格封装返回对象
│  │  │              │      
│  │  │              ├─service
│  │  │              │      CounterRecordService.java           //业务层实现
│  │  │              │      
│  │  │              └─utils
│  │  │                      DateUtils.java                     //时间工具类
│  │  │                      MD5Utils.java                      //MD5工具类
│  │  │                      RequestUtils.java                  //http信息工具类
│  │  │                      
│  │  └─resources
│  │      │  application.properties                             //spring boot 配置文件
│  │      │  
│  │      └─mybatis
│  │          │  mybatis-config.xml                             //分页插件配置
│  │          │  
│  │          └─mapper
│  │                  CounterRecordMapper.xml                   //mybatis实现


```