package hellojpa;

import jakarta.persistence.*;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Team team = new Team();
            team.setUsername("TeamA");

            Member member = new Member();
            member.setUsername("member1");
            member.setTeam(team);
            em.persist(member);

            Member findMember = em.find(Member.class, member.getId());
            Team finTeam = findMember.getTeam();
            System.out.println("finTeam.getTeamId() = " + finTeam.getTeamId());
            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
