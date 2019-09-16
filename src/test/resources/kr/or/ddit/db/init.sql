--해당 테이블은 테스트 계정에만 있기 때문에
--개발자가 실수로 운영디비 설정을 사용해도 해당 sql이 정상적으로 실행되지 않으면서
--이후에 등장하는 sql들은 실행되지 않는다. populator.setContinueOnError(false);
select * from not_exists_in_prd;

--users 테이블 데이터 전체 지우기
--delete users;	-- 복구가 가능(아카이브 로그를 남긴다)
truncate table users; --복구가 불가능(아카이브 로그를 남기지 않는다)

Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME,REALFILENAME2) values ('brown','브라운브라운1','c6347b73d5b1f7c77f8be828ee3e871c819578f23779c7d5e082ae2b36a44',to_date('2019/09/25','YYYY/MM/DD'),'브라운테스트1','서울 강서구 마곡동로 30','ㄹㅈㄷㄹ','07805',null,null,null);
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME,REALFILENAME2) values ('cony','코니','c6347b73d5b1f7c77f8be828ee3e871c819578f23779c7d5e082ae2b36a44',to_date('0019/01/28','YYYY/MM/DD'),null,null,null,null,'cony.png','E:\picture\535d2599-4fb5-4fce-a514-11320de99aec',null);
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME,REALFILENAME2) values ('sally','샐리','c6347b73d5b1f7c77f8be828ee3e871c819578f23779c7d5e082ae2b36a44',to_date('0019/01/28','YYYY/MM/DD'),null,null,null,null,'sally.png','E:\picture\11fb49e3-f953-496d-8109-f2b7853b994d',null);
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME,REALFILENAME2) values ('james','제임스','b097f022d7879a164ea13dd63719e7a2af70c372d9139fc1d6443c6884e2f851',to_date('0019/01/28','YYYY/MM/DD'),null,null,null,null,'james.png','E:\picture\d52bad73-596b-4055-a7ed-3392adaa8f95',null);
Insert into USERS (USERID,USERNM,PASS,REG_DT,ALIAS,ADDR1,ADDR2,ZIPCODE,FILENAME,REALFILENAME,REALFILENAME2) values ('moon','문','7deff5c6fea2a1683b983bc5969afa759d13c5dc0d6dbd02c6f5bd091e06c',to_date('0019/01/28','YYYY/MM/DD'),null,null,null,null,'moon.png','E:\picture\957cadae-ead3-4763-90d6-53c53951d8fe',null);

commit;