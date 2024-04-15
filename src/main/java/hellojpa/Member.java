package hellojpa;

import jakarta.persistence.*;

import java.util.Date;

@Entity // JPA에서 관리한다는 의미

public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //해당 DB가 자동으로 ID 생성
    private Long id;

    @Column(name = "name") //DB 컬럼 명은 name
    private String username;

    private Integer age;

    @Enumerated(EnumType.STRING) //enum을 사용할 때는 @Enumerated를 사용하기 - enum.ORDINAL: enum 클래스에서의 순서를 DB에 저장; enum.STRING: enum 이름을 DB에 저장
    private Roletype roletype;

    @Temporal(TemporalType.TIMESTAMP) // TIMESTAMP는 날짜와 시간을 모두 포함한 것; JAVA 8부터는 어노테이션 없이 LocalDateTime 타입을 사용하면 됨
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModified;

    @Lob //varchar를 넘어서는 큰 글은  @Lob을 사용
    private String description;

    @Transient //DB와 상관없이 객체에서만 사용하고 싶은 필드(DB에 영향 X)
    private int temp;

    public Member(){}


}
