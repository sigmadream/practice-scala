package com.sangkon.learningscala.ch08

import java.io.{File, FilenameFilter}

class DirLister(path: String, f: String => Boolean) {
  lazy val file: File = new File(path)
  lazy val filter = new FilenameFilter {
    override def accept(dir: File, name: String): Boolean = f(name)
  }

  def list: List[String] = file.list(filter).toList
}
