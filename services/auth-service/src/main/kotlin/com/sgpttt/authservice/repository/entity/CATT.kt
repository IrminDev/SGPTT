package com.sgpttt.authservice.repository.entity

import com.sgpttt.authservice.model.domain.CattRole
import com.sgpttt.authservice.model.domain.PersonDTO.CattPerson
import com.sgpttt.authservice.repository.DomainDTO
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.MapsId
import jakarta.persistence.OneToOne

@Entity
data class CATT(
	@Id
	@Column(name = "person_id")
	val personId: Long,
	@MapsId
	@OneToOne
	@JoinColumn(name = "person_id")
	val person: Person,
	@ManyToOne
	@JoinColumn(name = "role_id")
	val role: CATTRole,
	@Column(name = "catt_id")
	val cattId: String
) : DomainDTO<CattPerson> {
	
	override fun toDomain(): CattPerson {
		return CattPerson(
			name = "${person.name} ${person.paternalSurname} ${person.maternalSurname}",
			number = cattId,
			role = CattRole.entries[role.cattRoleId],
			isActive = person.isActive
		)
	}
}