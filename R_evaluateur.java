package tp.si.conference.entities;

import jakarta.persistence.Entity;

@Entity
public class R_evaluateur extends Role {

    public R_evaluateur() {
        super();
    }

    public R_evaluateur(String nom, User user, Conference conference) {
        super(nom, user, conference);
    }
}





