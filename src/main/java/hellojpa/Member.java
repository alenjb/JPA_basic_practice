package hellojpa;

import jakarta.persistence.*;

@Entity // JPA에서 관리한다는 의미

public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //해당 DB가 자동으로 ID 생성
    private Long id;

    @Column(name = "USERNAME") //DB 컬럼 명은 name
    private String username;

//    @Column(name="TEAM_ID")
//    private Long teamId;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Team getTeam() {
        return team;
    }

    public void changeTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
    }
}
