package univ.etu.tachemun.db.managers;

import android.content.Context;

import univ.etu.tachemun.db.tableclass.EmailDisposable;

public class GroupeManager extends TableManager {
    /*

CREATE TABLE Groupe (
  ID_Groupe varchar(16) COLLATE utf8_unicode_ci NOT NULL,
  ID_createurGroupe varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  nom_Groupe varchar(25) COLLATE utf8_unicode_ci NOT NULL,
  dateCreation_Groupe timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  description_Groupe varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  prive_Groupe tinyint(4) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


ALTER TABLE Groupe
  ADD PRIMARY KEY (ID_Groupe),
  ADD KEY fk_Groupe_Utilisateur_idx (ID_createurGroupe);


ALTER TABLE Groupe
  ADD CONSTRAINT fk_Groupe_Utilisateur FOREIGN KEY (ID_createurGroupe) REFERENCES Utilisateur (pseudo_Utilisateur) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;
     */
    static final String tableName = "Groupe";
    static final String ID_GROUPE = "ID_Groupe";
    static final String ID_createur = "ID_createur";
    static final String nom_Groupe = "nom";
    static final String DateHeure_Creation = "dateCreation";
    static final String DESCRIPTION = "description";
    static final String IS_PRIVE = "is_prive";


    public static final String createTableScript = "CREATE TABLE " + tableName +
            " (" +
            " " + ID_GROUPE + " TEXT PRIMARY KEY,"
            + ID_createur + " TEXT NOT NULL,"
            + nom_Groupe + " TEXT NOT NULL,"
            + DateHeure_Creation + " INTEGER ,"
            + DESCRIPTION + " TEXT,"
            + IS_PRIVE + " INTEGER NOT NULL"
            + ",FOREIGN KEY (" + ID_createur + ") REFERENCES " + UtilisateurManager.tableName + " (" + UtilisateurManager.ID_UTILISATEUR + ")" +
            "  ON UPDATE CASCADE ON DELETE CASCADE"

            + ");";


    public GroupeManager(Context context) {
        super(context);
    }

    public long insert(EmailDisposable e) {
        return 0;
    }

    public int update(EmailDisposable e) {
        return 0;
    }

    public int delete(EmailDisposable e) {
        return 0;
    }

    public EmailDisposable getFromId(int id) {
        return null;
    }


}
