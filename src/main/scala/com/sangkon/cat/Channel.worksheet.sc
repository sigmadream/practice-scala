import java.io.{File, FileOutputStream}
import java.nio.ByteBuffer
import java.nio.file.Path
import scala.util.Using

trait Channel {
  def write(obj: Any): Unit
}

object FileChannel extends Channel {
  override def write(obj: Any): Unit = {
    var bytes: Array[Byte] = obj match {
      case n: Int =>
        val bb = {
          ByteBuffer.allocate(4)
        }
        bb.putInt(n)
        bb.array()
      case s: String =>
        s.getBytes
      case invalid => throw new Exception("Unhanded")
    }
    Using(new FileOutputStream("/Users/sd/Works/practice-scala/text1.txt")) { os =>
      os.write(bytes)
      os.flush()
    }    
  }
}

FileChannel.write("Hello1")
