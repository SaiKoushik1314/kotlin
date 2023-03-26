package com.digital.digitalapp.common.model.error

data class ErrorResponse(
    val errors: Array<Errors>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ErrorResponse

        if (!errors.contentEquals(other.errors)) return false

        return true
    }

    override fun hashCode(): Int {
        return errors.contentHashCode()
    }
}
