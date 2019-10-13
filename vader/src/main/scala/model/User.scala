package model

import connection.MySQLDBImpl
import spray.json.DefaultJsonProtocol

trait UserTable extends DefaultJsonProtocol {
  this: MySQLDBImpl =>

  import driver.api._

  implicit lazy val userFormat = jsonFormat2(User)
  implicit lazy val userListFormat = jsonFormat2(UserList)

  class UserTable(tag:Tag) extends Table[User](tag, "user") {
    val id = column[String]("id",O.PrimaryKey)
    val name = column[String]("name")
    val password = column[String]("password")
    val createdAt = column[Int]("created_at")
    val updatedAt = column[Int]("updated_at")
    val deletedAt = column[Option[Int]]("deleted_at")

    def * = (id.?,name,password,createdAt,updatedAt,deletedAt) <> (User.tupled, User.unapply)

  }

}

case class User(id: Option[String] = None, name: String, password: String,createdAt: Int, updatedAt: Int, deletedAt: Option[Int] = None)
case class UserList(users: List[User])