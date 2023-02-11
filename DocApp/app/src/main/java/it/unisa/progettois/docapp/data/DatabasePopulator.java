package it.unisa.progettois.docapp.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabasePopulator extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 11;
    public static final String DATABASE_NAME = "Docapp.db";
    private static final String SQL_CREATE_STUDENT =
            "CREATE TABLE Studente" + "(" +
            "email TEXT PRIMARY KEY," +
            "nickname TEXT NOT NULL," +
            "password TEXT NOT NULL,"+
            "is_admin INTEGER NOT NULL);";

    private static final String SQL_CREATE_DOCUMENT =
            "CREATE TABLE Documento" + "(" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "nome TEXT NOT NULL," +
            "descrizione TEXT NOT NULL," +
            "universita TEXT NOT NULL," +
            "facolta TEXT NOT NULL," +
            "corso_di_studio TEXT NOT NULL," +
            "percorso TEXT NOT NULL," +
            "dimensione INTEGER NOT NULL);";

    private static final String SQL_CREATE_FEEDBACK =
            "CREATE TABLE Feedback" + "(" +
            "documento INTEGER NOT NULL," +
            "studente TEXT NOT NULL," +
            "PRIMARY KEY (documento, studente)," +
            "FOREIGN KEY(documento) REFERENCES Documento(id)," +
            "FOREIGN KEY(studente) REFERENCES Studente(email));";

    private static final String SQL_CREATE_CARICAMENTO =
            "CREATE TABLE Caricamento" + "(" +
                    "documento INTEGER NOT NULL," +
                    "studente TEXT NOT NULL," +
                    "PRIMARY KEY (documento, studente)," +
                    "FOREIGN KEY(documento) REFERENCES Documento(id)," +
                    "FOREIGN KEY(studente) REFERENCES Studente(email));";

    private static final String SQL_CREATE_DOCUMENTIVISUALIZZATI =
            "CREATE TABLE DocumentiVisualizzati" + "(" +
                    "documento INTEGER NOT NULL," +
                    "studente TEXT NOT NULL," +
                    "PRIMARY KEY (documento, studente)," +
                    "FOREIGN KEY(documento) REFERENCES Documento(id)," +
                    "FOREIGN KEY(studente) REFERENCES Studente(email));";

    private static final String SQL_CREATE_POST =
            "CREATE TABLE Post" + "(" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "titolo TEXT NOT NULL," +
            "testo TEXT NOT NULL," +
            "is_domanda BOOLEAN NOT NULL CHECK(is_domanda IN (0,1)));";

    private static final String SQL_CREATE_INTERAZIONEPOST =
            "CREATE TABLE InterazionePost" + "(" +
            "post INTEGER NOT NULL," +
            "studente TEXT NOT NULL," +
            "PRIMARY KEY (post, studente)," +
            "FOREIGN KEY (post) REFERENCES Post(id)," +
            "FOREIGN KEY (studente) REFERENCES Studente(email));";

    private static final String SQL_CREATE_CONVERSAZIONE =
            "CREATE TABLE Conversazione" + "(" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "nome_conversazione TEXT NOT NULL," +
            "studente TEXT NOT NULL," +
            "FOREIGN KEY (studente) REFERENCES Studente(email));";

    private static final String SQL_CREATE_MESSAGGIO =
            "CREATE TABLE Messaggio" + "(" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "conversazione INTEGER NOT NULL," +
            "studente TEXT NOT NULL," +
            "testo TEXT NOT NULL," +
            "timestamp_msg DATETIME DEFAULT CURRENT_TIMESTAMP," +
            "FOREIGN KEY (studente) REFERENCES Studente(email)," +
            "FOREIGN KEY (conversazione) REFERENCES Conversazione(id));";

    public DatabasePopulator(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_STUDENT);
        db.execSQL(SQL_CREATE_DOCUMENT);
        db.execSQL(SQL_CREATE_FEEDBACK);
        db.execSQL(SQL_CREATE_CARICAMENTO);
        db.execSQL(SQL_CREATE_DOCUMENTIVISUALIZZATI);
        db.execSQL(SQL_CREATE_POST);
        db.execSQL(SQL_CREATE_INTERAZIONEPOST);
        db.execSQL(SQL_CREATE_CONVERSAZIONE);
        db.execSQL(SQL_CREATE_MESSAGGIO);

        db.execSQL("INSERT INTO Studente(email, nickname, password, is_admin) VALUES ('admin@gmail.com', 'giuseppe', 'admin', 1);");
        db.execSQL("INSERT INTO Studente(email, nickname, password, is_admin) VALUES ('admin1@gmail.com', 'tonino', 'admin', 1);");
        db.execSQL("INSERT INTO Studente(email, nickname, password, is_admin) VALUES ('g.napolitano80@studenti.unisa.it', 'nerone', 'prova123', 0)");
        db.execSQL("INSERT INTO Studente(email, nickname, password, is_admin) VALUES ('a.russomando11@studenti.unisa.it', 'toninodb', 'prova123', 0)");
        db.execSQL("INSERT INTO Studente(email, nickname, password, is_admin) VALUES ('f.bosso4@studenti.unisa.it', 'bosso', 'prova123', 0)");
        db.execSQL("INSERT INTO Studente(email, nickname, password, is_admin) VALUES ('g.dambrosio63@studenti.unisa.it', 'pepp', 'prova123', 0)");

        db.execSQL("INSERT INTO Documento(id, nome, descrizione, universita, facolta, corso_di_studio, percorso, dimensione) VALUES (1, 'Forza Napoli', 'Se ti piace il napoli, adorerai il napoli live', 'Università degli Studi del Sannio', 'Informatica', 'Analisi Matematica', 'it/unisa/progettois/docapp/documenti/Appunti_FIA.pdf', 20)");
        db.execSQL("INSERT INTO Documento(id, nome, descrizione, universita, facolta, corso_di_studio, percorso, dimensione) VALUES (2, 'Forza Messina', 'Messina grande uomo', 'Università degli Studi del Sannio', 'Informatica', 'Analisi Matematica', 'it/unisa/progettois/docapp/documenti/Appunti_RDC.pdf', 30)");
        db.execSQL("INSERT INTO Documento(id, nome, descrizione, universita, facolta, corso_di_studio, percorso, dimensione) VALUES (3, 'Forza Juve', 'Juve squadra ladra', 'Università degli Studi di Napoli Federico II', 'Matematica', 'Algebra Commutativa', 'it/unisa/progettois/docapp/documenti/so.pdf', 30)");
        db.execSQL("INSERT INTO Documento(id, nome, descrizione, universita, facolta, corso_di_studio, percorso, dimensione) VALUES (4, 'Forza Salerno', 'Sto finendo le squadre che conosco', 'Università degli Studi di Salerno', 'Ingegneria Informatica', 'Analisi Matematica I', 'it/unisa/progettois/docapp/documenti/Programmazione_I.pdf', 40)");
        db.execSQL("INSERT INTO Documento(id, nome, descrizione, universita, facolta, corso_di_studio, percorso, dimensione) VALUES (5, 'Forza Milan', 'Banda di Pisciaiuoli', 'Università degli Studi di Salerno', 'Ingegneria Informatica', 'Analisi Matematica I', 'it/unisa/progettois/docapp/documenti/pythonlearn.pdf', 50)");

        db.execSQL("INSERT INTO Caricamento(documento, studente) VALUES (1, 'g.napolitano80@studenti.unisa.it');");
        db.execSQL("INSERT INTO Caricamento(documento, studente) VALUES (2, 'g.napolitano80@studenti.unisa.it');");
        db.execSQL("INSERT INTO Caricamento(documento, studente) VALUES (3, 'a.russomando11@studenti.unisa.it');");
        db.execSQL("INSERT INTO Caricamento(documento, studente) VALUES (4, 'a.russomando11@studenti.unisa.it');");
        db.execSQL("INSERT INTO Caricamento(documento, studente) VALUES (5, 'f.bosso4@studenti.unisa.it');");

        db.execSQL("INSERT INTO DocumentiVisualizzati(documento, studente) VALUES (1, 'g.napolitano80@studenti.unisa.it');");
        db.execSQL("INSERT INTO DocumentiVisualizzati(documento, studente) VALUES (2, 'g.napolitano80@studenti.unisa.it');");
        db.execSQL("INSERT INTO DocumentiVisualizzati(documento, studente) VALUES (3, 'a.russomando11@studenti.unisa.it');");
        db.execSQL("INSERT INTO DocumentiVisualizzati(documento, studente) VALUES (4, 'a.russomando11@studenti.unisa.it');");
        db.execSQL("INSERT INTO DocumentiVisualizzati(documento, studente) VALUES (5, 'f.bosso4@studenti.unisa.it');");

        db.execSQL("INSERT INTO Conversazione(id, nome_conversazione, studente) VALUES (1, 'a.russomando11@studenti.unisa.it', 'g.napolitano80@studenti.unisa.it');");
        db.execSQL("INSERT INTO Conversazione(id, nome_conversazione, studente) VALUES (2, 'g.napolitano80@studenti.unisa.it', 'a.russomando11@studenti.unisa.it')");

        db.execSQL("INSERT INTO Messaggio(id, conversazione, studente, testo, timestamp_msg) VALUES (1, 1, 'g.napolitano80@studenti.unisa.it', 'Ciao toni sei un bravo ragazzo', '2020-12-31 23:40:50')");
        db.execSQL("INSERT INTO Messaggio(id, conversazione, studente, testo, timestamp_msg) VALUES (2, 1, 'g.napolitano80@studenti.unisa.it', 'Come stai?', '2020-12-31 23:40:55')");
        db.execSQL("INSERT INTO Messaggio(id, conversazione, studente, testo, timestamp_msg) VALUES (3, 2, 'a.russomando11@studenti.unisa.it', 'Ciao peppe, tutto bene', '2020-12-31 23:41:50')");
        db.execSQL("INSERT INTO Messaggio(id, conversazione, studente, testo, timestamp_msg) VALUES (4, 2, 'a.russomando11@studenti.unisa.it', 'Ti voglio bene', '2020-12-31 23:42:50')");
        db.execSQL("INSERT INTO Messaggio(id, conversazione, studente, testo, timestamp_msg) VALUES (5, 1, 'g.napolitano80@studenti.unisa.it', 'Cosa fai di bello?', '2020-12-31 23:45:50')");
        db.execSQL("INSERT INTO Messaggio(id, conversazione, studente, testo, timestamp_msg) VALUES (6, 1, 'g.napolitano80@studenti.unisa.it', 'Io sto vedendo dei documenti', '2020-12-31 23:46:50')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Studente");
        db.execSQL("DROP TABLE IF EXISTS Documento");
        db.execSQL("DROP TABLE IF EXISTS Feedback");
        db.execSQL("DROP TABLE IF EXISTS Caricamento");
        db.execSQL("DROP TABLE IF EXISTS DocumentiVisualizzati");
        db.execSQL("DROP TABLE IF EXISTS Post");
        db.execSQL("DROP TABLE IF EXISTS InterazionePost");
        db.execSQL("DROP TABLE IF EXISTS Conversazione");
        db.execSQL("DROP TABLE IF EXISTS Messaggio");

        onCreate(db);
    }
}