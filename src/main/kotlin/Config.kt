package config

val MONGO_URI = System.getenv("MONGO_URI")?:"mongo-server"
val MONGO_PORT = System.getenv("MONGO_PORT")?:"27017"
val MONGO_USER = System.getenv("MONGO_USER")?:"";
val MONGO_PASS = System.getenv("MONGO_PASS")?:"";