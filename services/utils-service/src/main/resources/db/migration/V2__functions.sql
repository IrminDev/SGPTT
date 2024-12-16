create extension if not exists pgcrypto; 

create or replace function login(_email varchar(100), _password varchar(50))
returns table(
	wrongPassword boolean,
	personId integer
) as $$
declare
    stored_hash varchar;
	_person_id integer;
    exist boolean;
begin
	select Person.password, Person.person_id
	into stored_hash, _person_id from Person where Person.email = _email;
	if not found then --User not found
		return query select true, -1;
		return;
	end if;

	select exists(select 1 from Person where Person.email = _email and stored_hash = crypt(_password, stored_hash)) into exist;

	if not exist then --User found but wrong password
		return query select true, _person_id;
		return;
	end if;

	return query select false, _person_id;

end;
$$ language plpgsql;

CREATE OR REPLACE FUNCTION update_sinodal_is_active()
RETURNS TRIGGER AS $$
BEGIN
    IF NEW.state_id = (SELECT state_id FROM ProtocolState WHERE name = 'Rechazado') OR
       NEW.state_id = (SELECT state_id FROM ProtocolState WHERE name = 'Finalizado') THEN
        UPDATE Sinodal
        SET is_active = false
        WHERE protocol_id = NEW.protocol_id;
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;
--s
CREATE TRIGGER protocol_state_change
AFTER UPDATE OF state_id ON Protocol
FOR EACH ROW
EXECUTE FUNCTION update_sinodal_is_active();