package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      CarService carService = context.getBean(CarService.class);

//      User user1 = new User("Jhon", "Malkovich", "jmmalk@gmail.com");
//      User user2 = new User("Robert", "Patisson", "mrvegi@yandex.ru");
//      User user3 = new User("Adolf", "Lungren", "gigel@yahoo.com");
//
//      Car car1 = new Car("BMW", 7);
//      Car car2 = new Car("Audi", 80);
//      Car car3 = new Car("Mersedes", 600);
//
//      car1.setUser(user1);
//      car2.setUser(user2);
//      car3.setUser(user3);
//
//      user1.setCar(car1);
//      user2.setCar(car2);
//      user3.setCar(car3);
//
//      userService.add(user1);
//      userService.add(user2);
//      userService.add(user3);
//
//      carService.addCar(car1);
//      carService.addCar(car2);
//      carService.addCar(car3);


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = " + user.getCar());
      }

      User oneOfUser = userService.getUser("BMW", 7);
      System.out.println("Id = " + oneOfUser.getId() +
              " FirstName = " + oneOfUser.getFirstName() +
              " LastName = " + oneOfUser.getLastName() +
              " Email = " + oneOfUser.getEmail());

      context.close();
   }
}
