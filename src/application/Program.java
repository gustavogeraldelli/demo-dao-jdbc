package application;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST 1: seller findById ===");
		Seller s = sellerDao.findById(3);
		System.out.println(s);
		
		System.out.println("\n=== TEST 2: seller findByDepartment ===");
		List<Seller> list = sellerDao.findByDepartment(new Department(2, null));
		list.forEach(System.out::println);
		
		System.out.println("\n=== TEST 3: seller findAll ===");
		list = sellerDao.findAll();
		list.forEach(System.out::println);
		
		System.out.println("\n=== TEST 4: seller insert ===");
		Seller newSeller = new Seller(null, "Greg", "greg@mail.com", LocalDate.now(), 4500.0, new Department(2, null));
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
		
		System.out.println("\n=== TEST 5: seller update ===");
		s = sellerDao.findById(1);
		s.setName("Walter White");
		sellerDao.update(s);
		System.out.println("Update completed");
		
		System.out.println("\n=== TEST 6: seller delete ===");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed");
		
		sc.close();
	}

}
