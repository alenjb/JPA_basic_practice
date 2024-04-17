package hellojpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Locker {

    @Id @GeneratedValue
    private long id;

    private String name;

    @OneToOne(mappedBy = "locker")
    private Member member;
}
