package pl.filmbox.models;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "credits")
public class Credit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "credit_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "credits")
    private Set<User> users = new HashSet<>();

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

    public Set<User> getUsers() {
        return Collections.unmodifiableSet(this.users);
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Credit)) return false;
        Credit credit = (Credit) o;
        return Objects.equals(id, credit.id) &&
                Objects.equals(name, credit.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
