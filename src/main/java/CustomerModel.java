public class CustomerModel {
    public int customerID;
    public String name;
    public String address;
    public String number;

    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        sb.append(customerID).append(",");
        sb.append("\"").append(name).append("\"").append(",");
        sb.append("\"").append(address).append("\"").append(",");
        sb.append("\"").append(number).append("\"").append(")");
        return sb.toString();
    }
}
