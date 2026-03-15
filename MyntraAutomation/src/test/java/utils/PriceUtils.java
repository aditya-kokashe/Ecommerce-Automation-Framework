package utils;

public class PriceUtils {

	public static int convertPrice(String priceText) {

	    priceText = priceText.replace("₹", "");
	    priceText = priceText.replace(",", "");

	    return Integer.parseInt(priceText.trim());
	}
}