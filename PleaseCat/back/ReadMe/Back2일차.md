\1.  boolean형을 있음 없음 알수없음까지 포함하기 위해 int형으로 변경

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

# USER 테이블
CREATE TABLE USER (
		user_no				int	PRIMARY KEY AUTO_INCREMENT,	# 회원 관리번호
		user_email			varchar(100) NOT NULL UNIQUE,	# 로그인ID 대용 이메일
		user_pw				varchar( 50) NOT NULL,	# 패스워드
		user_id				varchar(100) NOT NULL,	# 닉네임
		user_image			varchar(300),	# 회원 프로필 이미지 경로
		user_desc			varchar(300)	# 회원 자기소개
);

# CAT 테이블
CREATE TABLE CAT (
		cat_no				int	PRIMARY KEY AUTO_INCREMENT,	# 고양이 관리번호
		cat_name			varchar(100) NOT NULL UNIQUE,	# 고양이 이름
		age					varchar( 50) NOT NULL,	# 나이
		sex					varchar( 50) NOT NULL,	# 성별
		reg_date			varchar(300),	# 회원 프로필 이미지 경로
		meal_time			varchar(100),	# 마지막 식사 시간
        skin_disease		int		,	# 피부병 여부
        cat_location		varchar(100),	# 고양이 위치
        cat_manager			varchar( 50),	# 고양이 관리자 회원번호
        neuter				int		,	# 중성화 여부 boolean형 대신 알수없음을 위해 int
        cat_desc			varchar(300),	# 고양이 소개
        hurt				int		,	# 상처 여부
        hair_color			varchar(100),	# 털 색
        eye_color			varchar(100)	# 눈 색
);

# POST 테이블
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

# FOLLOWING_USER 테이블 (회원 팔로잉)
CREATE TABLE FOLLOWING_USER (
	followed_no			int NOT NULL,			#팔로우 당하는 회원 외래키 	
	follower_no			int	NOT NULL,			#팔로우 하는 회원 외래키
    FOREIGN KEY(followed_no) REFERENCES USER(user_no),
    FOREIGN KEY(follower_no) REFERENCES USER(user_no)
);

# FOLLOWING_CAT 테이블 (고양이 팔로잉)
CREATE TABLE FOLLOWING_CAT (
	follower_no		int NOT NULL,				# 팔로우 하는 회원 외래키
	cat_no			int	NOT NULL,				# 팔로우 받는 고양이 외래키
    FOREIGN KEY(follower_no) REFERENCES USER(user_no), 
	FOREIGN KEY(cat_no)	 	REFERENCES CAT(cat_no)
);

# LIKES 테이블 (좋아요 여부)
CREATE TABLE LIKES (
	user_no			int NOT NULL,				# 좋아요 누른 회원 외래키
	post_no			int	NOT NULL,				# 좋아요 받은 게시글 외래키
    FOREIGN KEY(user_no) 		REFERENCES USER(user_no), 
	FOREIGN KEY(post_no)	 	REFERENCES POST(post_no)
);

# UNLIKES 테이블 (게시글 싫어요 여부)
CREATE TABLE UNLIKES (
	user_no			int NOT NULL,				# 싫어요 누른 회원 외래키
	post_no			int	NOT NULL,				# 싫어요 받은 게시글 외래키
    FOREIGN KEY(user_no) 		REFERENCES USER(user_no), 
	FOREIGN KEY(post_no)	 	REFERENCES POST(post_no)
);

# REPORT 테이블 (신고 여부)
CREATE TABLE REPORT (
	user_no			int NOT NULL,				# 신고 누른 회원 외래키
	post_no			int	NOT NULL,				# 신고 받은 게시글 외래키
    FOREIGN KEY(user_no) 		REFERENCES USER(user_no), 
	FOREIGN KEY(post_no)	 	REFERENCES POST(post_no)
);

# COMMENT 테이블
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

# RANKING 테이블
CREATE TABLE RANKING (
	cat_no			int,			# 고양이 번호 외래키
	user_no			int,			# 회원 번호 외래키
	rank_point		int,			# 점수
    FOREIGN KEY(cat_no) REFERENCES CAT(cat_no),
    FOREIGN KEY(user_no) REFERENCES USER(user_no)
);

```



2. 참고 내용

   https://elfinlas.github.io/2018/02/18/spring-parameter/

   [ **Spring에서 @RequestParam과 @PathVariable**Spring에서 Controller의 전달인자…Spring을 사용하다 보면 Controller 단에서 클라이언트에서 URL에 파라메터를 같이 전달하는 경우가 있습니다.주로 사용하는 형태는 아래의 두 가지가 대표적인 케이스입니다. Type 1 => http://127.0.0.1?index=1&page=2Type 2 => http://127elfinlas.github.io](https://elfinlas.github.io/2018/02/18/spring-parameter/)

   **Spring에서 Controller의 전달인자…**

   Spring을 사용하다 보면 Controller 단에서 클라이언트에서 URL에 파라메터를 같이 전달하는 경우가 있습니다.

   주로 사용하는 형태는 아래의 두 가지가 대표적인 케이스입니다.

   > *Type 1 =>* *http://127.0.0.1?index=1&page=2*
   >
   > *Type 2 =>* *http://127.0.0.1/index/1*

   **Type 1**의 경우 파라메터의 값과 이름을 함께 전달하는 방식으로 게시판 등에서 페이지 및 검색 정보를 함께 전달하는 방식을 사용할 때 많이 사용합니다.

   **Type 2**의 경우 Rest api에서 값을 호출할 때 주로 많이 사용합니다.

   Spring에서는 이러한 전달인자를 처리하는데 두 가지 방법을 제공합니다.

   

   **@RequestParam 사용하기**

   **Type 1**의 URL을 처리할 때 **@RequestParam**을 사용하게 됩니다.

   아래의 예제와 같이 Controller 단에서 사용합니다.

   | 12345 | @GetMapping("read")public ModelAndView getFactoryRead(@RequestParam("no") int factroyId, SearchCriteria criteria) {//... } |
   | ----- | ------------------------------------------------------------ |
   |       |                                                              |

   위의 경우 **/read?no=1**와 같이 url이 전달될 때 no 파라메터를 받아오게 됩니다.

   @RequestParam 어노테이션의 괄호 안의 경우 전달인자 이름(실제 값을 표시)입니다.

   

   이렇게 **@RequestParam**의 경우 url 뒤에 붙는 파라메터의 값을 가져올 때 사용을 합니다.

   

   **@PathVariable 사용하기**

   **Type 2**의 URL을 처리할 때는 **@PathVariable**을 사용하게 됩니다.

   | 12345 | @PostMapping("delete/{idx}")@ResponseBodypublic JsonResultVo postDeleteFactory(@PathVariable("idx") int factoryIdx) {return factoryService.deleteFacotryData(factoryIdx);} |
   | ----- | ------------------------------------------------------------ |
   |       |                                                              |

   위에 예제 코드처럼 **PathVariable**의 경우 url에서 각 구분자에 들어오는 값을 처리해야 할 때 사용합니다.

   

   **실제로 사용은?**

   물론 **@RequestParam** 또는 **@PathVariable** 하나만 사용하는 것이 아닌 복합적으로 사용을 하기도 합니다.

   | 123456 | @GetMapping("/user/{userIdx}/invoices")public List<Invoice> listUsersInvoices(@PathVariable("userIdx") int user,@RequestParam(value = "date", required = false) Date dateOrNull) { } |
   | ------ | ------------------------------------------------------------ |
   |        |                                                              |

   Spring에서는 HttpEntity란 클래스를 제공하는데 이 클래스의 역할은 Http 프로토콜을 이용하는 통신의 header와 body 관련 정보를 저장할수 있게끔 합니다..그리고 이를 상속받은 클래스로 RequestEntity와 ResponseEntity가 존재하죠..

   즉 통신 메시지 관련 header와 body의 값들을 하나의 객체로 저장하는 것이 HttpEntity 클래스 객체이고..Request 부분일 경우 HttpEntity를 상속받은 RequestEntity가, Response 부분일 경우 HttpEntity를 상속받은 ResponseEntity가 하게 됩니다.

   

   @ResponseBody나 ResponseEntity를 return 하는거나 결과적으로는 같은 기능이지만..그 구현 방법이 틀리죠..예를 들어 header 값을 변경시켜야 할 경우엔 @ResponseBody의 경우 파라미터로 Response 객체를 받아서 이 객체에서  header를 변경시켜야 하고..ResponseEntity에서는 이 클래스 객체를 생성한뒤 객체에서 header 값을 변경시키면 되죠..

   Spring API 문서를 보시면 이해하기 쉬워요..