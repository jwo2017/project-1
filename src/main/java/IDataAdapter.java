public interface IDataAdapter {

    public static final int CONNECTION_OPEN_OK = 100;
    public static final int CONNECTION_OPEN_FAIL = 101;

    public static final int CONNECTION_CLOSE_OK = 200;
    public static final int CONNECTION_CLOSE_FAIL = 201;


    public void connect(String dbfile);
    public int disconnect();

    public ProductModel loadProduct(int id);
    public int saveProduct(ProductModel model);

    public CustomerModel loadCustomer(int id);
    public int saveCustomer(CustomerModel model);

    // public int loadPurchase(int id);
    public int savePurchase(PurchaseModel model);
}
