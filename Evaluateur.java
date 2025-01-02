package tp.si.conference.entities;

public class Evaluateur extends User{

    public void main_role(Conference conference) {
        //Role role = new R_editeur("evaluateur",this,conference);
        conference.getRoles().add(new R_editeur("evaluateur",this,conference));
    }

    public void ajouter_role(String nom_role,Conference conference){
        //puisque il est evaluateur on peut ajouter le role : evaluateur et auteur
        if(nom_role.equals("evaluateur")){
            conference.getRoles().add(new R_evaluateur("evaluateur",this,conference));
        }else{
            if(nom_role.equals("auteur")){
                conference.getRoles().add(new R_evaluateur("auteur",this,conference));
            }
        }
    }

}
