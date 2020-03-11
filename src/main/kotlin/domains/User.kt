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
)