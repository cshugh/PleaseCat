# PJT_Front


## Front 과정

- 기능별 Branch 에서 **개발 완성** 후 상위 Branch 에 적용하는 방법
  
  - ex) 현재 작업 Branch가 "front_bar" 일 경우
  
<<<<<<< HEAD
  1. 로컬 *Branch* 에서의 수정사항을 **Commit** 후 HEAD를 상위 *Branch*로 이동
     - HEAD: front_bar
     - git add -> git commit -> git checkout front
  2. 상위 *Branch*의 현재까지 최종본을 **Pull** 한 후 다시 하위 기능 *Branch*로 이동
     - HEAD: front
     - git pull -> git checkout front_bar
  3. 상위 *Branch*의 최종본을 나의 현재 작업 *Branch*에 **Merge**시킨 후 *Remote*의 나의 작업 *Branch* 로 **Push**
     - HEAD: front_bar
     - git merge front -> git push origin front_bar
  4. https://lab.ssafy.com/ 에서 **merge request** 하기
     - [Create merge request]
     - Merge의 목적지의 default 값이 master 로 설정되어 있으므로 목적지를 상위 Branch인 front로 수정한다
       - [Change branches]
     - Merge하는 이유, 즉 업데이트 내용을 작성
     - [Submit merge request]
     - Maintainer 의 승인을 기다린다
  
=======
  1. HEAD: front_bar,
     git add -> git commit -> git checkout front
     - 로컬 *Branch*에 수정사항을 **Commit** 후 HEAD를 상위 *Branch*로 이동
  2. HEAD: front, git pull -> git checkout front_bar
     - 상위 *Branch*의 현재까지 최종본을 **Pull** 한 후 다시 하위 기능 *Branch*로 이동
  3. HEAD: front_bar, git merge front -> git push origin front_bar
     - 상위 *Branch*의 최종본을 나의 현재 작업 *Branch*에 **Merge**시킨 후 *Remote*의 나의 작업 *Branch* 로 **Push**
  4. 나의 작업 *Branch*의 기능이 완성되었다면 상위 *Branch*로 추가 생성 및 수정 사항에 대해
      코멘트를 달아서 (Pull) **Request**

>>>>>>> master
- 2020-01-22 Wed
  
  - 공통
    - Front 개발환경 구축 및 Git 업로드
  - front_list
    - 저는 list입니다
