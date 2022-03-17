package exercises.learningscala.ch08

import javax.sound.midi.MidiChannel

class Calliope(volume: Int) {
  private val duration = 250L
  private lazy val synth = javax.sound.midi.MidiSystem.getSynthesizer

  def play(notes: Seq[Int]): Unit = {
    playChannel { channel =>
      for (note <- notes) {
        channel.noteOn(note, volume)
        Thread.sleep(duration)
        channel.noteOn(note, 0)
      }
    }
  }

  private def playChannel(f: MidiChannel => Unit): Unit = {
    synth.open()
    val channel: MidiChannel = synth.getChannels.head
    f(channel)
    synth.close()
  }
}

class CalliopePlaying {

  val calliope = new Calliope(95)

  def playScale(): Unit = {
    calliope.play(Seq(60, 62, 64, 65, 67, 69, 71, 72))
  }

  def playMary(): Unit = {
    val (c, d, e) = (60, 62, 64)
    val mary = Seq(0, e, d, c, d, e, e, e, 0, d, d, d, 0, e, e, e, 0, e, d, c, d, e, e, e, e, d, d, e, d, c, 0)
    calliope.play(mary)
  }
}

