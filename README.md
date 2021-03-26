# news

## 목적
* 네이버 뉴스 서비스의 백엔드 시스템을 직접 구현해보며  
스프링 부트 개념(의존성 관리, application 설정파일 등),  
스프링 개념(IoC 컨테이너, AOP, PSA),  
표준 스펙 개념(유효성 검사, RESTful API 등),  
서비스 관련 개념(세션, 캐시, 메일 등),  
운영환경의 앱 배포(AWS)를 이해  
* 가독성과 유지보수성이 높은 코드를 작성
* Git으로 Issue 단위별 branch 발행 및 Pull Request를 통해 협업간 정보공유력 커뮤니케이션 능력 향상 

## 기획
* 사용자의 성향과 관심사를 고려해 여러 언론사의 기사를 헤드라인, 조회수, 섹션, 언론사와 같은 기준으로 구분 제공
  * 헤드라인
    - 각 언론사별 기사를 취합해 가장 많이 등장한 단어 검수
    - 해당되는 기사 1개를 무작위로 선택해 헤드라인 중에서도 가장 크게 표시
    - 나머지 남은 기사 중에서도 3개를 무작위로 선택해 표시
    - 무작위 선택된 당일 기사들만 매일 DB에 저장하고 DB 관리를 위해 매일 자정 초기화
  * 섹션은 총 7개로 뉴스홈, 정치, 경제, 사회, 생활/문화, 세계, IT/과학이 있음
  * 언론사는 총 12개로 AA, BB, CC, DD, EE, FF, GG, HH, II, JJ, KK, LL가 있음
* 단어 포함 검색으로 원하는 기사를 볼 수 있도록 제공
* 네이버, 다음 등의 포털 기반의 뉴스사이트에서 접하기 어려운 지역 언론사의 기사들은 공공데이터를 활용해 보완
* 이 서비스는 한국을 대상으로 함
* 회원수 5만명, 최대 트래픽 규모는 분단위 액세스 약 1000회, DB 서버(MySQL) 1대, 로그인 세션 클러스터링 처리를 위한 Redis 서버(서버 다중화인 Replication도 고려)

* 기자들에게는 기사를 관리할 수 있도록 별도의 기자 전용 웹 페이지를 제공
  * 본인 작성 기사를 게시판 형식으로 조회하는 페이지
  * 기사글 수정/삭제 페이지

[공공데이터 참고 사이트](https://www.data.go.kr/data/15034926/openapi.do)

[프로토타입 (ovenapp 활용)](https://ovenapp.io/view/wp8c3hZx9oYXGnwD4AWbaX0Zz3NKWFxw/)

## Specification
- Java 8
- Spring Boot 2.4.1
- MyBatis 3.5.6
- MySQL 8.0.22
- Redis _? (AWS EC2에 설치 후 기입)_
- 이메일 송신 서버 gmail SMTP
- AWS EC2 t2.micro 인스턴스 1대
- Lombok 1.18.16

## Use Case
https://github.com/HwangWonGyu/news/wiki/Use-Case

## Git

[git commit 메시지 컨벤션](https://beststar-1.tistory.com/11)

[git pull request 컨벤션 참고 사이트](https://github.blog/2015-01-21-how-to-write-the-perfect-pull-request/)

PR을 시작하는 법
* PR의 목적을 한문장으로 요약하기
* PR을 생성하게된 맥락이 있는데 이를 리뷰어가 알아야 한다면 함께 명시
* 피드백 받기를 원하는 시점을 명시
* 요청한 PR이 작업중이라면 리뷰어들이 알 수 있도록 '작업중' 혹은 'WIP(Work In Progress)' 라고 기재
* 원하는 피드백의 방향과 내용을 리뷰어가 알 수 있도록 명시
* 짧은 답변이라도 어조를 명확히 하기 위해 이모지 사용

피드백에 응답하는 방법
* 피드백에 대한 감사의 표현
* 이해가 안됐을 경우 리뷰어에게 명확히 표현 할 수 있도록 이끌어내기
* 문제 해결법 피드백에 대한 응답이라면 그 해결법에 도달하기 위해 내린 결정에 대해 설명
* 최대한 모든 피드백에 대해 응답
* 혼란이나 논쟁이 증가하고 있다면 쓰여진 단어가 의사소통에 좋은건지 검토
* 항상 코멘트로 해결하기 보다는 화상회의나 오프라인 토론 후 요약글을 게시하는 것도 고려

## DB ERD
![ERD](https://user-images.githubusercontent.com/15853498/102389829-02c7b500-4017-11eb-8fbd-775686c1af80.PNG)
