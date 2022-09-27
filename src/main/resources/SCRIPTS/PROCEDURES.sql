drop procedure insertuserwow
create procedure insertuserwow(in p_name varchar(255),
								   in p_nickname varchar(255),
								   in p_pass char(6),
								   in p_class varchar(255),
								   in p_spec varchar(255),
								   in p_lvl char(2),
								   in enable int)
	begin
		declare countuserwow int default 0;
		select count(*) into countuserwow from userswow where nickname=p_nickname;
		
		if(countuserwow > 0) then
			select 'usuario ya existe';
		else
			insert into userswow (name,nickname,pass,class,spec,lvl,enable)
			values (p_name,p_nickname,p_pass,p_class,p_spec,p_lvl,enable);
		end if;
	end
	
create procedure getAllUssers()
begin
	select*from userswow;
end

 
	
	
	