package controllers

import javax.inject._
import play.api.mvc._

import play.api.data._
import play.api.data.Forms._

class AuthenticationController @Inject()(mcc: MessagesControllerComponents) extends MessagesAbstractController(mcc) {

  def signIn() = Action { implicit request: MessagesRequest[AnyContent] =>
    Ok("success sign in")
  }
}
