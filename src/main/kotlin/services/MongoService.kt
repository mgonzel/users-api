package services

import com.mongodb.MongoClient
import org.bson.Document

class MongoService () {
   val mongoClient = MongoClient(config.MONGO_URI, config.MONGO_PORT.toInt())

    fun findUser (userId: Long) {
        mongoClient.getDatabase("users_db").getCollection("users").find()
    }

    fun save(userId: Long) {
        val data = mapOf("id" to "$userId", "value" to "test")
        mongoClient.getDatabase("users_db")
                .getCollection("users")
                .insertOne(Document(data))
    }
}