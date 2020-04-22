--------------------------------------------
-- Export file for user ADMIN             --
-- Created by x3626 on 2020/4/8, 20:23:55 --
--------------------------------------------

set define off
spool tourism_backstore.log

prompt
prompt Creating table MEMBER
prompt =====================
prompt
create table MEMBER
(
  id       VARCHAR2(32) default SYS_GUID() not null,
  name     VARCHAR2(20),
  nickname VARCHAR2(20),
  phonenum VARCHAR2(20),
  email    VARCHAR2(20)
)
;
alter table MEMBER
  add primary key (ID);

prompt
prompt Creating table PRODUCT
prompt ======================
prompt
create table PRODUCT
(
  id            VARCHAR2(32) default SYS_GUID() not null,
  productnum    VARCHAR2(50) not null,
  productname   VARCHAR2(50),
  cityname      VARCHAR2(50),
  departuretime TIMESTAMP(6),
  productprice  NUMBER,
  productdesc   VARCHAR2(500),
  productstatus INTEGER
)
;
alter table PRODUCT
  add primary key (ID);
alter table PRODUCT
  add constraint PRODUCT unique (ID, PRODUCTNUM);

prompt
prompt Creating table ORDERS
prompt =====================
prompt
create table ORDERS
(
  id          VARCHAR2(32) default SYS_GUID() not null,
  ordernum    VARCHAR2(20) not null,
  ordertime   TIMESTAMP(6),
  peoplecount INTEGER,
  orderdesc   VARCHAR2(500),
  paytype     INTEGER,
  orderstatus INTEGER,
  productid   VARCHAR2(32),
  memberid    VARCHAR2(32)
)
;
alter table ORDERS
  add primary key (ID);
alter table ORDERS
  add unique (ORDERNUM);
alter table ORDERS
  add foreign key (PRODUCTID)
  references PRODUCT (ID);
alter table ORDERS
  add foreign key (MEMBERID)
  references MEMBER (ID);

prompt
prompt Creating table TRAVELLER
prompt ========================
prompt
create table TRAVELLER
(
  id              VARCHAR2(32) default SYS_GUID() not null,
  name            VARCHAR2(20),
  sex             VARCHAR2(20),
  phonenum        VARCHAR2(20),
  credentialstype INTEGER,
  credentialsnum  VARCHAR2(50),
  travellertype   INTEGER
)
;
alter table TRAVELLER
  add primary key (ID);

prompt
prompt Creating table ORDER_TRAVELLER
prompt ==============================
prompt
create table ORDER_TRAVELLER
(
  orderid     VARCHAR2(32) not null,
  travellerid VARCHAR2(32) not null
)
;
alter table ORDER_TRAVELLER
  add primary key (ORDERID, TRAVELLERID);
alter table ORDER_TRAVELLER
  add foreign key (ORDERID)
  references ORDERS (ID);
alter table ORDER_TRAVELLER
  add foreign key (TRAVELLERID)
  references TRAVELLER (ID);

prompt
prompt Creating table PERMISSION
prompt =========================
prompt
create table PERMISSION
(
  id             VARCHAR2(32) default SYS_GUID() not null,
  permissionname VARCHAR2(50),
  url            VARCHAR2(50)
)
;
alter table PERMISSION
  add primary key (ID);

prompt
prompt Creating table ROLE
prompt ===================
prompt
create table ROLE
(
  id       VARCHAR2(32) default SYS_GUID() not null,
  rolename VARCHAR2(50),
  roledesc VARCHAR2(50)
)
;
alter table ROLE
  add primary key (ID);

prompt
prompt Creating table ROLE_PERMISSION
prompt ==============================
prompt
create table ROLE_PERMISSION
(
  permissionid VARCHAR2(32) not null,
  roleid       VARCHAR2(32) not null
)
;
alter table ROLE_PERMISSION
  add primary key (PERMISSIONID, ROLEID);
alter table ROLE_PERMISSION
  add foreign key (PERMISSIONID)
  references PERMISSION (ID);
alter table ROLE_PERMISSION
  add foreign key (ROLEID)
  references ROLE (ID);

prompt
prompt Creating table SYSLOG
prompt =====================
prompt
create table SYSLOG
(
  id            VARCHAR2(32) default SYS_GUID() not null,
  visittime     TIMESTAMP(6),
  username      VARCHAR2(50),
  ip            VARCHAR2(30),
  url           VARCHAR2(50),
  executiontime INTEGER,
  method        VARCHAR2(200)
)
;
alter table SYSLOG
  add primary key (ID);

prompt
prompt Creating table USERS
prompt ====================
prompt
create table USERS
(
  id       VARCHAR2(32) default SYS_GUID() not null,
  email    VARCHAR2(50) not null,
  username VARCHAR2(50),
  password VARCHAR2(70),
  phonenum VARCHAR2(20),
  status   INTEGER
)
;
alter table USERS
  add primary key (ID);
alter table USERS
  add unique (EMAIL);

prompt
prompt Creating table USERS_ROLE
prompt =========================
prompt
create table USERS_ROLE
(
  userid VARCHAR2(32) not null,
  roleid VARCHAR2(32) not null
)
;
alter table USERS_ROLE
  add primary key (USERID, ROLEID);
alter table USERS_ROLE
  add foreign key (USERID)
  references USERS (ID);
alter table USERS_ROLE
  add foreign key (ROLEID)
  references ROLE (ID);


spool off
