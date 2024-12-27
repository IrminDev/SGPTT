package com.sgpttt.authservice.repository.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinColumns
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.Temporal
import jakarta.persistence.TemporalType
import java.sql.Timestamp

@Entity
data class Evaluation (
	// Getters and Setters
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "evaluation_id")
	val evaluationId: Long,
	
	@ManyToOne
	@JoinColumns(JoinColumn(name = "sinodal_id", insertable = false, updatable = false))
	val sinodal: Sinodal,
	
	@Column(name = "is_approved")
	val isApproved: Boolean = false,
	
	@Column(name = "evaluation_comments")
	val evaluationComments: String,
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "evaluation_date")
	val evaluationDate: Timestamp,
	
	@OneToMany(targetEntity = CriterionEvaluation::class)
	@JoinColumn(name = "criterion_evaluation_id", insertable = false, updatable = false)
	val criterionEvaluations: List<CriterionEvaluation>,
)