package univ.etu.tachemun.db.tableclass;

import java.util.Date;

public class EmailDisposable {

    private int ID;
    private String domaine;
    private Date dateHeureAjout;

    public EmailDisposable(int ID, String domaine, long dateHeureAjout) {
        this.ID = ID;
        this.domaine = domaine;
        this.dateHeureAjout = new Date(dateHeureAjout);
    }

    public EmailDisposable(String domaine) {
        this.ID = -1;
        this.domaine = domaine;
        this.dateHeureAjout = new Date(System.currentTimeMillis());
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    public Date getDateHeureAjout() {
        return dateHeureAjout;
    }

    public void setDateHeureAjout(Date dateHeureAjout) {
        this.dateHeureAjout = dateHeureAjout;
    }

    public void setDateHeureAjout(long dateHeureAjout) {
        this.dateHeureAjout = new Date(dateHeureAjout);
    }

    @Override
    public String toString() {
        return "{" + ID +
                "} " + domaine +
                ", " + dateHeureAjout;
    }
}
