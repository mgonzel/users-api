package services

import com.mongodb.MongoClient

class MongoService () {
   val mongoClient = MongoClient(config.MONGO_URI, config.MONGO_PORT as Int)

    fun findUser (userId: Long) {
        mongoClient.getDatabase("users_db").getCollection("users").find()
    }
}