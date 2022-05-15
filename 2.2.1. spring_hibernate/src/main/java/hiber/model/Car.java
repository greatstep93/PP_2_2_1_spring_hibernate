package hiber.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "model")
    private String model;
    @Column(name = "series")
    private int series;


    public Car(String model,int series){
        this.model = model;
        this.series = series;
    }

    public Car() {

    }

    public long getId() {return id;}
    public void setId(long id) {this.id = id;}

    public String getModel() {return model;}
    public void setModel(String model) {this.model = model;}

    public int getSeries() {return series;}
    public void setSeries(int series) {this.series = series;}

    @Override
    public String toString() {
        return "Car model: " + model + "( " + series + " series )";
    }
}
