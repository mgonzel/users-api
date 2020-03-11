package services

import com.mongodb.MongoClient
import domains.User
import org.bson.BsonDocument
import org.bson.BsonString
import org.bson.Document

class MongoService () {
   val mongoClient = MongoClient(config.MONGO_URI, config.MONGO_PORT.toInt())

    fun findUser (userId: String) : String {
        return mongoClient.getDatabase("users_db")
                .getCollection("users")
                .find(BsonDocument("id" , BsonString(userId)))
                .toString()
    }

    fun save(toSaveData: Map<String, Any>) {
        mongoClient.getDatabase("users_db")
                .getCollection("users")
                .insertOne(Document(toSaveData))
    }
}