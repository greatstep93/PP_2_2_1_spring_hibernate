package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);


      Car car1 = new Car("BMW",1);
      Car car2 = new Car("VAZ",2);
      Car car3 = new Car("VOLGA",3);
      Car car4 = new Car("AUDI",4);

      userService.saveCar(car1);
      userService.saveCar(car2);
      userService.saveCar(car3);
      userService.saveCar(car4);

      userService.add(new User("Мария", "Лескова", "maria@mail.ru",car4));
      userService.add(new User("Дмитрий", "Горбачев", "dmitriy@mail.ru",car2));
      userService.add(new User("Алексей", "Сторожев", "alexey@mail.ru",car1));
      userService.add(new User("Александр", "Иванов", "alexandr@mail.ru",car3));

      System.out.println(userService.selectUserFromCar("AUDI",4));



//      List<User> users = userService.listUsers();
//      for (User user : users) {
//         System.out.println(user);
//         System.out.println();
//      }

      context.close();
   }
}
