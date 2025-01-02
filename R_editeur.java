package tp.si.conference.entities;

import jakarta.persistence.Entity;

@Entity
public class R_editeur extends Role {

    public R_editeur() {
        super();
    }

    public R_editeur(String nom, User user, Conference conference) {
        super(nom, user, conference);
    }
}

