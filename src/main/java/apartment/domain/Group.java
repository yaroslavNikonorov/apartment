package apartment.domain;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;

/**
 * Created by yar on 5/21/14.
 */
@Entity
@Table(name = "GROUPS")
public class Group {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String groupname;

//    @ManyToMany
//    private List<User> users;

    public Group() {
    }

    public Group(String groupname) {
        this.groupname = groupname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }
}
