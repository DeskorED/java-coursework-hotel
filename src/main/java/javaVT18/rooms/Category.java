package javavt18.rooms;

import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="category")
@NamedQuery(name="category.findAll", query="select m from category m")

public class Category implements Serializable {
    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    private int idCategory;

    @ManyToOne
    @JoinColumn(name = "idCategory")

    @NotEmpty @Column private String Name;
    @Column private boolean wifi;
    @Column private boolean breakfast;
    @Column private boolean dinner;
    @Column private boolean jacuzzi;
    @Column private boolean tv;
    @Column private short price;
    @Column private byte numberOfPlaces;

    public Category() {}

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public boolean isWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    public boolean isBreakfast() {
        return breakfast;
    }

    public void setBreakfast(boolean breakfast) {
        this.breakfast = breakfast;
    }

    public boolean isDinner() {
        return dinner;
    }

    public void setDinner(boolean dinner) {
        this.dinner = dinner;
    }

    public boolean isJacuzzi() {
        return jacuzzi;
    }

    public void setJacuzzi(boolean jacuzzi) {
        this.jacuzzi = jacuzzi;
    }

    public boolean isTv() {
        return tv;
    }

    public void setTv(boolean tv) {
        this.tv = tv;
    }

    public short getPrice() {
        return price;
    }

    public void setPrice(short price) {
        this.price = price;
    }

    public byte getNumberOfPlaces() {
        return numberOfPlaces;
    }

    public void setNumberOfPlaces(byte numberOfPlaces) {
        this.numberOfPlaces = numberOfPlaces;
    }

    @Override
    public String toString() {
        return "Category{" +

                "idCategory=" + idCategory +
                ", Name='" + Name + '\'' +
                ", wifi=" + wifi +
                ", breakfast=" + breakfast +
                ", dinner=" + dinner +
                ", jacuzzi=" + jacuzzi +
                ", tv=" + tv +
                ", price=" + price +
                ", numberOfPlaces=" + numberOfPlaces +
                '}';
    }
}