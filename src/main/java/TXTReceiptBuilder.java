 public class TXTReceiptBuilder implements IReceiptBuilder {

    StringBuilder sb = new StringBuilder();

    @Override
    public void appendHeader(String header) {
        sb.append(header).append("\n");
    }

    @Override
    public void appendCustomer(CustomerModel customer) {
        sb.append("Customer ID: ").append(customer.customerID).append("\n");
        sb.append("Customer Name: ").append(customer.name).append("\n");
    }

    @Override
    public void appendProduct(ProductModel product) {
        sb.append("Product ID: ").append(product.productID).append("\n");
        sb.append("Product Name: ").append(product.name).append("\n");
        sb.append("Cost of Product: ").append(product.name).append("\n");
        sb.append("Quantity: ").append(product.quantity).append("\n");
    }

    @Override
    public void appendPurchase(PurchaseModel purchase) {
        sb.append("Purchase ID: ").append(purchase.mPurchaseID).append("\n");
        sb.append("Cost: ").append(purchase.mCost).append("\n");
        sb.append("Sales Tax: ").append(purchase.mTax).append("\n");
        sb.append("Total Cost: ").append(purchase.mTotal).append("\n");
    }

    @Override
    public void appendFooter(String footer) {
        sb.append(footer).append("\n");
    }


}
