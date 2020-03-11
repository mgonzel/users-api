package controllers

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import domains.User
import services.MongoService
import services.UtilsService
import spark.Request
import spark.Response

class UserController(){
    val mongoService = MongoService()
    val utilsService = UtilsService()
    val gsonUs : Gson= GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create()

    val getById = { req: Request, res: Response ->
        "working"
    }

    val createUser = { req: Request, res: Response ->
        val newId = utilsService.generateRandomUserId()

        val userData = req.body()

        val mapUser = gsonUs.fromJson(userData, HashMap::class.java)
                .plus(mapOf("id" to newId)) as Map<String, String>

        val finalUser = gsonUs.fromJson(gsonUs.toJson(mapUser),User::class.java)


        println("User body: ${mapUser}")
        if (finalUser.validate()) {
            mongoService.save(mapUser)
        };

        "working"
    }
}