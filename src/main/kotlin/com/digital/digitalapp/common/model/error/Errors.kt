package com.digital.digitalapp.common.model.error

import java.time.LocalDateTime

data class Errors(
    val rootCauses: List<Error>,
    val reason: String,
    val datetime: LocalDateTime
)
