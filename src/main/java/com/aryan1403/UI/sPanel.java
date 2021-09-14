package com.aryan1403.UI;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import com.aryan1403.Helpers.Product;
import com.aryan1403.Merchandise.supplier;

public class sPanel extends JPanel {
    JTextField pname;
    JTextField pid;
    JTextField purl;
    JTextArea desc;
    JTextField price;
    JComboBox<Integer> rating;

    JButton submit;

    public sPanel() {
        pname = new JTextField("Enter Product name");
        pname.setBounds(50, 50, 300, 40);
        pname.setFont(new Font("Comic Sans", Font.PLAIN, 16));
        pname.setLayout(null);

        rating = new JComboBox<>();
        rating.setBounds(370, 50, 100, 40);
        rating.addItem(1);
        rating.addItem(2);
        rating.addItem(3);
        rating.addItem(4);
        rating.addItem(5);
        rating.setLayout(null);

        pid = new JTextField("Enter Product ID");
        pid.setBounds(50, 100, 300, 40);
        pid.setFont(new Font("Comic Sans", Font.PLAIN, 16));
        pid.setLayout(null);

        purl = new JTextField("Enter product URL");
        purl.setBounds(50, 150, 300, 40);
        purl.setFont(new Font("Comic Sans", Font.PLAIN, 16));
        purl.setLayout(null);

        price = new JTextField("Enter price");
        price.setBounds(370, 150, 300, 40);
        price.setFont(new Font("Comic Sans", Font.PLAIN, 16));
        price.setLayout(null);

        desc = new JTextArea("Enter Product Descripion");
        desc.setBounds(50, 200, 300, 200);
        desc.setFont(new Font("Comic Sans", Font.PLAIN, 16));
        desc.setBorder(BorderFactory.createLineBorder(Color.black));
        desc.setLayout(null);        

        submit = new JButton("Submit");
        submit.setBounds(50, 450, 100, 50);
        submit.setFocusable(false);
        submit.setBackground(Color.green);
        submit.setForeground(Color.white);
        submit.setFont(new Font("Comic Sans", Font.BOLD, 16));
        submit.setLayout(null);
        submit.addActionListener(e -> {
            // Creating a supplier Object
            supplier s = new supplier(pname.getText(), pid.getText(), purl.getText(), desc.getText(), Double.parseDouble(price.getText()), Integer.parseInt(rating.getSelectedItem().toString()));
            // Adding that object to DB
            new Product().add(s);
            // Adding a new Card for the Product
            UI.mainpanel.add(new Card(UI.cardX, UI.cardY, s));
            UI.cardX += 200; // Increase X pos
            UI.frame.repaint(); // Reapint the Frame
        });

        this.setBounds(0, 0, UI.frameX, UI.frameY);
        this.add(pname);
        this.add(rating);
        this.add(pid);
        this.add(purl);
        this.add(price);
        this.add(desc);
        this.add(submit);
        this.setLayout(null);
    }
}
