import junit.framework.TestCase;

public class ProductTest extends TestCase {

	protected Product myproduct;
	Product product1=new Product("可口可樂",25);
	Product product2=new Product("黑松沙士",30);
	Product product3=new Product("蘋果麵包",20);
	Product product4=new Product("牛奶",50);
	protected ShoppingCart myShoppingCart;
	//protected ProductNotFoundException myProductNotFoundException;
	
	protected void setUp() {
		myproduct = new Product("可口可樂",25);
		myShoppingCart = new ShoppingCart();
		//myProductNotFoundException = new ProductNotFoundException();
		myShoppingCart.addItem(product1);
		myShoppingCart.addItem(product2);
		myShoppingCart.addItem(product3);
	}
	//1a
	public void test_product1() {
		assertEquals(myproduct.equals(product1),true);	//myproduct與product1應是一樣的產絣
	}
	public void test_product2() {
		assertEquals(myproduct.equals(product2),false);	//myproduct與product2應是不一樣的產絣
	}
	//1b
	public void test_ShoppingCart_addItem() {
		myShoppingCart.addItem(product4);	//增加product4到myShoppingCart
		assertEquals(myShoppingCart.getItemCount(),3);	//此時商品數量應是4個
	}
	public void test_ShoppingCart_getBalance() {
		assertEquals(myShoppingCart.getBalance(),75.0);	//myShoppingCart目前有product1、product2、product3，總價應是75元
	}
	public void test_ShoppingCart_removeItem() throws ProductNotFoundException {
		myShoppingCart.removeItem(product3);	//從myShoppingCart移除product3
		assertEquals(myShoppingCart.getItemCount(),2);	//此時商品數量應是2個
	}
	public void test_ShoppingCart_getItemCount() {
		assertEquals(myShoppingCart.getItemCount(),3);	//此時商品數量應是3個
	}
	public void test_ShoppingCart_empty() {
		myShoppingCart.empty();	//將myShoppingCart清空
		assertEquals(myShoppingCart.getItemCount(),0);	//此時商品數量應是0個
	}
	//1c
	public void test_ProductNotFoundException_ProductNotFoundException() {
		try{
			myShoppingCart.removeItem(product4);	//從myShoppingCart移除不存在其中的product4
			fail("should raise a ProductNotFoundException");
		}
		catch(ProductNotFoundException expected){
			//pass
		}
	}
	//2a
	public void test_big_bang1() throws ProductNotFoundException {
		myShoppingCart.empty();	//清空
		myShoppingCart.addItem(product1);	//增加product1
		myShoppingCart.addItem(product2);	//增加product2
		myShoppingCart.removeItem(product1);	//移除product1
		try{
			myShoppingCart.removeItem(product3);	//移除不存在的product3
		}
		catch(ProductNotFoundException expected){
			//pass
		}
		myShoppingCart.addItem(product3);	//增加product3
		myShoppingCart.addItem(product4);	//增加product4
		assertEquals(myShoppingCart.getBalance(),100.0);	//myShoppingCart目前有product2、product3、product4，總價應是100元
		assertEquals(product1.getTitle(),"可口可樂");	//product1的商品名稱為可口可樂
		assertEquals(product1.getPrice(),25.0);	//product1的價錢為25
	}
	public void test_big_bang2() throws ProductNotFoundException {
		myShoppingCart.empty();	//清空
		myShoppingCart.addItem(product1);	//增加product1
		myShoppingCart.addItem(product2);	//增加product2
		myShoppingCart.removeItem(product1);	//移除product1
		try{
			myShoppingCart.removeItem(product3);	//移除不存在的product3
		}
		catch(ProductNotFoundException expected){
			//pass
		}
		myShoppingCart.addItem(product3);	//增加product3
		myShoppingCart.addItem(product4);	//增加product4
		assertEquals(myShoppingCart.getItemCount(),3);	//myShoppingCart目前有product2、product3、product4，總商品數是3個
		assertEquals(myproduct.equals(product1),true);	//myproduct與product1應是一樣的產絣
	}
	//2b
	public void test_bottom_up_Product_ShoppingCart(){
		myShoppingCart.empty();	//清空
		myShoppingCart.addItem(product1);	//增加product1
		myShoppingCart.addItem(product2);	//增加product2
		myShoppingCart.addItem(product3);	//增加product3
		myShoppingCart.addItem(product4);	//增加product4
		assertEquals(myShoppingCart.getBalance(),125.0);	//myShoppingCart目前有product1、product2、product3、product4，總價應是125元
		assertEquals(myShoppingCart.getItemCount(),4);	//myShoppingCart目前有product1、product2、product3、product4，總商品數是4個
		assertEquals(product1.getTitle(),"可口可樂");	//product1的商品名稱為可口可樂
		assertEquals(product1.getPrice(),25.0);	//product1的價錢為25
		assertEquals(myproduct.equals(product1),true);	//myproduct與product1應是一樣的產絣
	}
	public void test_bottom_up_Product_ShoppingCart_ProductNotFoundException() throws ProductNotFoundException{
		myShoppingCart.empty();	//清空
		myShoppingCart.addItem(product1);	//增加product1
		myShoppingCart.addItem(product2);	//增加product2
		myShoppingCart.removeItem(product1);	//移除product1
		try{
			myShoppingCart.removeItem(product3);	//移除不存在的product3
		}
		catch(ProductNotFoundException expected){
			//pass
		}
		myShoppingCart.addItem(product3);	//增加product3
		myShoppingCart.addItem(product4);	//增加product4
		assertEquals(myShoppingCart.getBalance(),100.0);	//myShoppingCart目前有product2、product3、product4，總價應是100元
		assertEquals(myShoppingCart.getItemCount(),3);	//myShoppingCart目前有product2、product3、product4，總商品數是3個
		assertEquals(product1.getTitle(),"可口可樂");	//product1的商品名稱為可口可樂
		assertEquals(product1.getPrice(),25.0);	//product1的價錢為25
		assertEquals(myproduct.equals(product1),true);	//myproduct與product1應是一樣的產絣
	}
}
