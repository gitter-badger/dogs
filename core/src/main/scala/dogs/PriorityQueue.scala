package dogs

import dogs.Predef._

/**
 * Created by nperez on 1/30/16.
 */
trait PriorityQueue[A] {
  def findMin(): A
  def add(x: A): PriorityQueue[A]
  def remove(x: A): PriorityQueue[A]

  def isEmpty: Boolean
  def empty(): PriorityQueue[A]
}

case object EmptyQueue extends PriorityQueue[Nothing] {
  override def findMin(): Nothing = this

  override def empty(): PriorityQueue[Nothing] = ???

  override def remove(x: Nothing): PriorityQueue[Nothing] = ???

  override def isEmpty: Boolean = ???

  override def add(x: Nothing): PriorityQueue[Nothing] = ???
}

class BinomialQueue[A] extends PriorityQueue[A] {
  override def findMin(): A = ???

  override def empty(): PriorityQueue[A] = ???

  override def remove(x: A): PriorityQueue[A] = ???

  override def isEmpty: Boolean = ???

  override def add(x: A): PriorityQueue[A] = ???
}

