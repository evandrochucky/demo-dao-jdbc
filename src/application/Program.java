package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

//		Department obj = new Department(1, "Books");
//		System.out.println(obj);
//		
//		Seller seller = new Seller(21, "Antonio" , "antonio@gmail.com", new Date(), 12354.56, obj);
//		System.out.println(seller);
		
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("==== Test 01: Seller findById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n=== Test 02: Seller findByDepartment ===");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== Test 03: Seller findAll ===");
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== Test 04: Seller insert ===");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4652.23, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());	
		System.out.println(newSeller);
		
		System.out.println("\n=== Test 05: Seller update ===");
		seller = sellerDao.findById(1);
		System.out.println("Before Update: " + seller);
		seller.setName("Martha Wayne");
		sellerDao.update(seller);
		System.out.println("After  Update: " + seller);
		System.out.println("Update completed!");
	}
}
