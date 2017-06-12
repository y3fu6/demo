import junit.framework.TestCase;

public class ProductTest extends TestCase {

	protected Product myproduct;
	Product product1=new Product("�i�f�i��",25);
	Product product2=new Product("�ªQ�F�h",30);
	Product product3=new Product("ī�G�ѥ]",20);
	Product product4=new Product("����",50);
	protected ShoppingCart myShoppingCart;
	//protected ProductNotFoundException myProductNotFoundException;
	
	protected void setUp() {
		myproduct = new Product("�i�f�i��",25);
		myShoppingCart = new ShoppingCart();
		//myProductNotFoundException = new ProductNotFoundException();
		myShoppingCart.addItem(product1);
		myShoppingCart.addItem(product2);
		myShoppingCart.addItem(product3);
	}
	//1a
	public void test_product1() {
		assertEquals(myproduct.equals(product1),true);	//myproduct�Pproduct1���O�@�˪�����
	}
	public void test_product2() {
		assertEquals(myproduct.equals(product2),false);	//myproduct�Pproduct2���O���@�˪�����
	}
	//1b
	public void test_ShoppingCart_addItem() {
		myShoppingCart.addItem(product4);	//�W�[product4��myShoppingCart
		assertEquals(myShoppingCart.getItemCount(),4);	//���ɰӫ~�ƶq���O4��
	}
	public void test_ShoppingCart_getBalance() {
		assertEquals(myShoppingCart.getBalance(),75.0);	//myShoppingCart�ثe��product1�Bproduct2�Bproduct3�A�`�����O75��
	}
	public void test_ShoppingCart_removeItem() throws ProductNotFoundException {
		myShoppingCart.removeItem(product3);	//�qmyShoppingCart����product3
		assertEquals(myShoppingCart.getItemCount(),2);	//���ɰӫ~�ƶq���O2��
	}
	public void test_ShoppingCart_getItemCount() {
		assertEquals(myShoppingCart.getItemCount(),3);	//���ɰӫ~�ƶq���O3��
	}
	public void test_ShoppingCart_empty() {
		myShoppingCart.empty();	//�NmyShoppingCart�M��
		assertEquals(myShoppingCart.getItemCount(),0);	//���ɰӫ~�ƶq���O0��
	}
	//1c
	public void test_ProductNotFoundException_ProductNotFoundException() {
		try{
			myShoppingCart.removeItem(product4);	//�qmyShoppingCart�������s�b�䤤��product4
			fail("should raise a ProductNotFoundException");
		}
		catch(ProductNotFoundException expected){
			//pass
		}
	}
	//2a
	public void test_big_bang1() throws ProductNotFoundException {
		myShoppingCart.empty();	//�M��
		myShoppingCart.addItem(product1);	//�W�[product1
		myShoppingCart.addItem(product2);	//�W�[product2
		myShoppingCart.removeItem(product1);	//����product1
		try{
			myShoppingCart.removeItem(product3);	//�������s�b��product3
		}
		catch(ProductNotFoundException expected){
			//pass
		}
		myShoppingCart.addItem(product3);	//�W�[product3
		myShoppingCart.addItem(product4);	//�W�[product4
		assertEquals(myShoppingCart.getBalance(),100.0);	//myShoppingCart�ثe��product2�Bproduct3�Bproduct4�A�`�����O100��
		assertEquals(product1.getTitle(),"�i�f�i��");	//product1���ӫ~�W�٬��i�f�i��
		assertEquals(product1.getPrice(),25.0);	//product1��������25
	}
	public void test_big_bang2() throws ProductNotFoundException {
		myShoppingCart.empty();	//�M��
		myShoppingCart.addItem(product1);	//�W�[product1
		myShoppingCart.addItem(product2);	//�W�[product2
		myShoppingCart.removeItem(product1);	//����product1
		try{
			myShoppingCart.removeItem(product3);	//�������s�b��product3
		}
		catch(ProductNotFoundException expected){
			//pass
		}
		myShoppingCart.addItem(product3);	//�W�[product3
		myShoppingCart.addItem(product4);	//�W�[product4
		assertEquals(myShoppingCart.getItemCount(),3);	//myShoppingCart�ثe��product2�Bproduct3�Bproduct4�A�`�ӫ~�ƬO3��
		assertEquals(myproduct.equals(product1),true);	//myproduct�Pproduct1���O�@�˪�����
	}
	//2b
	public void test_bottom_up_Product_ShoppingCart(){
		myShoppingCart.empty();	//�M��
		myShoppingCart.addItem(product1);	//�W�[product1
		myShoppingCart.addItem(product2);	//�W�[product2
		myShoppingCart.addItem(product3);	//�W�[product3
		myShoppingCart.addItem(product4);	//�W�[product4
		assertEquals(myShoppingCart.getBalance(),125.0);	//myShoppingCart�ثe��product1�Bproduct2�Bproduct3�Bproduct4�A�`�����O125��
		assertEquals(myShoppingCart.getItemCount(),4);	//myShoppingCart�ثe��product1�Bproduct2�Bproduct3�Bproduct4�A�`�ӫ~�ƬO4��
		assertEquals(product1.getTitle(),"�i�f�i��");	//product1���ӫ~�W�٬��i�f�i��
		assertEquals(product1.getPrice(),25.0);	//product1��������25
		assertEquals(myproduct.equals(product1),true);	//myproduct�Pproduct1���O�@�˪�����
	}
	public void test_bottom_up_Product_ShoppingCart_ProductNotFoundException() throws ProductNotFoundException{
		myShoppingCart.empty();	//�M��
		myShoppingCart.addItem(product1);	//�W�[product1
		myShoppingCart.addItem(product2);	//�W�[product2
		myShoppingCart.removeItem(product1);	//����product1
		try{
			myShoppingCart.removeItem(product3);	//�������s�b��product3
		}
		catch(ProductNotFoundException expected){
			//pass
		}
		myShoppingCart.addItem(product3);	//�W�[product3
		myShoppingCart.addItem(product4);	//�W�[product4
		assertEquals(myShoppingCart.getBalance(),100.0);	//myShoppingCart�ثe��product2�Bproduct3�Bproduct4�A�`�����O100��
		assertEquals(myShoppingCart.getItemCount(),3);	//myShoppingCart�ثe��product2�Bproduct3�Bproduct4�A�`�ӫ~�ƬO3��
		assertEquals(product1.getTitle(),"�i�f�i��");	//product1���ӫ~�W�٬��i�f�i��
		assertEquals(product1.getPrice(),25.0);	//product1��������25
		assertEquals(myproduct.equals(product1),true);	//myproduct�Pproduct1���O�@�˪�����
	}
}
