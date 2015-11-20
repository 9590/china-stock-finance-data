package com.rock.stock.model.http
sealed abstract class ContentType
class PlainTextContentType(mimeType:String, chartSet:String) extends ContentType{
  override def toString = s"$mimeType; charset=$chartSet"
}
case class TextHtmlContentType(charset:String) extends PlainTextContentType("text/html", charset)
case class JsonContentType(charset:String) extends PlainTextContentType("application/json", charset)

object PlainTextContentType{
    def apply(mimeType:String, chartSet:String) = new PlainTextContentType(mimeType, chartSet)
}