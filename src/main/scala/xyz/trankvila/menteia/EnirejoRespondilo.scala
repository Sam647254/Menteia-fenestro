package xyz.trankvila.menteia

import java.util.Optional

import com.amazon.ask.dispatcher.request.handler.{HandlerInput, RequestHandler}
import com.amazon.ask.model.{LaunchRequest, Response}
import com.amazon.ask.request.Predicates
import org.dom4j.DocumentHelper


class EnirejoRespondilo extends RequestHandler {
  override def canHandle(input: HandlerInput): Boolean = input.matches(Predicates.requestType(classOf[LaunchRequest]))

  override def handle(input: HandlerInput): Optional[Response] = {
    val xml = DocumentHelper.createDocument
    val radiko = xml.addElement("voice")
      .addAttribute("name", "Ivy")
    val prosody = radiko.addElement("prosody")
      .addAttribute("rate", "80%")
      .addAttribute("pitch", "-5%")
      .addText("This is ")
    prosody.addElement("phoneme")
      .addAttribute("ph", "men'teɪ.əs")
      .addText("Menteia's ")
    prosody.addText("window. What would you like to do?")
    input.getResponseBuilder
      .withSpeech(radiko.asXML)
      .build
  }
}
