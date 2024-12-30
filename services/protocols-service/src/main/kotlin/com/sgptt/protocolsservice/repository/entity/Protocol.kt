package com.sgptt.protocolsservice.repository.entity

import com.sgptt.protocolsservice.model.State
import jakarta.persistence.Basic
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.OneToMany
import jakarta.persistence.Temporal
import jakarta.persistence.TemporalType
import java.sql.Timestamp

@Entity
data class Protocol(
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "protocol_id")
	val id: Long = 0L,
	
	@Column(name = "title", nullable = false)
	val title: String,
	
	@Column(name = "keywords", nullable = false, columnDefinition = "TEXT")
	val keywords: String,
	
	@Column(name = "abstract", nullable = false, columnDefinition = "TEXT")
	val protocolAbstract: String,
	
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "file_data", columnDefinition = "BYTEA")
	val fileData : ByteArray,
	
	@Enumerated(EnumType.ORDINAL)
	val state: State,
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	val createdAt: Timestamp,
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "protocol_academy",
		joinColumns = [JoinColumn(name = "protocol_id")],
		inverseJoinColumns = [JoinColumn(name = "academy_id")]
	)
	val academies: Set<Academy>,
	
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "protocol_student",
        joinColumns = [JoinColumn(name = "protocol_id")],
        inverseJoinColumns = [JoinColumn(name = "person_id")]
    )
    val students: Set<Student>,

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "director",
        joinColumns = [JoinColumn(name = "protocol_id")],
        inverseJoinColumns = [JoinColumn(name = "person_id")]
    )
    val directors: Set<Professor>,

    @OneToMany(mappedBy = "protocol", fetch = FetchType.LAZY)
    val sinodals: Set<Sinodal>
) {
	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (other !is Protocol) return false
		
		if (id != other.id) return false
		if (title != other.title) return false
		if (keywords != other.keywords) return false
		if (protocolAbstract != other.protocolAbstract) return false
		if (!fileData.contentEquals(other.fileData)) return false
		if (state != other.state) return false
		if (createdAt != other.createdAt) return false
		if (academies != other.academies) return false
		if (students != other.students) return false
		if (directors != other.directors) return false
		if (sinodals != other.sinodals) return false
		
		return true
	}
	
	override fun hashCode(): Int {
		var result = id.hashCode()
		result = 31 * result + title.hashCode()
		result = 31 * result + keywords.hashCode()
		result = 31 * result + protocolAbstract.hashCode()
		result = 31 * result + fileData.contentHashCode()
		result = 31 * result + state.hashCode()
		result = 31 * result + createdAt.hashCode()
		result = 31 * result + academies.hashCode()
		result = 31 * result + students.hashCode()
		result = 31 * result + directors.hashCode()
		result = 31 * result + (sinodals.hashCode())
		return result
	}
	
}
