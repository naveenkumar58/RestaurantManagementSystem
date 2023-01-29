
public class Products {
	String productName, productPrice;
	Integer productQty;

	Products(String pName, String pPrice) {
		this.productName = pName;
		this.productPrice = pPrice;
	}

	Products(String pName, String pPrice, Integer pQty) {
		this.productName = pName;
		this.productPrice = pPrice;
		this.productQty = pQty;
	}

	Products() {
	}

	public Integer getProductQty() {
		return productQty;
	}

	public void setProductQty(Integer productQty) {
		this.productQty = productQty;
	}

	public void setProductName(String param) {
		this.productName = param;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductPrice(String param) {
		this.productPrice = param;
	}

	public String getProductPrice() {
		return this.productPrice;
	}

	public String toString() {
		return this.productName + "," + this.productPrice + "," + this.productQty;
	}
}
