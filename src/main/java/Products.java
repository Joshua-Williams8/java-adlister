import java.util.List;

interface Products {
//  This is a DAO interface, usually named with this scheme, so multiple of a single class in this case product.
  List<Product> all();
  void insert(Product product);

}
