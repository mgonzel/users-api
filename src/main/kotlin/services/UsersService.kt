package services

import com.mongodb.MongoClient
import com.mongodb.client.FindIterable
import domains.User
import org.bson.BsonDocument
import org.bson.BsonString
import org.bson.Document

class UsersService (
        val mongoService : MongoService = MongoService(databaseName = "users_db", collection = "users")
) {
    fun findUser (userId: String) : String? {
        val user = mongoService.findOne(mapOf("id" to userId))

        return user?.toJson()
    }

    fun saveUser(toSaveData: Map<String, Any>) {
        return mongoService.save(toSaveData)
    }
}