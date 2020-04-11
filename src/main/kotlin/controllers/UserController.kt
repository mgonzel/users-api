package controllers

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import domains.User
import services.UsersService
import services.UtilsService
import spark.Request
import spark.Response

class UserController(){
    val utilsService = UtilsService()
    val userService = UsersService()

    val gsonUs : Gson= GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create()

    val getById = { req: Request, res: Response ->
        userService.findUser(req.params("userId"))
    }

    val createUser = { req: Request, res: Response ->
        val newId = utilsService.generateRandomUserId()

        val userData = req.body()

        val mapUser = gsonUs.fromJson(userData, HashMap::class.java)
                .plus(mapOf("id" to newId)) as Map<String, String>

        val finalUser = gsonUs.fromJson(gsonUs.toJson(mapUser),User::class.java)


        println("User body: ${mapUser}")
        res.header("Content-type", "application/json")
        if (finalUser.validate()) {
            userService.saveUser(mapUser)

            res.status(201)
            """${gsonUs.toJson(finalUser)}"""
        } else {
            res.status(400)
            """{"status":"error","message":"invalid body"}"""
        }
    }
}