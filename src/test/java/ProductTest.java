import junit.framework.TestCase;

public class ProductTest extends TestCase {

	protected Product myproduct;
	Product product1=new Product("apple",25);
	Product product2=new Product("cola",30);
	Product product3=new Product("egg",20);
	Product product4=new Product("cake",50);
	protected ShoppingCart myShoppingCart;
	//protected ProductNotFoundException myProductNotFoundException;
	
	protected void setUp() {
		myproduct = new Product("apple",25);
		myShoppingCart = new ShoppingCart();
		//myProductNotFoundException = new ProductNotFoundException();
		myShoppingCart.addItem(product1);
		myShoppingCart.addItem(product2);
		myShoppingCart.addItem(product3);
	}
	//1a
	public void test_product1() {
		assertEquals(myproduct.equals(product1),true);
	}
	public void test_product2() {
		assertEquals(myproduct.equals(product2),false);
	}
	//1b
	public void test_ShoppingCart_addItem() {
		myShoppingCart.addItem(product4);
		assertEquals(myShoppingCart.getItemCount(),4);
	}
	public void test_ShoppingCart_getBalance() {
		assertEquals(myShoppingCart.getBalance(),75.0);
	}
	public void test_ShoppingCart_removeItem() throws ProductNotFoundException {
		myShoppingCart.removeItem(product3);
		assertEquals(myShoppingCart.getItemCount(),2);
	}
	public void test_ShoppingCart_getItemCount() {
		assertEquals(myShoppingCart.getItemCount(),3);
	}
	public void test_ShoppingCart_empty() {
		myShoppingCart.empty();
		assertEquals(myShoppingCart.getItemCount(),0);
	}
	//1c
	public void test_ProductNotFoundException_ProductNotFoundException() {
		try{
			myShoppingCart.removeItem(product4);
			fail("should raise a ProductNotFoundException");
		}
		catch(ProductNotFoundException expected){
			//pass
		}
	}
	//2a
	public void test_big_bang1() throws ProductNotFoundException {
		myShoppingCart.empty();
		myShoppingCart.addItem(product1);
		myShoppingCart.addItem(product2);
		myShoppingCart.removeItem(product1);
		try{
			myShoppingCart.removeItem(product3);
		}
		catch(ProductNotFoundException expected){
			//pass
		}
		myShoppingCart.addItem(product3);
		myShoppingCart.addItem(product4);
		assertEquals(myShoppingCart.getBalance(),100.0);
		assertEquals(product1.getTitle(),"apple");
		assertEquals(product1.getPrice(),25.0);
	}
	public void test_big_bang2() throws ProductNotFoundException {
		myShoppingCart.empty();
		myShoppingCart.addItem(product1);
		myShoppingCart.addItem(product2);
		myShoppingCart.removeItem(product1);
		try{
			myShoppingCart.removeItem(product3);
		}
		catch(ProductNotFoundException expected){
			//pass
		}
		myShoppingCart.addItem(product3);
		myShoppingCart.addItem(product4);
		assertEquals(myShoppingCart.getItemCount(),3);
		assertEquals(myproduct.equals(product1),true);
	}
	/*
	public void test_ShoppingCart_half() {
		assertEquals(myShoppingCart.half(product2),15);	//軟工錯誤測試
	}
	*/
	//2b
	public void test_bottom_up_Product_ShoppingCart(){
		myShoppingCart.empty();
		myShoppingCart.addItem(product1);
		myShoppingCart.addItem(product2);
		myShoppingCart.addItem(product3);
		myShoppingCart.addItem(product4);
		assertEquals(myShoppingCart.getBalance(),125.0);
		assertEquals(myShoppingCart.getItemCount(),4);
		assertEquals(product1.getTitle(),"apple");
		assertEquals(product1.getPrice(),25.0);
		assertEquals(myproduct.equals(product1),true);
	}
	public void test_bottom_up_Product_ShoppingCart_ProductNotFoundException() throws ProductNotFoundException{
		myShoppingCart.empty();
		myShoppingCart.addItem(product1);
		myShoppingCart.addItem(product2);
		myShoppingCart.removeItem(product1);
		try{
			myShoppingCart.removeItem(product3);
		}
		catch(ProductNotFoundException expected){
			//pass
		}
		myShoppingCart.addItem(product3);
		myShoppingCart.addItem(product4);
		assertEquals(myShoppingCart.getBalance(),100.0);
		assertEquals(myShoppingCart.getItemCount(),3);
		assertEquals(product1.getTitle(),"apple");
		assertEquals(product1.getPrice(),25.0);
		assertEquals(myproduct.equals(product1),true);
	}
}
