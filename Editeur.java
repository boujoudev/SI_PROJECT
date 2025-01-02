package tp.si.conference.entities;

import java.util.ArrayList;
import java.util.Date;

public class Editeur extends User implements Creataur  {

    private ArrayList<Conference> conferences;



    @Override
    public void main_role(Conference conference) {
            // Role role = new R_editeur("editeur",this,conference);
             conference.getRoles().add(new R_editeur("editeur",this,conference));
    }

    @Override
    public void ajouter_role(String nom_role,Conference conference){
     //puisque il est editeur on peut ajouter le role directement
     //conference.getRoles().add(new R_editeur(nom_role,this,conference));

        if(nom_role.equals("editeur")){
            conference.getRoles().add(new R_auteur("editeur",this,conference));
        }else{
            if (nom_role.equals("evaluateur")){
                conference.getRoles().add(new R_evaluateur("evaluateur",this,conference));
            }else{
                if (nom_role.equals("auteur")){
                    conference.getRoles().add(new R_editeur("auteur",this,conference));

                }
            }
        }
    }

    @Override
    public void cree_conference(String titre, Date date_deut, Date date_fin, String thematique, String etat_conference){
        // au moment de création d'un conférence on doit introduire un titre qui est une clé primaire pour notre conférence
        // donc on a pas besoin de faire un test si cette conférence existe ou pas parce que si elle existe on a pas le droit de
        // la créé et comme j'ai dit déja la clé primaire va s'occuper de faire ce test
          int i = 0;
          boolean b = true;

           while(i < conferences.size() && b){
               if(conferences.get(i).getTitre().equals(titre)){
                  b = false;
               }
           }

           if(b){
               conferences.add(new Conference(titre,date_deut,date_fin,thematique,etat_conference));
           }else{
               //exeption pour un titre exite déja cad cette conférence est rejeter

           }

    }
}
