package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   public void saveCar(Car car){sessionFactory.getCurrentSession().save(car);}

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }
   @Override
   public User selectUserFromCar(String model,int series){
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery
              ("from User u inner join fetch u.car uc where uc.model =:param1 and uc.series=:param2");
      query.setParameter("param1",model);
      query.setParameter("param2",series);
      return query.getResultList().get(0);
   }

}
