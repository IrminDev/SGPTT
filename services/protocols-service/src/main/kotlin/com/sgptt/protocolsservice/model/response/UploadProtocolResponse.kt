package com.sgptt.protocolsservice.model.response

import com.sgptt.protocolsservice.model.dto.ProtocolDTO
import com.sgptt.protocolsservice.model.exception.EntityNotFoundException
import com.sgptt.protocolsservice.model.exception.WrongUploadDateException

/**
 * This class represents a server response for uploading a new protocol
 * @property message is a simple string message about the upload result
 */

sealed class UploadProtocolResponse(open val message: String) {
	/**
	 * {
	 *   "message" : "The file of your protocol must be present"
	 * }
	 */
	data object EmptyFile : UploadProtocolResponse(message = "The file of your protocol must be present")
	/**
	 *  {
	 *    "message" : "${e.message}"
	 *  }
	 */
	class PersonNotFound(e: EntityNotFoundException) : UploadProtocolResponse(e.message)
	
	/**
	 * {
	 *   "message" : "Successfully uploaded the new protocol"
	 *   "new" : {
	 *         "title" : "A protocol title",
	 *         "abstract" : "A protocol abstract"
	 *         ...
	 *         "" : ""
	 *   }
	 * }
	 */
	data class UploadSuccess(val new: ProtocolDTO) : UploadProtocolResponse("Successfully uploaded the new protocol")
	data class FieldError(override val message: String) : UploadProtocolResponse(message)
	data object BadFileType : UploadProtocolResponse("Your file must be a PDF file")
	class WrongUploadDateResponse(e: WrongUploadDateException) : UploadProtocolResponse(e.message)
	
}
