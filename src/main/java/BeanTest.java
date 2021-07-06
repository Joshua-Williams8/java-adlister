import java.util.ArrayList;

public class BeanTest {


  public static void main(String[] args) {
    Album rumours = new Album(8,"FleetWood","Rumours",1977,27.90,"Soft rock");
    Album TwoOne = new Album(19,"Adele","21",2011,30.80,"Pop, Soul");
//    System.out.println(rumours.getArtist());

    Author markTwain = new Author(2,"Mark","Twain");
//    System.out.println(markTwain.getFirstName());
    Author douglasAdams = new Author(1,"Douglas","Adams");



  Quote clothes = new Quote(3,"Clothes make the man. Naked people have little or no influence on society.",markTwain);
//    System.out.println(clothes.getContent());
    Quote deadLines = new Quote(1,"I love deadlines. I love the whooshing noise they make as they go by.",douglasAdams);

    ArrayList<Quote> testQuotes = new ArrayList<>();
    testQuotes.add(clothes);
    testQuotes.add(deadLines);
    for(Quote quote: testQuotes){
      System.out.println(quote.getAuthor().getFirstName());
      System.out.println(quote.getAuthor().getLastName());
      System.out.println("Said");
      System.out.println(quote.getContent());
      System.out.println("-----");

    }





  }

}
