public class OracleDataAdapter implements IDataAdapter {
    public void connect() {
        //...
    }

    @Override
    public void connect(String dbfile) {

    }

    public int disconnect() {
        // ...
        return CONNECTION_CLOSE_OK;

    }

    public ProductModel loadProduct(int id) {
        return null;
    }
    public int saveProduct(ProductModel model) {
        return 0;
    }

    public CustomerModel loadCustomer(int id) {

        return null;
    }

    public int saveCustomer(CustomerModel model) {

        return 0;
    }

    public int savePurchase(PurchaseModel model) {

         return 0;
    }



}
