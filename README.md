# 간단한 로그인 및 게시물 작성 기능 구현 연습 

## 프로젝트 구성
- 스프링 부트 2.5.0
- 자바 11
- 마이바티스 2.2.0
- 타임리프

## 간단한 기능 설명

1. **로그인 실패시 오류 메시지**
   - 로그인 실패시 `/login?error=invalidCredentials` 경로로 이동하여 오류 메시지를 표시합니다.

![캡처](https://github.com/sonincheon/BoardPractice/assets/142462485/4f7089f0-080b-4594-8655-bb699347114d)
![캡처5](https://github.com/sonincheon/BoardPractice/assets/142462485/fcd2e272-43be-4db3-95b2-5228f9dcbf1d)

2. **게시판 CRUD 기능**
   - 조회수 증가를 위해 `update` 쿼리를 활용합니다.
   - 게시물 작성, 조회, 수정, 삭제 기능을 제공합니다.
![캡처1](https://github.com/sonincheon/BoardPractice/assets/142462485/0763ab81-431f-4cfa-a912-0216a8dc7547)
![캡처3](https://github.com/sonincheon/BoardPractice/assets/142462485/5012524c-c510-4791-bd48-c834d156b003)
![캡처4](https://github.com/sonincheon/BoardPractice/assets/142462485/959b13b0-199a-4085-a9cd-d5dfc0e0bcd0)
## 프로젝트 구조

- **src/main/java**: 자바 소스 코드가 위치하는 디렉토리입니다.
- **src/main/resources**: 리소스 파일(마이바티스 매퍼, 정적 리소스, 프로퍼티 파일 등)이 위치하는 디렉토리입니다.
- **src/test**: 테스트 코드가 위치하는 디렉토리입니다.
- **pom.xml**: Maven 프로젝트 설정 파일입니다.

## SQL 테이블 생성 코드

```sql
 drop table if exists board_table;
 create table board_table
 (
	id bigint primary key auto_increment,
    boardTitle varchar(50),
    boardWriter varchar(20),
    boardPass varchar(20),
    boardContents varchar(500),
    boardHits int default 0,
    createdAt datetime default now(), 
    fileAttached int default 0
);

-- board_file_table
drop table if exists board_file_table;
create table board_file_table
(
    id	bigint auto_increment primary key,
    originalFileName varchar(100),
    storedFileName varchar(100),
    boardId bigint,
    constraint fk_board_file foreign key(boardId) references board_table(id) on delete cascade
);

drop table if exists member_table;
CREATE TABLE member_table (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);
