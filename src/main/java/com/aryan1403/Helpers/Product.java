package com.aryan1403.Helpers;

import com.aryan1403.DB.mongo;
import com.aryan1403.Merchandise.supplier;

// Add the Supplier to the Database
public class Product {
    public void add(supplier s) {
        new mongo().add(s);
    }
}
