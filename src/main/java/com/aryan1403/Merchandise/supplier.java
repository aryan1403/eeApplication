package com.aryan1403.Merchandise;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
@Getter
@Setter
public class supplier {
    String productName;
    String productID;
    String productImageURL;
    String productDesc;

    double price;
    int rating;
}
