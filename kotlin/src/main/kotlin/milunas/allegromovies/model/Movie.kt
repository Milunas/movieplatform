package milunas.allegromovies.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity data class Movie(@Id @GeneratedValue val id: Long = 0,
                            val title: String)