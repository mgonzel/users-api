package controllers

import services.MongoService
import spark.Request
import spark.Response
import java.security.SecureRandom

class UserController(){
    val mongoService = MongoService()

    val getById = { req: Request, res: Response ->
        "working"
    }

    val createUser = { req: Request, res: Response ->
        val randomNmb = SecureRandom().nextInt(2000)

        mongoService.save(randomNmb.toLong())
        "working"
    }
}