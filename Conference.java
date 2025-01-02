package tp.si.conference.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;

@Getter
@Setter
@Entity
public class Conference {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String titre;
    private Date date_deut;
    private Date date_fin;
    private String thematique;
    private String etat_conference;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "conference")
    private ArrayList<Role> roles = new ArrayList<>();

    @ManyToOne
    private Creataur createur;

    public Conference(String titre,Date date_deut,Date date_fin,String thematique,String etat_conference){
        this.etat_conference = etat_conference;
        this.thematique = thematique;
        this.date_deut = date_deut;
        this.titre = titre;
        this.date_fin = date_fin;
    }

    public Conference() {

    }

    public void ajouter_user(User user){
        boolean b = true;
        int i = 0;
        while (i < roles.size() && b){
           if(roles.get(i).getUser().getId()== user.getId()){
               b = false;
           }
           i++;
        }
        if(b){
            user.main_role(this);
        }

    }


    public void add_Role(User user,String role,Conference conference){

        int i = 0;
        boolean b = true;

       //tester l'existance d'un role et du user
       while(i < roles.size() && b ){
            if((roles.get(i).getNom_role().equals(role)) && (roles.get(i).getUser() == user)){
               b = false;
            }
            i++;
        }
       if(!b){
           //appel exeption : boujou
       }else{
           //tester si on peut affecter le role pour ce user
          user.ajouter_role(role, conference);
       }
    }

}
