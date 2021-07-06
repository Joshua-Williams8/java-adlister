public class DaoFactory {
    private static Ads adsDao;
    private static Products productsDao;

    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new ListAdsDao();
        }
        return adsDao;
    }

//    It's static so we don't have to instantiate it
  public static Products getProductsDao() {
    if (productsDao == null) {
      productsDao = new ListProducts();
    }
    return productsDao;
  }
}
