import java.sql.*;

public class SQLDataBase implements IDataAdapter {

    public static final int CONNECTION_OPEN_OK = 100;
    public static final int CONNECTION_OPEN_FAIL = 101;

    public static final int CONNECTION_CLOSE_OK = 200;
    public static final int CONNECTION_CLOSE_FAIL = 201;

    public static final int PRODUCT_DUPLICATE_ERROR = -28;
    public static final int PRODUCT_ADD_SUCCESS = 1;

    public static final int CUSTOMER_DUPLICATE_ERROR = -27;
    public static final int CUSTOMER_ADD_SUCCESS = 2;

    public static final int PURCHASE_DUPLICATE_ERROR = -27;
    public static final int PURCHASE_ADD_SUCCESS = 2;


    Connection conn = null;

    public void connect(String dbfile) {
        try {
            // db parameters
            String url = "jdbc:sqlite:" + dbfile;
            // create a connection to the database
            conn = DriverManager.getConnection(url);


            System.out.println("Connection to SQLite has been established.");
/*
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Product");

            while (rs.next())
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));

*/
        } catch (SQLException e) {
            System.out.println(e.getMessage());


        }
    }

    public int disconnect() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.print(e.getMessage());
            return CONNECTION_CLOSE_FAIL;
        }
        return CONNECTION_CLOSE_OK;
    }

    public int saveProduct(ProductModel product) {
        try {
            String sql = "INSERT INTO Products(ProductId, Name, Price, Quantity) VALUES " + product;
            System.out.println(sql);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);

        } catch (Exception e) {
            String msg = e.getMessage();
            System.out.println(msg);
            if (msg.contains("UNIQUE constraint failed"))
                return PRODUCT_DUPLICATE_ERROR;
        }

        return PRODUCT_ADD_SUCCESS;
    }

    public ProductModel loadProduct(int productID) {
        ProductModel product = new ProductModel();
        try {
            String sql = "SELECT ProductId, Name, Price, Quantity FROM Products WHERE ProductId = " + productID;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            product.productID = rs.getInt("ProductId");
            product.name = rs.getString("Name");
            product.price = rs.getDouble("Price");
            product.quantity = rs.getDouble("Quantity");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return product;
    }


    public int saveCustomer(CustomerModel customer) {

        /*
        try {

            if (loadCustomer(customer.customerID) == null) {           // this is a new customer!
                Statement stmt = conn.createStatement();

                stmt.execute("INSERT INTO Customer(customerID, name, address, number) VALUES ("
                        + customer.customerID + ","
                        + '\'' + customer.name + '\'' + ","
                        + customer.address + ","
                        + customer.number + ")");
                return CUSTOMER_ADD_SUCCESS;
            }
            else {
                Statement stmt = conn.createStatement();

                stmt.executeUpdate("UPDATE Customer SET "
                        + "customerID = " + customer.customerID + ","
                        + "name = " + '\'' + customer.name + '\'' + ","
                        + "address = " + customer.address + ","
                        + "number = " + customer.number +
                        " WHERE customerID = " + customer.customerID);
                return CUSTOMER_ADD_SUCCESS;

            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return CUSTOMER_DUPLICATE_ERROR;
        }*/

        try {
            String sql = "INSERT INTO Customer(customerID, name, address, number) VALUES " + customer;
            System.out.println(sql);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);

        } catch (Exception e) {
            String msg = e.getMessage();
            System.out.println(msg);
            if (msg.contains("UNIQUE constraint failed"))
                return CUSTOMER_DUPLICATE_ERROR;
        }

        return CUSTOMER_ADD_SUCCESS;
    }

    public CustomerModel loadCustomer(int customerID) {
        CustomerModel customer = new CustomerModel();
        try {
            String sql = "SELECT customerID, name, address, number FROM Customer WHERE customerID = " + customerID;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            customer.customerID = rs.getInt("CustomerID");
            customer.name = rs.getString("Name");
            customer.address = rs.getString("Address");
            customer.number = rs.getString("Number");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return customer;
    }

    public int savePurchase(PurchaseModel purchase) {
        try {
            String sql = "INSERT INTO Purchases VALUES " + purchase;
            System.out.println(sql);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);

        } catch (Exception e) {
            String msg = e.getMessage();
            System.out.println(msg);
            if (msg.contains("UNIQUE constraint failed"))
                return PURCHASE_DUPLICATE_ERROR;
        }

        return PURCHASE_ADD_SUCCESS;

    }
}
