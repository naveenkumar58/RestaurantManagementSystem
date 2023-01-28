
public class Products {
	String productName, productPrice;

	Products(String pName, String pPrice) {
		productName = pName;
		productPrice = pPrice;
	}

	Products() {

	}

	public void setProductName(String param) {
		this.productName = param;
	}

	public String getProdctName() {
		return this.productName;
	}

	public void setProductPrice(String param) {
		this.productPrice = param;
	}

	public String getProductPrice() {
		return this.productPrice;
	}

	public String toString() {
		return this.productName + "," + this.productPrice;
	}
}
