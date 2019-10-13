package repository

import connection.MySQLDBImpl
import model.{UserTable,User}

import scala.concurrent.Future

trait UserRepository extends UserTable with MySQLDBImpl{

  import driver.api._

  protected val userTableQuery = TableQuery[UserTable]

  def create(user:User): Future[String] = db.run {
    userTableAutoInc += user
  }

  def update(user:User): Future[Int] = db.run {
    userTableQuery.filter(_.id === user.id.get).update(user)
  }

  def getById(id: String): Future[Option[User]] = db.run {
    userTableQuery.filter(_.id === id).result.headOption
  }

  def getAll: Future[List[User]] = db.run {
    userTableQuery.to[List].result
  }

  def ddl = db.run {
    userTableQuery.schema.create
  }

  protected def userTableAutoInc = userTableQuery returning userTableQuery.map(_.id)
}
