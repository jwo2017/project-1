import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddProductView extends JFrame {


    public JFrame view;
    public JButton btnAdd = new JButton("Add");
    public JButton btnCancel = new JButton("Cancel");

    public JTextField txtProductID = new JTextField(20);
    public JTextField txtName = new JTextField(20);
    public JTextField txtPrice = new JTextField(20);
    public JTextField txtQuantity = new JTextField(20);



    public AddProductView() {

        this.view = new JFrame();

        view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        view.setTitle("Add Product");
        view.setSize(600,400);
        view.getContentPane().setLayout(new BoxLayout(view.getContentPane(), BoxLayout.PAGE_AXIS));


        String[] labels = {"Product ID ", "Name ", "Price ", "Quantity "};
    /*    int numPairs = labels.length;

       //Object p = this.getContentPane();
        for (int i = 0; i < numPairs; i++) {
            JLabel l = new JLabel(labels[i], JLabel.TRAILING);
            JPanel p = new JPanel(new FlowLayout());
            this.getContentPane().add(p);
            p.add(l);
            JTextField textField = new JTextField(10);
            l.setLabelFor(textField);
            p.add(textField);
        }
*/

/*
        JTextField txtProductID = new JTextField(30);
        JTextField txtProductName = new JTextField(30);
        JTextField txtProductPrice = new JTextField(30);
        JTextField txtProductQuantity = new JTextField(30);
        JTextField txtProductVendor = new JTextField(30);

*/



        JPanel line1 = new JPanel();
        line1.add(new JLabel("Product ID"));
        line1.add(txtProductID);
        view.getContentPane().add(line1);

        JPanel line2 = new JPanel();
        line2.add(new JLabel("Name"));
        line2.add(txtName);
        view.getContentPane().add(line2);

        JPanel line3 = new JPanel();
        line3.add(new JLabel("Price"));
        line3.add(txtPrice);
        view.getContentPane().add(line3);

        JPanel line4 = new JPanel();
        line4.add(new JLabel("Quantity"));
        line4.add(txtQuantity);
        view.getContentPane().add(line4);

        JPanel panelButtons = new JPanel(new FlowLayout());
        panelButtons.add(btnAdd);
        panelButtons.add(btnCancel);
        view.getContentPane().add(panelButtons);

        btnAdd.addActionListener(new AddButtonListener());

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
view.dispose();            }
        });
    }

    public void run() {
        view.setVisible(true);
    }

    class AddButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            ProductModel product = new ProductModel();

            String id = txtProductID.getText();

            if (id.length() == 0) {
                JOptionPane.showMessageDialog(null, "ProductID cannot be null!");
                return;
            }

            try {
                product.productID = Integer.parseInt(id);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "ProductID is invalid!");
                return;
            }

            String name = txtName.getText();
            if (name.length() == 0) {
                JOptionPane.showMessageDialog(null, "Product name cannot be empty!");
                return;
            }

            product.name = name;

            String price = txtPrice.getText();
            try {
                product.price = Double.parseDouble(price);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Price is invalid!");
                return;
            }

            String quant = txtQuantity.getText();
            try {
                product.quantity = Integer.parseInt(quant);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Quantity is invalid!");
                return;
            }

            switch (javaApp.getInstance().getDataAdapter().saveProduct(product)) {
                case SQLDataBase.PRODUCT_DUPLICATE_ERROR:
                    JOptionPane.showMessageDialog(null, "Product NOT added successfully! Duplicate product ID!");
                default:
                    JOptionPane.showMessageDialog(null, "Product added successfully!" + product);
            }
        }
    }


}