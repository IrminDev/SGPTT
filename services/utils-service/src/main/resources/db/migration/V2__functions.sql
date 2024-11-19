
/*Función que devuelve todos los protocolos pendientes asignados a una academía para que el usuario
profesor escoja ser sinodal de alguno de ellos*/
create or replace function getProtocolsByAcademyId(academyId integer) returns table(
	idProtocol integer,
	title varchar(255),
	keywords text,
	abstract text,
	pdf_file bytea,
	upload_at timestamp
) as $$
begin
return query select protocol.idProtocol,
		protocol.title,
		protocol.keywords,
		protocol.abstract,
		protocol.pdf_file,
		protocol.upload_at
from protocolacademy inner join protocol on protocolacademy.academy_id = academyId and protocol.state = 'Pendiente';
end;
$$ language plpgsql;