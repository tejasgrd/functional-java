package edu.functional.java.ch1;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.Collections;
import java.util.List;



public class DonutShop {

  public static Tuple<Donut, Payment> buyDonut(final CreditCard cCard) {
    return new Tuple<>(new Donut(), new Payment(cCard, Donut.price));
  }

  public static Tuple<List<Donut>, Payment> buyDonuts(final int quantity,
                                                      final CreditCard cCard) {

    return new Tuple<>(Collections.nCopies(quantity, new Donut()),
        new Payment(cCard, Donut.price * quantity));
  }
  @Test
  public void testBuyDonuts() {
    CreditCard creditCard = new CreditCard();
    Tuple<List<Donut>, Payment> purchase = DonutShop.buyDonuts(5, creditCard);
    Assertions.assertEquals(Donut.price * 5, purchase._2.amount);
    Assertions.assertEquals(creditCard, purchase._2.creditCard);
  }

}

class Tuple<T, U> {
  public final T _1;
  public final U _2;

  public Tuple(T t, U u) {
    this._1 = t;
    this._2 = u;
  }
}

class Payment {
  public final CreditCard creditCard;
  public final int amount;

  public Payment(CreditCard creditCard, int amount) {
    this.creditCard = creditCard;
    this.amount = amount;
  }

  public Payment combine(Payment payment) {
    if (creditCard.equals(payment.creditCard)) {
      return new Payment(creditCard, amount + payment.amount);
    } else {
      throw new IllegalStateException("Cards don't match.");
    }
  }

 /* public static List<Payment> groupByCard(List<Payment> payments) {
    return payments
        .groupBy(x -> x.creditCard) //Changes a List<Payment> into a
                                   //   Map<CreditCard, List<Payment>>
                                     // where each list contains all payments
                                   // for a particular credit card
        .values() //Changes the Map<CreditCard,
                  // List<Payment>> into a
                  //List<List<Payment>>
        .map(x -> x.reduce(c1 -> c2 -> c1.combine(c2)));//Reduces each List<Payment> into a
single Payment, leading to the overall
result of a List<Payment>


    }*/

}

class CreditCard {

}

class Donut {
  public static int price = 10;
}

