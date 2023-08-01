package hiber.dao;

import hiber.model.Car;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

public interface CarDao {
    @Transactional
    public void addCar(Car car);
}
