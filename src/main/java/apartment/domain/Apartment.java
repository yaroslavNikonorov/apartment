package apartment.domain;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.TreeSet;

/**
 * Created by yar on 5/23/14.
 */
@Entity
public class Apartment {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    @NotNull
    @Size(min=2)
    private String address;

    @OneToMany(mappedBy = "apartment", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @OneToMany(mappedBy = "apartment")
    @OrderBy("price")
    private Collection<Bid> bids = new TreeSet<Bid>();

    public Apartment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Collection<Bid> getBids() {
        return bids;
    }

    public void setBids(Collection<Bid> bids) {
        this.bids = bids;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", bids=" + bids +
                '}';
    }
}
