
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StudentBSTTest {
    private StudentBST tree;
    private Student s1, s2, s3;

    @BeforeEach
    void setUp() {
        tree = new StudentBST();
        // Setup students: s2 < s1 < s3 based on matrNr (0500 < 1000 < 2000)
        s1 = new Student("Max", "Mustermann", "max@test.com", "1000");
        s2 = new Student("Anna", "Schmidt", "anna@test.com", "0500");
        s3 = new Student("John", "Doe", "john@test.com", "2000");
    }

    @Test
    void testAdd() {
        // Add first student (becomes root)
        assertTrue(tree.add(s1), "Adding the first student should return true.");

        // Add student to the left/right (smaller/larger matrNr)
        assertTrue(tree.add(s2), "Adding a student with a smaller matrNr should return true.");
        assertTrue(tree.add(s3), "Adding a student with a larger matrNr should return true.");

        // Duplicate matrNr (should be rejected)
        Student duplicate = new Student("Copy", "Cat", "copy@test.com", "1000");
        assertFalse(tree.add(duplicate), "Adding a duplicate matriculation number should return false.");

        // Null reference
        assertFalse(tree.add(null), "Adding a null student should return false and not throw an exception.");
    }

    @Test
    void testSearch() {
        // TODO implement this test method
        assertNull(tree.search("1000"));

        tree.add(s1);
        tree.add(s2);
        tree.add(s3);

        assertTrue(tree.search(s1.getMatrNr()) == s1);
        assertTrue(tree.search(s2.getMatrNr()) == s2);
        assertTrue(tree.search(s3.getMatrNr()) == s3);
        assertTrue(tree.search("0200") == null);
    }

    @Test
    void testToString() {
        // TODO implement this test method
        tree.add(s1);
        tree.add(s2);
        tree.add(s3);

        assertTrue(tree.toString().equals("Vorname: Anna Nachname: Schmidt E-Mail: anna@test.com Matrikelnummer: 0500\nVorname: Max Nachname: Mustermann E-Mail: max@test.com Matrikelnummer: 1000\nVorname: John Nachname: Doe E-Mail: john@test.com Matrikelnummer: 2000\n"));
    }
}