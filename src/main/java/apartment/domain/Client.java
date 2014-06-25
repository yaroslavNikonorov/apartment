package apartment.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "Clients")
public class Client {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;
    private String phone;
    private String email;

//    @OneToMany(mappedBy = "client")
    @OneToMany(mappedBy = "client")
    private Collection<Bid> bids = new ArrayList<Bid>();

    public Client() {
    }

    public Client(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<Bid> getBids() {
        return bids;
    }

    public void setBids(Collection<Bid> bids) {
        this.bids = bids;
    }

}
