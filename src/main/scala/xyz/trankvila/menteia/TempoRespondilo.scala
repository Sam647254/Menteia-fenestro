package xyz.trankvila.menteia

import java.time.{ZoneId, ZonedDateTime}
import java.util.Optional

import com.amazon.ask.dispatcher.request.handler.{HandlerInput, RequestHandler}
import com.amazon.ask.model.Response
import com.amazon.ask.request.Predicates
import org.dom4j.DocumentHelper

class TempoRespondilo extends RequestHandler {
  override def canHandle(input: HandlerInput): Boolean =
    input.matches(Predicates.intentName("CurrentTimeIntent"))

  override def handle(input: HandlerInput): Optional[Response] = {
    val tempo = ZonedDateTime.now(ZoneId.of("America/Vancouver"))
    val fazo = TempoRespondilo.fazoj(tempo.getHour / 8)
    val fazoNomo = TempoRespondilo.fazajNomoj(tempo.getHour / 8)
    val radiko = DocumentHelper.createDocument
      .addElement("voice")
      .addAttribute("name", "Ivy")
    val prosody = radiko.addElement("prosody")
      .addAttribute("rate", "80%")
      .addAttribute("pitch", "-5%")
      .addText("The current time is ")
    prosody.addElement("phoneme")
      .addAttribute("ph", fazo)
      .addText(fazoNomo)
    prosody.addText(s"${tempo.getHour % 8} ${tempo.getMinute}.")
    input.getResponseBuilder
      .withSpeech(radiko.asXML)
      .build
  }
}

object TempoRespondilo {
  val fazoj = Array("və'limə", "də'rɛnə", "ge'munə")
  val fazajNomoj = Array("valima ", "darena ", "gemuna ")
}
