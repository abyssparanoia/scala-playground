package controllers

import javax.inject._
import play.api.mvc._

import play.api.data._
import play.api.data.Forms._
import play.api.libs.json.Json
import play.api.Logger

import java.time.Clock

import pdi.jwt.{JwtJson, JwtAlgorithm}

class AuthenticationController @Inject()(mcc: MessagesControllerComponents) extends MessagesAbstractController(mcc) {

  val logger: Logger = Logger(this.getClass())

  def signIn() = Action { implicit request: MessagesRequest[AnyContent] =>

    val loginUserId: String = request.body.asFormUrlEncoded.get("loginUserId")(0)
    println(loginUserId)
    val claim = Json.obj(("uid","hogehoge"), ("nbf", 1431520421))
    val key = "secretKey"
    val algorithm = JwtAlgorithm.HS256
    val token = JwtJson.encode(claim,key,algorithm)

    Ok(Json.toJson(Map("token" -> token)))
  }
}
