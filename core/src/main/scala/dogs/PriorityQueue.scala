package dogs

import dogs.Order.{GT, EQ, LT}
import dogs.Predef._

/**
 * Created by nperez on 1/30/16.
 */
class PriorityQueue[A](bq: List[BinomialQueueNode[A]]) {

  private def link(h: BinomialQueueNode[A], n: BinomialQueueNode[A])(implicit order: Order[BigInt]): BinomialQueueNode[A] = {
      if (order.compare(h.rank, n.rank) == LT){
        BinomialQueueNode(h.value, h.rank+1, n :: h.children)
      }
      else{
        BinomialQueueNode(n.value, n.rank+1, h :: n.children)
      }
  }

  private def insert(n: BinomialQueueNode[A], xs: List[BinomialQueueNode[A]]): List[BinomialQueueNode[A]] = xs match {
    case El()       =>  Nel(n, El[BinomialQueueNode[A]])
    case (h: BinomialQueueNode[A]) :: (ts: List[BinomialQueueNode[A]])    =>  {
      if (n.rank < h.rank) {
        Nel[BinomialQueueNode[A]](n, h :: ts)
      }
      else {
        insert(link(h, n), ts)
      }
    }
  }

  def add(x: A, rank: BigInt)(implicit order: Order[A]): PriorityQueue[A] = {
    val result = insert(BinomialQueueNode[A](Some(x), rank, El[BinomialQueueNode[A]]), bq)

    PriorityQueue[A](result)
  }





//  def findMin(): Option[A]
//  def remove(x: A): PriorityQueue[A]
//
//  def isEmpty: Boolean
//  def empty(): Priority Queue[A]
}



case class BinomialQueueNode[A](value: Option[A],
                                rank: BigInt,
                                children: List[BinomialQueueNode[A]]){


}

case object BQNull extends BinomialQueueNode[Nothing](None(), -1, El[BinomialQueueNode[Nothing]]) {

  def apply[A](): BinomialQueueNode[A] = this.asInstanceOf[BinomialQueueNode[A]]
}



object PriorityQueue {
  def apply[A](lst: List[BinomialQueueNode[A]]) = new PriorityQueue[A](lst)
  def apply[A]() = new PriorityQueue[A](El[BinomialQueueNode[A]])

  def empty[A]() = PriorityQueue[A]
}