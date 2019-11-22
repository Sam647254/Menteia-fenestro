package xyz.trankvila.menteia

import com.amazon.ask.{Skill, SkillStreamHandler, Skills}

class Respondilaro extends SkillStreamHandler(Respondilaro.skills) {}

object Respondilaro {
  val skills: Skill = Skills.standard()
    .addRequestHandlers(
      new Respondilo)
    .build()
}
