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

    def * = (id.?,name) <> (User.tupled, User.unapply)

  }

}

case class User(id: Option[String] = None, name: String)
case class UserList(users: List[User])