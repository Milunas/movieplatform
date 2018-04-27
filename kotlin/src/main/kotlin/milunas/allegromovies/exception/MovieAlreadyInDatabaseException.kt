package milunas.allegromovies.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.CONFLICT)
class MovieAlreadyInDatabaseException(message: String) : RuntimeException(message)