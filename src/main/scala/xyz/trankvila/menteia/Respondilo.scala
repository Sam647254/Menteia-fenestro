package xyz.trankvila.menteia

import java.util.Optional

import com.amazon.ask.dispatcher.request.handler.{HandlerInput, RequestHandler}
import com.amazon.ask.model.{LaunchRequest, Response}
import com.amazon.ask.request.Predicates


class Respondilo extends RequestHandler {
  override def canHandle(input: HandlerInput): Boolean = input.matches(Predicates.requestType(classOf[LaunchRequest]))

  override def handle(input: HandlerInput): Optional[Response] = {
    val respondo = "This is a test"
    input.getResponseBuilder
      .withSpeech(respondo)
      .build
  }
}
