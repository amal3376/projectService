package dev.amalendu.projectservice;

import ch.qos.logback.core.joran.conditional.ThenAction;
import dev.amalendu.projectservice.inheritancedemo.tableperclass.Mentor;
import dev.amalendu.projectservice.inheritancedemo.tableperclass.MentorRepository;
import dev.amalendu.projectservice.inheritancedemo.tableperclass.User;
import dev.amalendu.projectservice.inheritancedemo.tableperclass.UserRepository;
import dev.amalendu.projectservice.inheritancedemo.tableperclass.MentorRepository;
import dev.amalendu.projectservice.models.Category;
import dev.amalendu.projectservice.models.Product;
import dev.amalendu.projectservice.repositories.CategoryRepository;
import dev.amalendu.projectservice.repositories.ProductRepository;
import org.apache.tomcat.util.http.fileupload.util.LimitedInputStream;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServer;

import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class ProjectServiceApplication implements CommandLineRunner {


	private MentorRepository mentorRepository;

	private UserRepository userRepository;
	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;

	public ProjectServiceApplication(@Qualifier("tpc_mr") MentorRepository mentorRepository,
									 @Qualifier("tpc_ur") UserRepository userRepository,
									 ProductRepository productRepository,
									 CategoryRepository categoryRepository){
		this.mentorRepository= mentorRepository;
		this.userRepository= userRepository;
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}

	public static void main(String[] args) {

		SpringApplication.run(ProjectServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Mentor mentor = new Mentor();
//		mentor.setName("Naman");
//		mentor.setEmail("naman@scaler.com");
//		mentor.setAverageRating(4.65);
//		mentorRepository.save(mentor);
//
//
//		User user = new User();
//		user.setName("Sarath");
//		user.setEmail("sarathcool@yopmail.com");
//		userRepository.save(user);
//
//		List<User> users = userRepository.findAll();
//		for (User user1:users
//		) {
//			System.out.println(user1);
//		}

		Category category = new Category();
		category.setName("Apple Services");
		Category savedCategory = categoryRepository.save(category);

		Product product = new Product();
		product.setTitle("iPhone 15 Pro");
		product.setDescription("The Bet iPhone Ever");
		product.setCategory(savedCategory);
		productRepository.save(product);

		Category category1 = categoryRepository.findById(UUID.fromString("002d44d5-3e01-4ef8-8a13-4c76a612af3d")).get();
		System.out.println("Category name is : " + category1.getName());

		System.out.println("Printing all Products in the category");

		Thread.sleep(1000);

		category1.getProducts().forEach(
				product1 -> System.out.println(product1.getTitle())
		);

//		for (Product product1: category1.getProducts()){
//			try{
//				System.out.println(product1.getTitle());
//			}catch (Exception e){
//				System.out.println(e.getMessage());
//			}


	}
}
