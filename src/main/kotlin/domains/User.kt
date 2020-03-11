package domains

data class User (
        val id: String,
        // Main info
        val country: String,
        val doc_type: String,
        val doc_number: String,

        // Contact info (unique)
        val email: String,
        val phone: String,

        // Personal info
        val first_name: String,
        val last_name: String,

        val status: String
) {
    fun validate() : Boolean{
        if (id == null || country == null || doc_type == null || doc_number == null ||
                email == null || phone == null || first_name == null || last_name == null)
            return false
        return true
    }
}