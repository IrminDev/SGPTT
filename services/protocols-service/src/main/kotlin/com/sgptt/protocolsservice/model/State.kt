package com.sgptt.protocolsservice.model

/**
 * This enum represents a particular state a protocol is
 * @property PENDING means the protocol is pending to review by Catt
 * @property APPROVED means the protocols has been approved by Catt
 * @property REJECTED means the protocols has been rejected by Catt
 * @property FINISHED means the protocol lifecycle has finished
 * @property CORRECTIONS meas the protocol has been reviewed by CATT o Synodals, and it needs to be corrected
 * @property EVALUATING meas the protocol is being evaluated
 */
enum class State {
	PENDING, APPROVED, REJECTED, FINISHED, CORRECTIONS, EVALUATING
}