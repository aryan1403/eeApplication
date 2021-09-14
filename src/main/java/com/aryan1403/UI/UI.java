package com.aryan1403.UI;

import java.util.Iterator;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import com.aryan1403.DB.mongo;
import com.aryan1403.Helpers.Product;
import com.aryan1403.Merchandise.supplier;
import org.bson.Document;

/*
 * Developer : Aaryan
 * UI for the Application
*/
public class UI {
    public static JFrame frame;
    public static JPanel mainpanel;

    public final static int frameX = 1000;
    public final static int frameY = 700;

    public static int cardX = 30;
    public static int cardY = 100;

    public UI() {
        // addProduct();

        mainpanel = new JPanel();
        mainpanel.setBounds(0, 0, frameX - 150, frameY - 300);
        // Iterator object of type Documents
        Iterator<Document> it = new mongo().retreive().iterator();
        // Loop through all the Documents inside the Collection
        while (it.hasNext()) {
            Document doc = it.next();
            // Create a supplier object with document data and add it to the mainpanel
            mainpanel.add(new Card(cardX, cardY,
                    new supplier(doc.get("pname").toString(), doc.get("pid").toString(), doc.get("purl").toString(),
                            doc.get("pdesc").toString(), Double.parseDouble(doc.get("price").toString()),
                            Integer.parseInt(doc.get("rating").toString()))));
            cardX += 300; // Increase the X pos of Card
        }
        mainpanel.setLayout(null);

        // Added Panes
        JTabbedPane pane = new JTabbedPane();
        pane.setBounds(20, 30, frameX - 50, frameY - 120);
        pane.addTab("Products", mainpanel);
        pane.addTab("Supplier", new sPanel());

        frame = new JFrame();
        frame.setSize(frameX, frameY);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(3);
        frame.setLayout(null);
        frame.add(pane);
        frame.setVisible(true);
    }
}
