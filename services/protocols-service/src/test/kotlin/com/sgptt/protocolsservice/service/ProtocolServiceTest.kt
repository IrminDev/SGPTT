package com.sgptt.protocolsservice.service

import com.sgptt.protocolsservice.model.State
import com.sgptt.protocolsservice.repository.ActivityRepository
import com.sgptt.protocolsservice.repository.ProfessorRepository
import com.sgptt.protocolsservice.repository.ProtocolRepository
import com.sgptt.protocolsservice.repository.ProtocolSearchRepository
import com.sgptt.protocolsservice.repository.StudentRepository
import com.sgptt.protocolsservice.repository.entity.Protocol
import java.sql.Timestamp
import java.time.LocalDateTime
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
class ProtocolServiceTest {
	
	private lateinit var protocolService: ProtocolService
	
	private lateinit var closable: AutoCloseable
	
	@Mock
	private lateinit var protocolRepository: ProtocolRepository
	
	@Mock
	private lateinit var studentRepository: StudentRepository
	
	@Mock
	private lateinit var professorRepository: ProfessorRepository
	
	@Mock
	private lateinit var activityRepository: ActivityRepository
	
	@Mock
	private lateinit var documentRepository: ProtocolSearchRepository
	
	@BeforeEach
	fun setUp() {
		closable = MockitoAnnotations.openMocks(this)
		protocolService = ProtocolService(
			protocolRepository,
			studentRepository,
			professorRepository,
			activityRepository,
			documentRepository
		)
	}
	
	@AfterEach
	fun tearDown() {
		closable.close()
	}
	
	@Test
	fun findById() {
		
		val protocols = Array(size = 10) {
			Protocol(
				id = it.toLong() + 1L,
				title = "Title $it",
				keywords = "Keyword${it+1},Keyword${it+2},Keyword${it+3}",
				protocolAbstract = "protocol abstract ${it + 1}",
				fileData = byteArrayOf(),
				state = State.PENDING,
				createdAt = Timestamp.valueOf(LocalDateTime.now()),
				academies = emptySet(),
				students = mutableSetOf(),
				directors = mutableSetOf(),
				sinodals = mutableSetOf()
			)
		}.toList()
		
//		protocolService.registryProtocol()
	
	}
}