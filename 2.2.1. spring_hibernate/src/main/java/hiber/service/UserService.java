package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);

    void saveCar(Car car);
    List<User> listUsers();
    User selectUserFromCar(String model,int series);
}
