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
        skin_disease		boolean		,	# 피부병 여부
        cat_location		varchar(100),	# 고양이 위치
        cat_manager			varchar( 50),	# 고양이 관리자 회원번호
        neuter				boolean		,	# 중성화 여부
        cat_desc			varchar(300),	# 고양이 소개
        hurt				boolean		,	# 상처 여부
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


