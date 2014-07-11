package apartment.domain;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by yar on 5/23/14.
 */
@Entity
public class Bid implements Comparable{
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "id_apartment")
    @NotNull
    private Apartment apartment;

    @NotNull
    @Min(value = 0)
    private Double price;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @Column(nullable = false)
    @ManyToOne()
    @JoinColumn(name = "id_client")
    @NotNull
    private Client client;

    private Date date=new Date();


    public Bid() {
    }

    public Bid(Apartment apartment, Double price, Client client) {
        this.apartment = apartment;
        this.price = price;
        this.client=client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public int compareTo(Object o) {
        Bid bid = (Bid) o;
        return (int) (((Bid) o).getPrice() - this.getPrice());
    }
}
