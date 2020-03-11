import spark.Request
import spark.Response
import spark.Spark.*
import spark.servlet.SparkApplication
import controllers.*

val userController = UserController()

class Router : SparkApplication {
    override fun init() {
        port(8080)

        routes()

        appContextRoutes()
    }

    fun appContextRoutes(){
        path("/api/users-api/v1"){
            routes()
        }
    }

    fun routes() {
        get("/users-api/health") { req : Request , res: Response ->
            "Server is ON"
        }
        path("/users"){
            post("", userController.createUser)
            get("/:userId", userController.getById)
        }
    }
}