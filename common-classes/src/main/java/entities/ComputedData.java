package entities;

import java.io.Serializable;

/**
 * Created by Vlad on 13-Nov-17.
 */
public class ComputedData implements Serializable {

    private double tax;

    private double sellingPrice;

    public ComputedData(double tax, double sellingPrice) {
        this.tax = tax;
        this.sellingPrice = sellingPrice;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }
}
