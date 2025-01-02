package tp.si.conference.entities;


import jakarta.persistence.Entity;



@Entity
public class Auteur extends User{

    //roles principale
    public void main_role(Conference conference) {
       // Role role = new R_editeur("auteur",this,conference);
        conference.getRoles().add( new R_editeur("auteur",this,conference));
    }

    // ajouter les roles
    public void ajouter_role(String nom_role ,Conference conference){
        //puisque il est evaluateur on peut ajouter le role : evaluateur et auteur
    if(nom_role.equals("auteur")){
        conference.getRoles().add(new R_auteur("auteur",this,conference));
    }
    }
}
