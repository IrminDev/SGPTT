package com.sgpttt.authservice.repository.entity

import com.sgpttt.authservice.model.domain.Criterion
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Temporal
import jakarta.persistence.TemporalType
import java.util.Date

@Entity
data class CriterionEvaluation (
	// Getters and Setters
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "evaluation_id")
	val evaluationId: Long,
	
	@Column(name = "criterion_result", nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
	val criterionResult: Boolean = false,
	
	@Enumerated(EnumType.ORDINAL)
	val criterion: Criterion,
	
	@Column(name = "criterion_comments", columnDefinition = "TEXT", nullable = false)
	val criterionComments: String,
	
	@Temporal(TemporalType.TIMESTAMP)
	val evaluationDate: Date
)