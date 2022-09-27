show tables;
/*crear tabla*/
create table userswow(
	
	id int,
	name  varchar(255),
	nickname varchar(255),
	pass char(6),
	class varchar(255),
	spec varchar(255),
	lvl char(2),
	enable int	
)


alter table userswow add primary key (id);

alter table	userswow modify column id int auto_increment not null;

/*insertar*/
insert into userswow(name,nickname,pass,class,spec,lvl,enable)
values('Kevin','Vladikk','123456','Paladin','Protection','60',1);

insert into userswow(name,nickname,pass,class,spec,lvl,enable)
values('juan','PowerShoot','123456','Hunter','Survival','60',1);

select * from userswow

delete FROM userswow
WHERE nickname = 'PowerShoot'
