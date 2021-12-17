# logback的使用
在application.properties中配置logback的配置文件logback.xml，logging.file.name=logback.xml
在使用的地方private static final Logger LOG = LoggerFactory.getLogger(类名.class);

# log4j的使用
在pom文件中添加依赖
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-log4j12</artifactId>
    <version>1.7.2</version>
    <scope>runtime</scope>
</dependency>
<dependency>
    <groupId>log4j</groupId>
    <artifactId>log4j</artifactId>
    <version>1.2.17</version>
</dependency>
在使用的地方public static final Logger LOG = LoggerFactory.getLogger(类名.class);

