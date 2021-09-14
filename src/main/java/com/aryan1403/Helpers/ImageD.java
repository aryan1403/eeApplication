package com.aryan1403.Helpers;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

// Get Image from URL & Save it as a jpg file
public class ImageD {
    public void getImage(String u, String filename) {
        try {
            URL url = new URL(u);
            InputStream in = new BufferedInputStream(url.openStream());
            OutputStream out = new BufferedOutputStream(new FileOutputStream(filename+".jpg"));

            for (int i; (i = in.read()) != -1;) {
                out.write(i); // Write the response
            }
            in.close();  // Close
            out.close(); // Close
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
