CREATE EXTENSION IF NOT EXISTS pgcrypto;

CREATE OR REPLACE FUNCTION login(_email VARCHAR(100), _password VARCHAR(50))
RETURNS TABLE(
    wrongPassword BOOLEAN,
    personId INTEGER
) AS $$
DECLARE
    stored_hash VARCHAR;
    _person_id INTEGER;
    exist BOOLEAN;
BEGIN
    SELECT Person.password, Person.person_id
    INTO stored_hash, _person_id
    FROM Person
    WHERE Person.email = _email;

    IF NOT FOUND THEN -- User not found
        RETURN QUERY SELECT TRUE, -1;
        RETURN;
    END IF;

    SELECT EXISTS(
        SELECT 1
        FROM Person
        WHERE Person.email = _email AND stored_hash = crypt(_password, stored_hash)
    ) INTO exist;

    IF NOT exist THEN -- User found but wrong password
        RETURN QUERY SELECT TRUE, _person_id;
        RETURN;
    END IF;

    RETURN QUERY SELECT FALSE, _person_id;
END;
$$ LANGUAGE plpgsql;

DROP TRIGGER IF EXISTS protocol_state_change ON Protocol;

CREATE OR REPLACE FUNCTION update_sinodal_is_active()
RETURNS TRIGGER AS $$
BEGIN
    IF (NEW.state_id IN (
        SELECT state_id FROM ProtocolState WHERE name IN ('Rechazado', 'Finalizado')
    )) THEN
UPDATE Sinodal
SET is_active = false
WHERE protocol_id = NEW.protocol_id;
END IF;

RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER protocol_state_change
    AFTER UPDATE OF state_id ON Protocol
    FOR EACH ROW
    EXECUTE FUNCTION update_sinodal_is_active();