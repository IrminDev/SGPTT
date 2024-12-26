package com.sgptt.protocolsservice.interceptor

import com.sgptt.protocolsservice.model.Role
import com.sgptt.protocolsservice.model.UPLOAD_PROTOCOL_IRREGULAR_STUDENTS
import com.sgptt.protocolsservice.model.UPLOAD_PROTOCOL_REGULAR_STUDENTS
import com.sgptt.protocolsservice.repository.ActivityRepository
import com.sgptt.protocolsservice.repository.StudentRepository
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.client.RestClient
import java.util.Date

@Component(value = "upload-interceptor")
class UploadProtocolAuthInterceptor(
	restClientBuilder: RestClient.Builder,
	private val studentRepository: StudentRepository,
	private val activityRepository: ActivityRepository
) : AuthInterceptor(restClientBuilder) {
	
	override val authorizedRole: Role
		get() = Role.Estudiante
	
	override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
		val isAuth = super.preHandle(request, response, handler)
		if (!isAuth) return false
		val personId: Long = with(request) {
			val id = getAttribute("personId") as Number
			removeAttribute("personId")
			id.toLong()
		}
		
		val isIrregularStudent = studentRepository.findById(personId).get().recursor
		val activity = activityRepository.findByActivity(
			if (isIrregularStudent) UPLOAD_PROTOCOL_IRREGULAR_STUDENTS
			else UPLOAD_PROTOCOL_REGULAR_STUDENTS
		)
		
		val today = Date()
		
		return today.after(activity.openDate) && today.before(activity.closeDate).also { isBetweenDates ->
			if (!isBetweenDates)
				response.status = HttpStatus.NOT_ACCEPTABLE.value()
		}
	}
}