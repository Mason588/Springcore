-- 建立 Emp 資料表
create table if not exists emp(
	eid int not null auto_increment, -- 主鍵(自動產生序號:1,2,3 過號不返回)
	ename varchar(50) not null unique, -- 員工姓名
	age int, -- 員工年齡
	createtime timestamp default current_timestamp, -- 建檔時間
	primary key(eid)
)

-- 建立 Job 資料表
create table if not exists job(
	jid int not null auto_increment, -- 主鍵(自動產生序號:1,2,3 過號不返回)
	jname varchar(50) not null unique, -- 工作名稱
	eid int, -- 員工 id
	age int, -- 員工年齡
	primary key(jid),
	foreign key(eid) references emp(eid) -- 外鍵約束
)

-- 由上述可知，一個 emp 對應多個job，一個job對應一個 emp
