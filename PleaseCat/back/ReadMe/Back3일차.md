git add .

git commit -m "메시지"

git push origin master(또는 브랜치명)

git branch backTmp origin/back (이렇게 해야 back브랜치에서 또 브랜치가 나오는것)







[회원]

\- 회원이메일을 통해 검색

\- 회원관리번호를 통해 검색

\- 회원정보 insert (회원가입)

\- 회원정보 삭제 (회원관리로 검색 후 삭제)

\- 회원 로그인 (이메일로 검색해서 로그인)

\- 모든 회원 목록 출력



[고양이]

\- 모든 고양이 목록 출력

\- 고양이 관리번호로 검색

\- 고양이 삭제

\- 고양이 등록

\- 고양이 정보수정



[게시물]

\- 회원번호로 게시물검색

\- 고양이번호로 게시물검색

\- 게시물번호로 게시물검색

\- 게시물 전체목록 출력

\- 게시물 등록

\- 게시물 삭제

\- 게시물 수정

: 내용만 수정



[댓글]

\- 댓글 번호로 검색

\- 댓글 회원번호로 검색

\- 댓글 게시물 번호로 검색

\- 댓글 생성

\- 댓글 삭제

\- 댓글 수정 : content만 수정가능하게 함



[좋아요여부]

\- 회원번호와 게시글번호로 좋아요있는지 없는지 찾기

\- 회원번호와 게시글번호로 좋아요 실행

\- 회원번호와 게시글번호로 좋아요 취소

https://opens.kr/19

[![img](https://dthumb-phinf.pstatic.net/?src=%22https%3A%2F%2Ft1.daumcdn.net%2Ftistory_admin%2Fstatic%2Fimages%2FopenGraph%2Fopengraph.png%22&type=ff500_300)](https://opens.kr/19)[**[MyBatis\] parameterType HashMap 관련 예시(다중파라미터)**1. 기존 parameterType="String" 파라미터 한개로 처리 UserInfoMapper.java public interface UserInfoMapper { public UserInfo getUserInfo(String userId); } UserInfoMapper.xml 

Spring에서는 HttpEntity란 클래스를 제공하는데 이 클래스의 역할은 Http 프로토콜을 이용하는 통신의 header와 body 관련 정보를 저장할수 있게끔 합니다..그리고 이를 상속받은 클래스로 RequestEntity와 ResponseEntity가 존재하죠..

즉 통신 메시지 관련 header와 body의 값들을 하나의 객체로 저장하는 것이 HttpEntity 클래스 객체이고..Request 부분일 경우 HttpEntity를 상속받은 RequestEntity가, Response 부분일 경우 HttpEntity를 상속받은 ResponseEntity가 하게 됩니다..

@ResponseBody나 ResponseEntity를 return 하는거나 결과적으로는 같은 기능이지만..그 구현 방법이 틀리죠..예를 들어 header 값을 변경시켜야 할 경우엔 @ResponseBody의 경우 파라미터로 Response 객체를 받아서 이 객체에서  header를 변경시켜야 하고..ResponseEntity에서는 이 클래스 객체를 생성한뒤 객체에서 header 값을 변경시키면 되죠..

Spring API 문서를 보시면 이해하기 쉬워요..



ALTER TABLE `pleasecat`.`report` 

ADD PRIMARY KEY (`user_no`, `post_no`);   // 복합키 설정