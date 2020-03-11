package services

import com.mongodb.MongoClient
import domains.User
import org.bson.Document

class MongoService () {
   val mongoClient = MongoClient(config.MONGO_URI, config.MONGO_PORT.toInt())

    fun findUser (userId: Long) {
        mongoClient.getDatabase("users_db").getCollection("users").find()
    }

    fun save(user: Map<String, String>) {
        mongoClient.getDatabase("users_db")
                .getCollection("users")
                .insertOne(Document(user))
    }
}