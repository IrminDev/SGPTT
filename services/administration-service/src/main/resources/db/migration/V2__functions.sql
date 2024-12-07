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