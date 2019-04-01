spring:
  application:
    name: employeerecords
  mvc:
    view:
      suffix: .jsp
      prefix: /WEB-INF/jsp/
  datasource:
    username: root
    password: 
    url: jdbc:mysql://localhost:3306/employee
    driver-class-name: com.mysql.cj.jdbc.Driver
  jpa:
    show-sql: true
    hibernate:
      ddl-auto: update
    properties:
      hibernate:
      dialect: org.hibernate.dialect.MySQL5Dialect
server:
  port: 8888
  
  
  
  
  <dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>jstl</artifactId>
		</dependency>
		<!-- Need this to compile JSP -->
		<dependency>
			<groupId>org.apache.tomcat.embed</groupId>
			<artifactId>tomcat-embed-jasper</artifactId>
		</dependency>

		<!-- Need this to compile JSP, tomcat-embed-jasper version is not working, 
			no idea why -->
		<dependency>
			<groupId>org.eclipse.jdt.core.compiler</groupId>
			<artifactId>ecj</artifactId>
			<version>4.6.1</version>
		</dependency>

		<!-- Optional, test for static content, bootstrap CSS -->
		<dependency>
			<groupId>org.webjars</groupId>
			<artifactId>bootstrap</artifactId>
			<version>3.3.7</version>
		</dependency>
