# :laughing:Project : Finance  
DESC : 국내 코스피, 코스닥, 선물 시간별 체결가를 수집하여 그래프로 제공 
       
### :star:1.Use Tools  
+ Language&Library : JAVA, JSoup, Mybatis, Oracle, sql  
+ IDE : SqlDeveloper  
+ Framework : Spring  

### :star:2.Process Logic  
**1. 네이버 금융 코스닥, 코스피, 선물 체결시간, 체결가 수집**    
**2. DB에 3가지 테이블로 저장**    
**3. 사용자에게 그래프로 화면 출력(진행중)**    

       
### :star:3.File 설명(Package 및 Class)  
**1. controller : controller단들이 모여있는 패키지**  
 + IndexController.java : '/'로 DB 결과를 index페이지에 출력
 
**2. service : service단들이 모여있는 패키지**  
 + FinanceService.java : finance 비즈니스 로직 실행 (데이터 크롤링, DAO 연결)  
 
**3. domain : DTO들이 모여있는 패키지**  
 + FinanceDTO.java : 가격수집 데이터를 Oracle DB에서 꺼내올때 사용하는 DTO  
 
**4. persistence : DAO들이 모여있는 패키지**  
 + FinanceDAO.java : 가격수집 데이터를 oracle DB에 저장, 가져올때 사용하는 DAO
 
