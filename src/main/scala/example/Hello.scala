package example

import eu.timepit.refined.types.string.NonEmptyString
import io.circe.generic.JsonCodec
import io.circe.parser._
import io.circe
import io.circe.CursorOp.DownField
import io.circe.{DecodingFailure, Json}
import eu.timepit.refined.auto._
import io.circe.refined._

object Hello extends App {

  @JsonCodec case class Request(application_uuid: NonEmptyString, some_data: SomeData)

  @JsonCodec case class SomeData(somex: Json)

  val value: Either[circe.Error, Request] = decode[Request]("""{"application_uuid": "1", "some_data": {}}""".stripMargin)

  value match {
    case e @ Left(DecodingFailure("Predicate isEmpty() did not fail.", DownField("application_uuid") :: Nil)) =>
      println(e)
    case e @ Left(DecodingFailure("Attempt to decode value on failed cursor", DownField("somex") :: DownField("some_data") :: Nil)) =>
      println(e)
    case _ =>
//      println(value)
  }
}
