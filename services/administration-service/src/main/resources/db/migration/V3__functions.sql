create extension if not exists pgcrypto; --I don't know why, but without this crypt function doesn't work

insert into person(person_id, name, paternal_surname, maternal_surname, email, password)
values(1, 'Eduardo', 'Martínez', 'García', 'edu4r@gmail.com',
    crypt('i_h4t3_ni', gen_salt('md5'))) on conflict(person_id) do nothing;

create or replace function login(_email varchar(100), _password varchar(50))
returns table(
	wrongPassword boolean,
	personId integer,
    isActive boolean
) as $$
declare
    stored_hash varchar;
	_person_id integer;
    _is_active boolean;
begin
	select Person.password, Person.person_id, Person,is_active
	into stored_hash, _person_id, _is_active from Person where Person.email = _email;
	if not found then --User not found
		return query select true, -1, false;
		return;
	end if;

	select 1 from Person where Person.email = _email and stored_hash = crypt(_password, stored_hash);

	if not found then --User found but wrong password
		return query select true, _person_id, _is_active;
		return;
	end if;

	return query select false, _person_id, _is_active;

end;
$$ language plpgsql;