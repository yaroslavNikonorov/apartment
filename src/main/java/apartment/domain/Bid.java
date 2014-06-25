package apartment.domain;

import javax.persistence.*;

/**
 * Created by yar on 5/23/14.
 */
@Entity
public class Bid{
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "id_apartment")
    private Apartment apartment;

    private Double price;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @Column(nullable = false)
    @ManyToOne()
    @JoinColumn(name = "id_client")
    private Client client;

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
}
