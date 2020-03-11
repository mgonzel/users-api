package controllers

import services.MongoService
import spark.Request
import spark.Response

class UserController(){
    val mongoService = MongoService()

    val getById = { req: Request, res: Response ->
        "working"
    }

    val createUser = { req: Request, res: Response ->
        "working"
    }
}