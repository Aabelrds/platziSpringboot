package com.cursoPlatzi.springboot;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import com.cursoPlatzi.springboot.bean.MyBean;
import com.cursoPlatzi.springboot.bean.MyBeanProperties;
import com.cursoPlatzi.springboot.bean.MyBeanWithDependency;
import com.cursoPlatzi.springboot.component.ComponentDependency;
import com.cursoPlatzi.springboot.entity.User;
import com.cursoPlatzi.springboot.pojo.UserPojo;
import com.cursoPlatzi.springboot.repository.UserRepository;
import com.cursoPlatzi.springboot.service.UserService;

@SpringBootApplication
public class SpringbootApplication implements CommandLineRunner{
	
	Log LOGGER = LogFactory.getLog(SpringbootApplication.class);
	// Inyectamos las dependencias en el constructor de la clase principal 
	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanProperties myBeanProperties;
	private UserPojo userPojo;
	private UserRepository userRepository;
	private UserService userService;
	//@QUALIFIER INDICA QUE DEPENDENCIA QUIERES UTILIZAR.
	public SpringbootApplication(
			@Qualifier("componentImpl2") ComponentDependency componentDependency,
			MyBean myBean,
			MyBeanWithDependency myBeanWithDependency,
			MyBeanProperties myBeanProperties,
			UserPojo userPojo,
			UserRepository userRepository,
			UserService userService) {
		super();
		
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanProperties = myBeanProperties;
		this.userPojo = userPojo;
		this.userRepository = userRepository;
		this.userService = userService;
	}



	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}


//Por medio de CommandLineRunner podemos mostrar todas las dependencias con sus variables
	@Override
	public void run(String... args){
//		beforesExamples();
		saveUsersInDb();
		getInformationJpqlFromUser();
		saveWithErrorTransactional();
		


}
	private void saveWithErrorTransactional() {
		
		User test1 = new User("TestTransactional1", "TestTransactional1@domain.com", LocalDate.now());
		User test2 = new User("TestTransactional2", "TestTransactional2@domain.com", LocalDate.now());
		User test3 = new User("TestTransactional3", "TestTransactional3@domain.com", LocalDate.now());
		User test4 = new User("TestTransactional4", "TestTransactional4@domain.com", LocalDate.now());
		
		List<User> users = Arrays.asList(test1,test2,test3,test4);
		
		userService.saveTransactional(users);
		
		userService.getAllUsers().stream()
			.forEach(user -> LOGGER
					.info("Usuarios desde el método transactional " + user ));;
	}
	
	
	
	
	private void getInformationJpqlFromUser() {
//		LOGGER.info("Busqueda de usuario por email mediante queries " + 
//	userRepository.findByUserEmail("Mary@domain.com")
//		.orElseThrow(()-> new RuntimeException("El usuario no ha sido encontrado.")));
//		
//		userRepository.findAndSort("Isa", Sort.by("id").descending())
//		.stream()
//		.forEach(user -> LOGGER.info("Sort de usuario " + user));
//		
//		userRepository.findByName("Jhon")
//		.stream()
//		.forEach(user -> LOGGER.info("Usuario por query method " + user));
//		
//		LOGGER.info("Busqueda de usuario por query method findByEmailAndName " +
//		userRepository.findByEmailAndName("isa@domain.com", "Isabel")
//		.orElseThrow(()-> new RuntimeException("usuario no encontrado")));
		
		
		userRepository.findByNameLike("%Isa%")
		.stream()
		.forEach(user -> LOGGER.info("findByNameLike " + user));
		
		userRepository.findByNameOrEmail(null,"monica@domain.com" )
		.stream()
		.forEach(user -> LOGGER.info("findByNameOrEmail " + user));
		userRepository.findByNameOrEmail("Isavel",null)
		.stream()
		.forEach(user -> LOGGER.info("findByNameOrEmail " + user));
		
					
		LOGGER.info("findByBirthDateBetween " +
		userRepository.findByBirthDateBetween(LocalDate.of(2021, 01, 01), LocalDate.of(2021, 04, 30)));
		
		userRepository.findByNameLikeOrderByIdDesc("%Isa%")
		.stream()
		.forEach(user-> LOGGER.info("findByNameLikeOrderByIdDesc "+ user));
		
		userRepository.findByNameContainingOrderByIdAsc("Isa")
		.stream()
		.forEach(user-> LOGGER.info("findByNameContainingOrderByIdAsc "+ user));
		
		LOGGER.info("NAMED PARAMETERS" +
		userRepository.getAllByBirthDateAndEmail(LocalDate.of(2021,02,27),"jhon@domain.com" )
		.orElseThrow(()->new RuntimeException("No se ha encontrado dicho usurio ")));
	}
	
	private void saveUsersInDb() {
		
		User user1 = new User("Jhon", "jhon@domain.com",LocalDate.of(2021, 02, 27));
		User user2 = new User("Maria", "Mary@domain.com",LocalDate.of(2021, 04, 14));
		User user3 = new User("Isabelino", "juan@domain.com",LocalDate.of(2021, 07, 27));
		User user4 = new User("Isabel", "isa@domain.com",LocalDate.of(2021, 02, 27));
		User user5 = new User("Isavel", "monica@domain.com",LocalDate.of(2021, 01, 27));
		List<User> usersList = 
				Arrays.asList(user1,user2,user3,user4,user5);
		
		usersList.forEach(userRepository::save);
	}
	
	
	
	
	
	
//	private void beforesExamples() {
//		
//		this.componentDependency.sayHello();
//		this.myBean.print();
//		this.myBeanWithDependency.printWithDependency();
//		System.out.println(this.myBeanProperties.getValues());
//		System.out.println(this.userPojo.getEmail()+" POJO EXAMPLE WITH PROPERTIES VALUE");
//		//Con esto podemos debugear la app (ejemplo)
//		try {
//			// generando error
//			int value = 10/0;
//			LOGGER.debug("Mi valor generado con error es :" + " " +value);
//		} catch (Exception e) {
//			
//			LOGGER.error("Debugging error : " + e.getMessage());
//		}
//		
//	}
	
	
	}

