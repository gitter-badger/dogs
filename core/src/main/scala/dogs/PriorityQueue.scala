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
}
