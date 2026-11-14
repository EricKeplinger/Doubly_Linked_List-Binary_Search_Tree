import java.util.Objects;

/**
 * Repräsentiert einen Studenten mit seinen persönlichen Daten
 * und seiner Matrikelnummer.
 */
class Student {
    // TODO add fields, constructor, and toString() method
    /**
     * Die Matrikelnummer des Studenten.
     * Der Vorname des Studenten.
     * Der Nachname des Studenten.
     * Die E-Mail-Adresse des Studenten.
     */
    private String matrNr;
    private String firstName;
    private String lastName;
    private String email;

    /**
     * Erstellt einen neuen Studenten mit den angegebenen Daten.
     *
     * @param firstName der Vorname des Studenten
     * @param lastName der Nachname des Studenten
     * @param email die E-Mail-Adresse des Studenten
     * @param matrNr die Matrikelnummer des Studenten
     */
    Student(String firstName, String lastName, String email, String matrNr){
        this.matrNr = matrNr;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    /**
     * Gibt die Matrikelnummer des Studenten zurück.
     *
     * @return die Matrikelnummer des Studenten
     */
    public String getMatrNr(){
        return matrNr;
    }

    /**
     * Erstellt eine textuelle Darstellung des Studenten.
     * Diese enthält den Vornamen, Nachnamen, die E-Mail-Adresse
     * und die Matrikelnummer, gefolgt von einem Zeilenumbruch.
     *
     * @return die Daten des Studenten als Zeichenkette
     */
    @Override
    public String toString() {
        return  "Vorname: " + firstName + " Nachname: " + lastName + " E-Mail: " + email + " Matrikelnummer: " + matrNr + "\n";
    }
}

/**
 * Repräsentiert einen Knoten in einem binären Suchbaum.
 * Jeder Knoten speichert einen Studenten und besitzt
 * Referenzen auf seinen linken und rechten Teilbaum.
 */
class StudentNode {

    /**
     * Der im Knoten gespeicherte Student.
     * * Referenzen auf den linken und rechten Kindknoten.
     */
    Student student; // the stored student
    StudentNode left, right; // pointers to the left and right subtree

    /**
     * Erstellt einen neuen Knoten mit dem angegebenen Studenten.
     * Die Referenzen auf die beiden Kindknoten werden
     * mit null initialisiert.
     *
     * @param student der im Knoten zu speichernde Student
     */
    StudentNode(Student student) {
        this.student = student;
        this.left = this.right = null;
    }
}

/**
 * Implementiert einen binären Suchbaum zur Verwaltung von Studenten.
 * Die Studenten werden anhand ihrer Matrikelnummern
 * lexikografisch geordnet.
 * Der Suchbaum ermöglicht das Einfügen und Suchen von Studenten
 * sowie die sortierte Ausgabe mittels Inorder-Traversierung.
 */
public class StudentBST {

    /**
     * Referenz auf den Wurzelknoten des binären Suchbaums.
     * Ist der Baum leer, besitzt root den Wert null.
     */
    private StudentNode root = null; // pointer to the root node

    /**
     * Fügt einen Studenten in den binären Suchbaum ein.
     * Die Position des neuen Knotens wird durch den
     * lexikografischen Vergleich der Matrikelnummern bestimmt.
     * Kleinere Matrikelnummern werden im linken und größere
     * Matrikelnummern im rechten Teilbaum eingefügt.
     * Studenten mit bereits vorhandener Matrikelnummer
     * werden nicht erneut eingefügt.
     *
     * @param student der einzufügende Student
     * @return true, wenn der Student erfolgreich eingefügt wurde;
     *         false, wenn der Student null ist oder seine
     *         Matrikelnummer bereits im Baum vorhanden ist
     */
    public boolean add(Student student) {
        // TODO implement this method
        StudentNode p = root, parent = null;
        if(student == null){
            return false;
        } else{
            while(p != null && p.student.getMatrNr().compareTo(student.getMatrNr()) != 0){
                parent = p;
                if(student.getMatrNr().compareTo(p.student.getMatrNr()) > 0){
                    p = p.right;
                } else{
                    p = p.left;
                }

            }
            if(p != null){
                return false;
            }
            StudentNode n = new StudentNode(student);
            if(root == null){
                root = n;
                return true;
            } else if(student.getMatrNr().compareTo(parent.student.getMatrNr()) < 0){
                parent.left = n;
                return true;
            } else if(student.getMatrNr().compareTo(parent.student.getMatrNr()) > 0){
                parent.right = n;
                return true;
            } else{
                return false;
            }
        }
    }

    /**
     * Sucht einen Studenten anhand seiner Matrikelnummer.
     * Die Suche beginnt beim Wurzelknoten des binären Suchbaums
     * und wird durch die rekursive Suchmethode durchgeführt.
     *
     * @param matrNr die Matrikelnummer des gesuchten Studenten
     * @return der gefundene Student oder null, wenn kein Student
     *         mit dieser Matrikelnummer vorhanden ist
     */
    public Student search(String matrNr) {
        return search(root, matrNr);
    }

    /**
     * Durchsucht den Teilbaum ab dem angegebenen Knoten
     * rekursiv nach einem Studenten mit der gesuchten Matrikelnummer.
     * Ist die gesuchte Matrikelnummer kleiner als die des aktuellen
     * Knotens, wird im linken Teilbaum weitergesucht.
     * Andernfalls erfolgt die Suche im rechten Teilbaum.
     * Bei Übereinstimmung wird der gespeicherte Student zurückgegeben.
     *
     * @param cur der aktuelle Knoten, bei dem die Suche beginnt
     * @param matrNr die Matrikelnummer des gesuchten Studenten
     * @return der gefundene Student oder null, wenn kein
     *         entsprechender Student gefunden wurde
     */
    private Student search(StudentNode cur, String matrNr) {
        // TODO implement this method
        if(cur == null){
            return null;
        }
        if (matrNr.compareTo(cur.student.getMatrNr()) == 0){
            return cur.student;
        }
        if (matrNr.compareTo(cur.student.getMatrNr()) < 0) {
            return search(cur.left, matrNr);
        } else {
            return search(cur.right, matrNr);
        }
    }

    /**
     * Erstellt eine textuelle Darstellung aller Studenten im Suchbaum.
     * Mithilfe einer Inorder-Traversierung werden die Studenten
     * aufsteigend nach ihren Matrikelnummern ausgegeben.
     * Die einzelnen Studentendaten werden in einem
     * StringBuilder gesammelt.
     *
     * @return eine Zeichenkette mit allen Studenten in
     *         aufsteigender Reihenfolge ihrer Matrikelnummern;
     *         bei einem leeren Baum eine leere Zeichenkette
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        inorder(root, sb);
        return sb.toString();
    }

    /**
     * Durchläuft den binären Suchbaum rekursiv in Inorder-Reihenfolge.
     * Zuerst wird der linke Teilbaum durchlaufen, anschließend
     * wird der aktuelle Student zum StringBuilder hinzugefügt
     * und zuletzt wird der rechte Teilbaum durchlaufen.
     * Dadurch werden die Studenten aufsteigend nach ihren
     * Matrikelnummern in den StringBuilder geschrieben.
     * Ist der aktuelle Knoten null, wird die Rekursion beendet.
     *
     * @param node der aktuelle Knoten der Inorder-Traversierung
     * @param sb der StringBuilder, in dem die Studentendaten
     *           gesammelt werden
     */
    private void inorder(StudentNode node, StringBuilder sb) {
        // TODO implement this method
        if(node == null){
            return;
        }
        inorder(node.left, sb);
        sb.append(node.student.toString());
        inorder(node.right, sb);
    }
}