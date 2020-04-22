prompt Loading MEMBER...
insert into MEMBER (id, name, nickname, phonenum, email)
values ('E61D65F673D54F68B0861025C69773DB', '张三', '小三', '18888888888', 'zs@163.com');
commit;

prompt Loading PRODUCT...
insert into PRODUCT (id, productnum, productname, cityname, departuretime, productprice, productdesc, productstatus)
values ('676C5BD1D35E429A8C2E114939C5685A', 'huaxin02', '北京三日游', '北京', to_timestamp('10-10-2018 10:10:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 1200, '不错的旅行奥', 1);
insert into PRODUCT (id, productnum, productname, cityname, departuretime, productprice, productdesc, productstatus)
values ('12B7ABF2A4C544568B0A7C69F36BF8B7', 'huaxin03', '上海五日游', '上海', to_timestamp('25-04-2018 14:30:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 1800, '魔都我来了奥', 1);
insert into PRODUCT (id, productnum, productname, cityname, departuretime, productprice, productdesc, productstatus)
values ('9F71F01CB448476DAFB309AA6DF9497F', 'huaxin04', '北京三日游', '北京', to_timestamp('10-10-2018 10:10:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 1200, '不错的旅行', 1);
insert into PRODUCT (id, productnum, productname, cityname, departuretime, productprice, productdesc, productstatus)
values ('CC6BC6E9496D4B8B9B52AB3A2DA2CDC5', 'huaxin01', '故宫三日游', '泰安', to_timestamp('05-01-2020 14:10:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 999, '领略故宫风采', 1);
insert into PRODUCT (id, productnum, productname, cityname, departuretime, productprice, productdesc, productstatus)
values ('28B5CA36C1EA4FF8A9BD65314197269C', 'huaxin05', '桂林游', '泰安出发', to_timestamp('04-01-2020 00:05:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 9999, '桂林山水甲天下啊', 1);
insert into PRODUCT (id, productnum, productname, cityname, departuretime, productprice, productdesc, productstatus)
values ('EC98DAFFF08B437FB2945258BED4D7EC', 'huaxin07', '上海迪士尼', '泰安潍坊', to_timestamp('26-01-2020 05:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 999, '你好迪士尼', 0);
insert into PRODUCT (id, productnum, productname, cityname, departuretime, productprice, productdesc, productstatus)
values ('CE32F9D6607E44FB98A022D3B4ECF3DF', 'huaxin08', '三亚1日游', '泰安出发', to_timestamp('25-01-2020 09:05:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 999, '物超所值奥', 1);
insert into PRODUCT (id, productnum, productname, cityname, departuretime, productprice, productdesc, productstatus)
values ('C31E5234F237413BB4DFCCEA8C633F0E', 'huaxin09', '孔庙', '潍坊', to_timestamp('31-01-2020 12:27:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 998, '只要998', 1);
insert into PRODUCT (id, productnum, productname, cityname, departuretime, productprice, productdesc, productstatus)
values ('B3A4FCD482C34315BF40E102B7CE6C6A', 'huaxin010', '济南宽厚里', '泰安', to_timestamp('31-01-2020 12:29:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 998, '敬请期待', 1);
insert into PRODUCT (id, productnum, productname, cityname, departuretime, productprice, productdesc, productstatus)
values ('DF9696ADEF28427EAF595155D310788D', 'huaxin011', '泰山三日游', '泰安', to_timestamp('31-01-2020 12:32:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 99911, '二次游玩价格更便宜奥', 1);
insert into PRODUCT (id, productnum, productname, cityname, departuretime, productprice, productdesc, productstatus)
values ('127B8AA5CA354D14BBB4FE4FB31F4F1D', 'huaxin012', '济南芙蓉街', '泰安', to_timestamp('17-01-2020 10:50:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 99, '好吃又好玩', 1);
insert into PRODUCT (id, productnum, productname, cityname, departuretime, productprice, productdesc, productstatus)
values ('C93DC96F6C5C4B4D92DA218A92AC1787', 'huaxin013', '北京天安门', '泰安', to_timestamp('31-01-2020 12:27:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 999, '领略北京风采', 1);
insert into PRODUCT (id, productnum, productname, cityname, departuretime, productprice, productdesc, productstatus)
values ('D4DF958D5E044E78BDB0F087A8B015C4', 'huaxin081', '西安', '泰安', to_timestamp('10-01-2020 10:45:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 999, '你好西安', 1);
commit;

prompt Loading ORDERS...
insert into ORDERS (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('0E7231DC797C486290E8713CA3C6ECCC', '12345', to_timestamp('02-03-2018 12:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 2, '没什么', 1, 1, '676C5BD1D35E429A8C2E114939C5685A', 'E61D65F673D54F68B0861025C69773DB');
insert into ORDERS (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('5DC6A48DD4E94592AE904930EA866AFA', '54321', to_timestamp('02-03-2018 12:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 2, '没什么', 0, 1, '676C5BD1D35E429A8C2E114939C5685A', 'E61D65F673D54F68B0861025C69773DB');
insert into ORDERS (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('2FF351C4AC744E2092DCF08CFD314420', '67890', to_timestamp('02-03-2018 12:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 2, '没什么', 0, 1, '12B7ABF2A4C544568B0A7C69F36BF8B7', 'E61D65F673D54F68B0861025C69773DB');
insert into ORDERS (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('A0657832D93E4B10AE88A2D4B70B1A28', '98765', to_timestamp('02-03-2018 12:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 2, '没什么', 0, 1, '12B7ABF2A4C544568B0A7C69F36BF8B7', 'E61D65F673D54F68B0861025C69773DB');
insert into ORDERS (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('E4DD4C45EED84870ABA83574A801083E', '11111', to_timestamp('02-03-2018 12:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 2, '没什么', 0, 1, '12B7ABF2A4C544568B0A7C69F36BF8B7', 'E61D65F673D54F68B0861025C69773DB');
insert into ORDERS (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('96CC8BD43C734CC2ACBFF09501B4DD5D', '22222', to_timestamp('02-03-2018 12:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 2, '没什么', 0, 1, '12B7ABF2A4C544568B0A7C69F36BF8B7', 'E61D65F673D54F68B0861025C69773DB');
insert into ORDERS (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('55F9AF582D5A4DB28FB4EC3199385762', '33333', to_timestamp('02-03-2018 12:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 2, '没什么', 0, 1, '9F71F01CB448476DAFB309AA6DF9497F', 'E61D65F673D54F68B0861025C69773DB');
insert into ORDERS (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('CA005CF1BE3C4EF68F88ABC7DF30E976', '44444', to_timestamp('02-03-2018 12:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 2, '没什么', 0, 1, '9F71F01CB448476DAFB309AA6DF9497F', 'E61D65F673D54F68B0861025C69773DB');
insert into ORDERS (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('3081770BC3984EF092D9E99760FDABDE', '55555', to_timestamp('02-03-2018 12:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 2, '没什么', 0, 1, '9F71F01CB448476DAFB309AA6DF9497F', 'E61D65F673D54F68B0861025C69773DB');
insert into ORDERS (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('CD74AF732C6A4422B4A2AAB813FC5654', '222229', to_timestamp('02-03-2018 12:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 2, '没什么', 0, 1, '12B7ABF2A4C544568B0A7C69F36BF8B7', 'E61D65F673D54F68B0861025C69773DB');
insert into ORDERS (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('5BA287BAB45A4A5895E39E77C6DD0DC7', '222225', to_timestamp('02-03-2018 12:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 2, '没什么', 0, 1, '12B7ABF2A4C544568B0A7C69F36BF8B7', 'E61D65F673D54F68B0861025C69773DB');
insert into ORDERS (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('307CEF03ACDE4DCDA3D3F7F16204DD20', '2222254', to_timestamp('02-03-2018 12:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 2, '没什么', 0, 1, '12B7ABF2A4C544568B0A7C69F36BF8B7', 'E61D65F673D54F68B0861025C69773DB');
commit;

prompt Loading TRAVELLER...
insert into TRAVELLER (id, name, sex, phonenum, credentialstype, credentialsnum, travellertype)
values ('3FE27DF2A4E44A6DBC5D0FE4651D3D3E', '张龙', '男', '13333333333', 0, '123456789009876543', 0);
insert into TRAVELLER (id, name, sex, phonenum, credentialstype, credentialsnum, travellertype)
values ('EE7A71FB6945483FBF91543DBE851960', '张小龙', '男', '15555555555', 0, '987654321123456789', 1);
commit;

prompt Loading ORDER_TRAVELLER...
insert into ORDER_TRAVELLER (orderid, travellerid)
values ('0E7231DC797C486290E8713CA3C6ECCC', '3FE27DF2A4E44A6DBC5D0FE4651D3D3E');
insert into ORDER_TRAVELLER (orderid, travellerid)
values ('2FF351C4AC744E2092DCF08CFD314420', '3FE27DF2A4E44A6DBC5D0FE4651D3D3E');
insert into ORDER_TRAVELLER (orderid, travellerid)
values ('3081770BC3984EF092D9E99760FDABDE', 'EE7A71FB6945483FBF91543DBE851960');
insert into ORDER_TRAVELLER (orderid, travellerid)
values ('55F9AF582D5A4DB28FB4EC3199385762', 'EE7A71FB6945483FBF91543DBE851960');
insert into ORDER_TRAVELLER (orderid, travellerid)
values ('5DC6A48DD4E94592AE904930EA866AFA', '3FE27DF2A4E44A6DBC5D0FE4651D3D3E');
insert into ORDER_TRAVELLER (orderid, travellerid)
values ('96CC8BD43C734CC2ACBFF09501B4DD5D', 'EE7A71FB6945483FBF91543DBE851960');
insert into ORDER_TRAVELLER (orderid, travellerid)
values ('A0657832D93E4B10AE88A2D4B70B1A28', '3FE27DF2A4E44A6DBC5D0FE4651D3D3E');
insert into ORDER_TRAVELLER (orderid, travellerid)
values ('CA005CF1BE3C4EF68F88ABC7DF30E976', 'EE7A71FB6945483FBF91543DBE851960');
insert into ORDER_TRAVELLER (orderid, travellerid)
values ('E4DD4C45EED84870ABA83574A801083E', 'EE7A71FB6945483FBF91543DBE851960');
commit;

prompt Loading PERMISSION...
insert into PERMISSION (id, permissionname, url)
values ('84E59695A07249989B3253FFD634C039', 'SELECT', '/**');
insert into PERMISSION (id, permissionname, url)
values ('1C388C636290431D993FD4F4F8F3A234', 'INSERT', '/**');
insert into PERMISSION (id, permissionname, url)
values ('DD04EB14CD214A7E95BF6A462CA92309', 'UPDATE', '/**');
insert into PERMISSION (id, permissionname, url)
values ('DF4BC2D19B5041A2B20F0E8B01CDF718', 'DELETE', '/**');
commit;

prompt Loading ROLE...
insert into ROLE (id, rolename, roledesc)
values ('333C5990C9B947C5BC3127A11474143E', 'ORDINARY', 'VIP');
insert into ROLE (id, rolename, roledesc)
values ('C48E2F2BA91D49CBAB10429E4EA196E1', 'ADMIN', 'SVIP');
insert into ROLE (id, rolename, roledesc)
values ('4199269DDCB547AF84280D436E493D54', 'USER', 'SVIP');
commit;

prompt Loading ROLE_PERMISSION...
insert into ROLE_PERMISSION (permissionid, roleid)
values ('1C388C636290431D993FD4F4F8F3A234', '4199269DDCB547AF84280D436E493D54');
insert into ROLE_PERMISSION (permissionid, roleid)
values ('1C388C636290431D993FD4F4F8F3A234', 'C48E2F2BA91D49CBAB10429E4EA196E1');
insert into ROLE_PERMISSION (permissionid, roleid)
values ('84E59695A07249989B3253FFD634C039', '333C5990C9B947C5BC3127A11474143E');
insert into ROLE_PERMISSION (permissionid, roleid)
values ('84E59695A07249989B3253FFD634C039', '4199269DDCB547AF84280D436E493D54');
insert into ROLE_PERMISSION (permissionid, roleid)
values ('84E59695A07249989B3253FFD634C039', 'C48E2F2BA91D49CBAB10429E4EA196E1');
insert into ROLE_PERMISSION (permissionid, roleid)
values ('DD04EB14CD214A7E95BF6A462CA92309', '4199269DDCB547AF84280D436E493D54');
insert into ROLE_PERMISSION (permissionid, roleid)
values ('DD04EB14CD214A7E95BF6A462CA92309', 'C48E2F2BA91D49CBAB10429E4EA196E1');
insert into ROLE_PERMISSION (permissionid, roleid)
values ('DF4BC2D19B5041A2B20F0E8B01CDF718', '4199269DDCB547AF84280D436E493D54');
insert into ROLE_PERMISSION (permissionid, roleid)
values ('DF4BC2D19B5041A2B20F0E8B01CDF718', 'C48E2F2BA91D49CBAB10429E4EA196E1');
commit;

prompt Loading SYSLOG...
insert into SYSLOG (id, visittime, username, ip, url, executiontime, method)
values ('2024D623F80F4D40B280EC901D835AF6', to_timestamp('04-04-2020 19:45:48.181000', 'dd-mm-yyyy hh24:mi:ss.ff'), '孙启新', '0:0:0:0:0:0:0:1', '/user/findAllUser', 15, '[类] controller.UserController [方法] findAllUser');
insert into SYSLOG (id, visittime, username, ip, url, executiontime, method)
values ('FD029A92E55F452AACE35A6C421B3F62', to_timestamp('04-04-2020 19:44:19.094000', 'dd-mm-yyyy hh24:mi:ss.ff'), '孙启新', '0:0:0:0:0:0:0:1', '/permission/findAllPermission', 222, '[类] controller.PermissionController [方法] findAllPermission');
insert into SYSLOG (id, visittime, username, ip, url, executiontime, method)
values ('641F2D783E0340589337AC45448EDC10', to_timestamp('04-04-2020 19:45:49.474000', 'dd-mm-yyyy hh24:mi:ss.ff'), '孙启新', '0:0:0:0:0:0:0:1', '/user/findUserByIdAndAllRole', 21, '[类] controller.UserController [方法] findUserByIdAndAllRole');
commit;

prompt Loading USERS...
insert into USERS (id, email, username, password, phonenum, status)
values ('D602EC502DEF496E888C1DEBF3872EBA', '111@itcast.cn', 'huaxin', '$2a$10$eRF36z9SeSbfTH5.h1Br4uZLPQUgz7oAzJS7moMCbz8/C4ipLN6Cm', '12345678', 1);
insert into USERS (id, email, username, password, phonenum, status)
values ('BC15081D2245416186A5327AD54A2593', '869872@163.com11', '15153869872', '$2a$10$1fAybACANnk/nQIORdQkfuM/IQnNj0AinVH8RY2jU3BzW8Sx4olwK', '12345678', 1);
insert into USERS (id, email, username, password, phonenum, status)
values ('8A7104A8ACC1455092AA67152E88ED1F', '826552197@qq.com', 'admin', '$2a$10$ep6iYdkFreKagXtovX8vBuVkNcIVGYF8JUsw/o.aDoMTKZNmm74Y2', '12345678', 1);
insert into USERS (id, email, username, password, phonenum, status)
values ('833EEE163BBB47AB8C4C97EDD79D9969', '15153869872@163.com', '孙启新', '$2a$10$YZ2TSNuh5ULgfUG9oxpV6eTeidRl3T.c6mwsMQBJFnuHdYwG2JYNa', '15153869872', 1);
commit;

prompt Loading USERS_ROLE...
insert into USERS_ROLE (userid, roleid)
values ('833EEE163BBB47AB8C4C97EDD79D9969', '333C5990C9B947C5BC3127A11474143E');
insert into USERS_ROLE (userid, roleid)
values ('833EEE163BBB47AB8C4C97EDD79D9969', '4199269DDCB547AF84280D436E493D54');
insert into USERS_ROLE (userid, roleid)
values ('833EEE163BBB47AB8C4C97EDD79D9969', 'C48E2F2BA91D49CBAB10429E4EA196E1');
insert into USERS_ROLE (userid, roleid)
values ('8A7104A8ACC1455092AA67152E88ED1F', '333C5990C9B947C5BC3127A11474143E');
insert into USERS_ROLE (userid, roleid)
values ('8A7104A8ACC1455092AA67152E88ED1F', '4199269DDCB547AF84280D436E493D54');
insert into USERS_ROLE (userid, roleid)
values ('8A7104A8ACC1455092AA67152E88ED1F', 'C48E2F2BA91D49CBAB10429E4EA196E1');
insert into USERS_ROLE (userid, roleid)
values ('BC15081D2245416186A5327AD54A2593', '333C5990C9B947C5BC3127A11474143E');
insert into USERS_ROLE (userid, roleid)
values ('D602EC502DEF496E888C1DEBF3872EBA', '333C5990C9B947C5BC3127A11474143E');
commit;
