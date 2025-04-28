package com.bando.android.squishfarts.data

//TODO add docs
data class SoundEffects (
    val id: String,
    val name: String,
    val category: Array<String>,
    val subcategory: String,
    val duration: String,
    val type: String,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as SoundEffects

        if (id != other.id) return false
        if (!category.contentEquals(other.category)) return false
        if (duration != other.duration) return false
        if (type != other.type) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + category.contentHashCode()
        result = 31 * result + duration.hashCode()
        result = 31 * result + type.hashCode()
        return result
    }
}