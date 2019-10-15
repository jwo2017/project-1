import javax.swing.*;

public class javaApp {

    IDataAdapter adapter = null;
    public static final String DBMS_SQ_LITE = "SQLite";
    public static final String DB_FILE = "/Users/jonathan/documents/activity11.db";

    private static javaApp instance = null;


    public static javaApp getInstance() {
        if (instance == null) {
            String dbfile = DB_FILE;
            JFileChooser fc = new JFileChooser();

            if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
                dbfile = fc.getSelectedFile().getAbsolutePath();

            instance = new javaApp(DBMS_SQ_LITE, dbfile);
        }
        return instance;
    }

    private javaApp(String dbms, String dbfile) {
        if (dbms.equals("Oracle"))
            adapter = new OracleDataAdapter();
        else
        if (dbms.equals("SQLite"))
            adapter = new SQLDataBase();

        adapter.connect(dbfile);

    }

    public IDataAdapter getDataAdapter() {
        return adapter;
    }

    public void setDataAdapter(IDataAdapter a) {
        adapter = a;
    }

    public void run() {
        MainUI ui = new MainUI();
        ui.view.setVisible(true);

    }

/*
    public static void main(String[] args) {
        AddProductView frame = new AddProductView();
        SQLDataBase adapter = new SQLDataBase();

        AddProductController control = new AddProductController(frame, adapter);

ProductModel product = adapter.loadProduct(3);
      //  control.view = frame;
  //  control.adapter = adapter;

        frame.pack();
        frame.setVisible(true);
        frame.btnAdd.addActionListener(control.addButtonListener);
        frame.btnCancel.addActionListener(control.cancelButtonListener);

    }
*/

public static void main(String[] args) {
    System.out.println("Hello class!");
 //   javaApp.getInstance().init();

    javaApp.getInstance().run();
    /*
    AddProductView ap = new AddProductView();
    ap.run();
    AddCustomerView cp = new AddCustomerView();
    cp.run();
    */

}
}
