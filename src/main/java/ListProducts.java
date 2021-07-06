import java.util.ArrayList;
import java.util.List;

public class ListProducts implements Products{
  private List<Product> products = new ArrayList<>();

  public ListProducts(){
//    This will go into the DB and pull data out of it?
    insert(new Product("Crimpers",59.99));
    insert(new Product("Tester",19.99));
    insert(new Product("Tone Tester",119.99));

  }

  @Override
  public List<Product> all() {
    return this.products;
  }

  @Override
  public void insert(Product product) {
    this.products.add(product);
  }
//  Mirrors list adds DAO

}
