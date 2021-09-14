package com.aryan1403.UI;

import java.util.Iterator;
import javax.swing.JFrame;
import javax.swing.JPanel;
import com.aryan1403.DB.mongo;
import com.aryan1403.Helpers.Product;
import com.aryan1403.Merchandise.supplier;
import org.bson.Document;

public class UI {
    JFrame frame;

    private final int frameX = 1000;
    private final int frameY = 900;

    private int cardX = 100;
    private int cardY = 100;
    public UI() {
        addProduct();

        JPanel mainpanel = new JPanel();
        mainpanel.setBounds(0, 0, frameX, frameY);
        Iterator<Document> it = new mongo().retreive().iterator();
        while(it.hasNext()) {
            Document doc = it.next();
            mainpanel.add(new Card(cardX, cardY, new supplier(doc.get("pname").toString(), doc.get("pid").toString(), doc.get("purl").toString(), doc.get("pdesc").toString(), Double.parseDouble(doc.get("price").toString()), Integer.parseInt( doc.get("rating").toString()))));
            cardX += 300;
        }
        mainpanel.setLayout(null);

        frame = new JFrame();
        frame.setSize(frameX, frameY);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(3);
        frame.setLayout(null);
        frame.add(mainpanel);
        frame.setVisible(true);
    }

    public static void addProduct() {
        //supplier s = new supplier("Corsair Vengeance RAM", "1234", "https://m.media-amazon.com/images/I/61-oIjWmtCL._SL1200_.jpg", "Corsair Vengeance LPX 16GB (1x16GB) DDR4 3600MHz C18 Desktop Memory Black", 7199, 5);
        supplier s = new supplier("RAM", "123456", "https://m.media-amazon.com/images/I/61l4EStxhnL._SL1274_.jpg", "G.SKILL Trident Z RGB 32GB (2 * 16GB) DDR4 3200MHz CL16-18-18-38 1.35V Desktop Memory RAM - F4-3200C16D-32GTZR", 15037, 5);
        
        new Product().add(s);
    }
}
