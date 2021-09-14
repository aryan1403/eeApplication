package com.aryan1403.UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com.aryan1403.Helpers.ImageD;
import com.aryan1403.Merchandise.supplier;

public class Card extends JPanel {
    private final int width = 250;
    private final int height = 400;
    public Card(int x, int y, supplier s) {
        new ImageD().getImage(s.getProductImageURL(), s.getProductName()+s.getProductID());

        Image image = new ImageIcon(s.getProductName()+s.getProductID()+".jpg").getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        JLabel label = new JLabel(new ImageIcon(image));
        label.setBounds(0, 0, 250, 250);
        label.setBorder(BorderFactory.createMatteBorder(2, 2, 0, 2, Color.black));
        label.setLayout(null);

        JLabel desc = new JLabel(s.getProductName() +  "\n"+ s.getProductDesc());
        desc.setBounds(0, 250, width, 100);
        desc.setFont(new Font("Comic Sans", Font.PLAIN, 15));
        desc.setLayout(null);

        this.setBounds(x, y, width, height);
        this.add(label);
        this.add(desc);
        this.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
        this.setLayout(null);
    }
}
