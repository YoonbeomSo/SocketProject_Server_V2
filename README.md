# 참고사항

- Json 데이터 형식을 쓴 이유
  - ChatBot ver.1 에서 `readline()` 메소드 사용 시 하나의 라인씩 주고받게 되어있음
  - 단순히 데이터를 주고받기엔 무리가 없으나, 복잡한 과정의 로직처리 무리
  - <u>json 형식 문자열</u> 으로 보내서 파싱 후 처리하는 방향으로 바꿈
  

- 클라이언트 구조 바꾼 이유
  - server를 SpringMVC 방식처럼 구조화 목표
  - ChatBot ver.1 은  web 처럼 url 형태의 request 가 아님
  - 클라이언트에서 몇가지 선택을 강제하고 `route` 를 json 객체에 넣어서 보냄으로써 서버에서 그에 맞는 컨트롤러의 `process` 실행 가능
  

- Client <-> Server 간 통신 시 해당 <u>json형식의 문자열</u>로 데이터를 주고 받음
     
    ```json
    {
      "route" : "memberForm",
      "screenName" : "loginForm",
      "member" : {
        "mno" :  "data",
        "id" :  "data",
        "password" :  "data",
        "name" :  "data",
        "mobile" :  "data"
      },
      "reservation" : {
          "data" :  "data",
          "resPeople" : "data",
          "stno" :  "data",
          "mno" : "data"
      },
      "render" : {
          "1" : "로그인",
          "2" : "회원가입"
      },
      "requestParam" : {
          "id" : "admin"
      },
      "errorMessage" : "이미 등록된 회원 아이디 입니다.",
      "successMessage" : "회원 가입이 완료되었습니다."
    }
    ```
    - `route` Client 의 선택에 따라 이후 Server 측에서 route 별로 각각 컨트롤러의 process 실행(다형성) - <u>Client 측에서 생성</u>
    - `screenName` Server process 이후 Client 측에 보여질 화면 키워드 - <u>Server 측에서 생성</u>
    - `member` MemberDTO 객체, service 로직에 사용
    - `reservation` ReservationDTO 객체, service 로직에 사용
    - `render` Client 에서 보여질 Data -  <u>Server 측에서 생성</u>
    - `requestParam` Client 입력값 - <u>Client 측에서 생성</u>
    - `errorMessage` requestParam 유효성이 잘못되었거나 DB 작업 중 발생한 에러메시지 입력하여 Client 측에 보여줌 
    



