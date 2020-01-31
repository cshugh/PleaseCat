1.Mysql에서 테이블 생성 -  SQL문 작성

**첨부파일**

PleaseCat.exerd  [파일 다운로드](http://blogattach.naver.net/1e8b02b1a5f3fa2609e48dbe89611b61c2926a82f2/20200122_91_blogfile/iceoven_1579661643305_nN43Qo_exerd/PleaseCat.exerd)

```mysql
use pleasecat;

DROP TABLE user;
DROP TABLE cat;
DROP TABLE post;
DROP TABLE following_user;
DROP TABLE following_cat;
DROP TABLE likes;
DROP TABLE unlikes;
DROP TABLE report;
DROP TABLE comment;
DROP TABLE ranking;
```



# USER 테이블

```mysql
CREATE TABLE USER (
		user_no				int	PRIMARY KEY AUTO_INCREMENT,	# 회원 관리번호
		user_email			varchar(100) NOT NULL UNIQUE,	# 로그인ID 대용 이메일
		user_pw				varchar( 50) NOT NULL,	# 패스워드
		user_id				varchar(100) NOT NULL,	# 닉네임
		user_image			varchar(300),	# 회원 프로필 이미지 경로
		user_desc			varchar(300)	# 회원 자기소개
);
```

# CAT 테이블
```mysql
CREATE TABLE CAT (
		cat_no				int	PRIMARY KEY AUTO_INCREMENT,	# 고양이 관리번호
		cat_name			varchar(100) NOT NULL UNIQUE,	# 고양이 이름
		age					varchar( 50) NOT NULL,	# 나이
		sex					varchar( 50) NOT NULL,	# 성별
		reg_date			varchar(300),	# 회원 프로필 이미지 경로
		meal_time			varchar(100),	# 마지막 식사 시간
        skin_disease		boolean		,	# 피부병 여부
        cat_location		varchar(100),	# 고양이 위치
        cat_manager			varchar( 50),	# 고양이 관리자 회원번호
        neuter				boolean		,	# 중성화 여부
        cat_desc			varchar(300),	# 고양이 소개
        hurt				boolean		,	# 상처 여부
        hair_color			varchar(100),	# 털 색
        eye_color			varchar(100)	# 눈 색
);
```

# POST 테이블
```mysql
CREATE TABLE POST (
		post_no				int	PRIMARY KEY AUTO_INCREMENT,	# 게시글 관리번호
		user_no				int NOT NULL UNIQUE,	# 회원 관리번호 (외래키)
		cat_no				int NOT NULL,			# 고양이 관리번호 (외래키)
		post_image			varchar(300) NOT NULL,	# 게시글 이미지 경로
		post_time			varchar(100),			# 게시글 등록 시간
		post_content		varchar(300),			# 게시글 내용
        post_like			int	,					# 좋아요 숫자
        post_unlike			int,					# 싫어요 숫자
        post_location		varchar(100),			# 사진 위치
        post_report			int,					# 신고 숫자
        foreign key(user_no) references user(user_no), 
        foreign key(cat_no) references cat(cat_no)
);
```

# FOLLOWING_USER 테이블 (회원 팔로잉)
```mysql
CREATE TABLE FOLLOWING_USER (
	followed_no			int NOT NULL,			#팔로우 당하는 회원 외래키 	
	follower_no			int	NOT NULL,			#팔로우 하는 회원 외래키
    FOREIGN KEY(followed_no) REFERENCES USER(user_no),
    FOREIGN KEY(follower_no) REFERENCES USER(user_no)
);
```



# FOLLOWING_CAT 테이블 (고양이 팔로잉)
```mysql
CREATE TABLE FOLLOWING_CAT (
	follower_no		int NOT NULL,				# 팔로우 하는 회원 외래키
	cat_no			int	NOT NULL,				# 팔로우 받는 고양이 외래키
    FOREIGN KEY(follower_no) REFERENCES USER(user_no), 
	FOREIGN KEY(cat_no)	 	REFERENCES CAT(cat_no)
);
```



# LIKES 테이블 (좋아요 여부)
```mysql
CREATE TABLE LIKES (
	user_no			int NOT NULL,				# 좋아요 누른 회원 외래키
	post_no			int	NOT NULL,				# 좋아요 받은 게시글 외래키
    FOREIGN KEY(user_no) 		REFERENCES USER(user_no), 
	FOREIGN KEY(post_no)	 	REFERENCES POST(post_no)
);
```



# UNLIKES 테이블 (게시글 싫어요 여부)
```mysql
CREATE TABLE UNLIKES (
	user_no			int NOT NULL,				# 싫어요 누른 회원 외래키
	post_no			int	NOT NULL,				# 싫어요 받은 게시글 외래키
    FOREIGN KEY(user_no) 		REFERENCES USER(user_no), 
	FOREIGN KEY(post_no)	 	REFERENCES POST(post_no)
);
```



# REPORT 테이블 (신고 여부)
```mysql
CREATE TABLE REPORT (
	user_no			int NOT NULL,				# 신고 누른 회원 외래키
	post_no			int	NOT NULL,				# 신고 받은 게시글 외래키
    FOREIGN KEY(user_no) 		REFERENCES USER(user_no), 
	FOREIGN KEY(post_no)	 	REFERENCES POST(post_no)
);
```



# COMMENT 테이블
```mysql
CREATE TABLE COMMENT (
	comment_no		int PRIMARY KEY AUTO_INCREMENT,	# 댓글 관리번호	기본키, 자동증가
	post_no			int,			# 게시글 번호 외래키
	user_no			int,			# 회원 번호 외래키	
	comment_time	varchar(100),	# 댓글 등록 시간	
	comment_content	varchar(300),	# 댓글 내용
	comment_like	int,		# 댓글 좋아요수
	comment_unlike	int,		# 댓글 싫어요수
	comment_report	int,		# 댓글 신고수
    FOREIGN KEY(post_no) REFERENCES POST(post_no),
    FOREIGN KEY(user_no) REFERENCES USER(user_no)
);
```

# RANKING 테이블
```my
CREATE TABLE RANKING (
	cat_no			int,			# 고양이 번호 외래키
	user_no			int,			# 회원 번호 외래키
	rank_point		int,			# 점수
    FOREIGN KEY(cat_no) REFERENCES CAT(cat_no),
    FOREIGN KEY(user_no) REFERENCES USER(user_no)
);
```



\2. SpringBoot 테이블 생성 (New Spring Starter Project)


* Packaging : War 로 해야함.

* Group, Atirfact - Maven관련

* Group과 Package 이름 똑같이

여기 패키지밑에 애들은 모두 자동스캔인데 나머지애들은 따로 스캔하라고 말해줘야함.

=> Next

- Spring Web

- Spring Boot DevTools : 변화를 감지해서 서버에 reload시켜줌

- JDBC API

- MyBatis Framework

- MySQL Driver


  pakage는 com.ssafy 까지만 썼음

\3. 

```xml
﻿ <!-- boot에서 tomcat이 jsp를 서비스 하도록 설정 -->
<dependency> 
    <groupId>org.apache.tomcat.embed</groupId> 
    <artifactId>tomcat-embed-jasper</artifactId> 
</dependency> 
</dependencies> 

pom.xml에 추가 이걸 넣어줘야 SpringProject로 인식
```



\4. swagger pom.xml 에 추가

```xml
		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger-ui</artifactId>
			<version>2.9.2</version>
		</dependency>
		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger2</artifactId>
			<version>2.9.2</version>
		</dependency>
```



5. 참고 내용

[commons-dbcp] 

데이터베이스와 애플리케이션을 효율적으로 연결하는 커넥션 풀(connection pool) 라이브러리는  웹 애플리케이션에서 필수 요소입니다.  웹 애플리케이션 서버로 상용 제품을 사용하다면 보통 제조사에서 제공하는 커넥션 풀 구현체를 사용합니다. 

그 외에 오픈소스 라이브러리로 Apache의 Commons DBCP와 Tomcat-JDBC, BoneCP, HikariCP 등이 있습니다. 커넥션 풀 라이브러리를 잘 사용하면 데이터베이스와 애플리케이션의 일부분에서 발생하는 문제가  전체로 전파되지 않게 할 수 있고, 일시적인 문제가 긴 시간 이어지지 않게 할 수 있습니다.  반대로 값을 적절하지 못하게 설정해서 커넥션 풀이 애플리케이션에서 병목 지점이 되는 경우도 있습니다.  웹 애플리케이션의 요청은 대부분 DBMS(database management system)로 연결되기 때문에  커넥션 풀 라이브러리의 설정은 전체 애플리케이션의 성능과 안정성에 영향을 미치는 핵심입니다. 

이렇게 중요한 커넥션 풀 라이브러리를 적절하게 사용하려면 라이브러리의 내부 구조와 원리,  속성값의 의미를 이해해야 합니다.  

이 글에서는 대표적인 오픈소스 커넥션 풀 라이브러리인 Commons DBCP를 살펴보겠습니다.



[ jackson-databind ] 

Jackson 은 자바용 json 라이브러리로 잘 알려져 있지만 Json 뿐만 아니라 XML/YAML/CSV 등 다양한 형식의 데이타를 지원하는 data-processing 툴이다. 스트림 방식이므로 속도가 빠르며 유연하며 다양한 third party 데이타 타입을 지원하며 annotation 방식으로 메타 데이타를 기술할 수 있으므로 JSON 의 약점중 하나인 문서화와  데이타 validation 문제를 해결할 수 있다.

[jstl] - JSP 표준 태그 라이브러리(여러 프로그램이 공통으로 사용하는 코드를 모아놓은 코드의 집합)의 약어 - 자신만의 태그를 추가할 수 있는 기능 제공한다. 

- 주로 JSTL의 Core에서 c를 사용하여 <c:if> , <c:forEach>

  ```xml
  <dependency>
  			<groupId>commons-dbcp</groupId>
  			<artifactId>commons-dbcp</artifactId>
  			<version>1.4</version>
  		</dependency>
  		<dependency>
  			<groupId>com.fasterxml.jackson.core</groupId>
  			<artifactId>jackson-databind</artifactId>
  			<version>2.9.2</version>
  		</dependency>
  		<dependency>
  		    <groupId>javax.servlet</groupId>
  		    <artifactId>jstl</artifactId>
  		</dependency>
  ```

  

\6. DTO 패키지에 테이블별 dto들 생성 (bean class 객체들)

일단 user.java 작성

```java
package com.ssafy.model.dto; 
public class user { 
    private int user_no;  
    private String user_email;  
    private String user_pw;  
    private String user_id;  
    private String user_image;  
    private String user_desc;   
    public user() {}  
    public user(int user_no, String user_email, String user_pw, String user_id){ 	super(); 	
                                                                          			this.user_no = user_no; 	
    this.user_email = user_email; 	
    this.user_pw = user_pw; 	
	this.user_id = user_id; }  

public user(int user_no, String user_email, String user_pw, String user_id, String user_image, String user_desc) { 	
super(); 	
this.user_no = user_no; 	
this.user_email = user_email; 	
this.user_pw = user_pw; 	
this.user_id = user_id; 	
this.user_image = user_image; 	
this.user_desc = user_desc; 
}  

public int getUser_no() { 	return user_no; } 
public void setUser_no(int user_no) { 	this.user_no = user_no; } 
public String getUser_email() { 	return user_email; } 
public void setUser_email(String user_email) { 	this.user_email = user_email; } public String getUser_pw() { 	return user_pw; } 
public void setUser_pw(String user_pw) { 	this.user_pw = user_pw; } 
public String getUser_id() { 	return user_id; } 
public void setUser_id(String user_id) { 	this.user_id = user_id; } 
public String getUser_image() { 	return user_image; } 
public void setUser_image(String user_image) { 	this.user_image = user_image; } public String getUser_desc() { 	return user_desc; } 
public void setUser_desc(String user_desc) { 	this.user_desc = user_desc; } 	

@Override public String toString() { 	return "user [user_no=" + user_no + ", user_email=" + user_email + ", user_pw=" + user_pw + ", user_id=" 			+ user_id + ", user_image=" + user_image + ", user_desc=" + user_desc + "]"; }   }
```





\7. static / SqlMapConfig . xml 작성



dto 와 dto에 해당하는 query문 xml을 mapping 시켜주는 config 파일 작성

```xml
<?xml version="1.0" encoding="UTF-8"?>

<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
      "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
  <typeAliases>
   	<typeAlias type ="com.ssafy.model.dto.user" 		alias ="user"/>
   	<!-- <typeAlias type ="com.ssafy.model.dto.FoodPageBean" alias ="pagebean"/> -->


  </typeAliases>
    
  <mappers>
     <!--  <mapper url = ""/> 리소스 or URL -->  
     <mapper resource = "static/user_query.xml"/>

  </mappers>
   <!-- query 설정 끝 -->
</configuration>
```





\8. dto에 해당하는 query.xml 을 작성 in static폴더



데이터베이스와 연동하는 쿼리문 작성 (해당 쿼리문을 dao와 mapping시키면 dao에는 interface만 작성해서

id와 interface 함수들 이름만 맞춰주면 실제로 interface함수들을 구현할 필요가없음)

```xml
<?xml version="1.0" encoding="UTF-8" ?>

<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd"> 


<mapper namespace="com.ssafy.model.dao.UserDao" >
	
	<insert id ="insertUser" parameterType="user">
	insert into user(user_no, user_email,user_pw, user_id, user_image, user_desc) 
				values(#{user_no:INTEGER} <!-- INT로 쓰면 문법오류남 -->
					  ,#{user_email:VARCHAR}
					  ,#{user_pw:VARCHAR}
					  ,#{user_id:VARCHAR}
					  ,#{user_image:VARCHAR}
					  ,#{user_desc:VARCHAR})			
	</insert>

    <select id = "searchUser" parameterType="int" resultType="user">
    	select * from user where id=#{id}
    </select>


</mapper>
```






\9. dto에 해당하는 dao 작성

```java
package com.ssafy.model.dao;
 import org.apache.ibatis.annotations.Mapper; 
import org.springframework.stereotype.Repository; 
import com.ssafy.model.dto.user; 

@Repository 
@Mapper 
public interface UserDao {
public user searchUser(int user_no); 
public void insertUser(user user);
 }
```





\10. service 패키지에서 user에서 사용하는 service 메소드들을 interface로 선언

```java
package com.ssafy.model.service; 
import com.ssafy.model.dto.user; 
public interface UserService  { 
public user searchUser(String id) ; 
public void insertUser(user user) ; 
}
```



\11. interface내에 service 메소드들을 구현

```java


package com.ssafy.model.service; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;
 import com.ssafy.model.dao.UserDao;
 import com.ssafy.model.dto.user;
 @Service
 public class UserServiceImp implements UserService { 
@Autowired private UserDao dao; 	
public user searchUser(int user_no) { 
	try {  	
	user User = dao.searchUser(user_no); 		
if(User == null) { 			
throw new PleaseCatException("찾으려는 정보가 없습니다"); 		
} else { 			
return User; 		} 	
	} catch (Exception e) { 		throw new PleaseCatException(); 	
	} 
} 	
 public void insertUser(user User) { 
	try { 		user find = dao.searchUser(User.getUser_no()); 		
	if(find != null) { 			
	throw new PleaseCatException(); 		
	}else { 			
	dao.insertUser(User); 		} 	
	} catch (Exception e) { 		
	throw new PleaseCatException(); 	
	} 
 	}
 }
```



\12. exception 파일 dto에 작성

```java
PleaseCatException.java

package com.ssafy.model.dto; 
public class PleaseCatException extends RuntimeException {
 public PleaseCatException() { 	 } 
	public PleaseCatException(String msg) { 	super(msg); }
 }
```





\13. RestController를 작성한다

```java
package com.ssafy.controller; 
import java.util.HashMap; 
import java.util.Map; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.HttpStatus;
 import org.springframework.http.ResponseEntity; 
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.ExceptionHandler; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.RequestBody; 
import com.ssafy.model.dto.user; 
import com.ssafy.model.service.UserService; 
import io.swagger.annotations.ApiOperation; 

@Controller 
public class UserRestController {  

@Autowired 
private UserService userService;  

@ExceptionHandler 
public ResponseEntity<Map<String, Object>> handle(Exception e){ 	
return handleFail(e.getMessage(), HttpStatus.OK); 
}  

public ResponseEntity<Map<String, Object>> handleSuccess(Object data){ 	Map<String, Object> resultMap = new HashMap<String, Object>(); 	resultMap.put("state", "ok"); 	
resultMap.put("data", data); 	
return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.OK); 
}  

public ResponseEntity<Map<String, Object>> handleFail(Object data, HttpStatus state){ 	

Map<String, Object> resultMap = new HashMap<String, Object>(); 	
resultMap.put("state", "fail"); 	
resultMap.put("data", data); 	
return new ResponseEntity<Map<String,Object>>(resultMap, state);  
}  

@ApiOperation("새로운 유저 정보를 입력한다.") 

@PostMapping("api/insertUser") 
public ResponseEntity<Map<String, Object>> insertUser(@RequestBody user User) throws Exception{ 	
userService.insertUser(User); 	
return handleSuccess("유저 등록 완료"); }  

@ApiOperation("회원 관리번호로 회원 정보를 찾는다.") @GetMapping("api/searchUser/{user_no}") 
public ResponseEntity<Map<String, Object>> searchUser(@PathVariable int user_no) throws Exception{ 	
return handleSuccess(userService.searchUser(user_no)); }  
}
```





\14. SwaggerConfig를 작성해서 사용을 준비한다.

com.ssafy.config 패키지내에 작성

```java
package com.ssafy.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2; @Configuration @EnableSwagger2	
//스웨거 환경설정
publicclassSwaggerConfig{ @Bean public Docket api(){returnnewDocket(DocumentationType.SWAGGER_2).groupName("PleaseCat-controller")//서비스할 project 이름이나 Domain이름
.apiInfo(info())//스웨거 화면에 표시할 설명 정보
.select().apis(RequestHandlerSelectors.basePackage("com.ssafy.controller"))//서비스할 애들.
.paths(PathSelectors.ant("/api/**"))//경로 잡아주기 
. ant로 pattern처리 phone으로 들어오는 모든것
.build();//빌드패턴 : 객체 생성할때 .을 통해서 다양한 설정을 해주고나서 마지막에 build로 마무리함 	 	 }
private ApiInfo info(){returnnewApiInfoBuilder()
.title("SSAFY API")
.description("PleaseCat API Reference for Developers")
.license("PLEASE CAT MANAGEMENT 2020")
.version("1.0")
.build();}
}
```



