package tp.si.conference.entities;

import java.util.List;
import tp.si.conference.repositories.SoumissionRepository;
import tp.si.conference.repositories.ConferenceRepository;

public class R_auteur extends Role{
    public R_auteur(String nom,User user,Conference conference){
        super(nom,user,conference);
    }




}