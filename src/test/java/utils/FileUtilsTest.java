package utils;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class FileUtilsTest {

    @Test
    void readFile() throws IOException {
        FileUtils fileUtils = new FileUtils();
        List<String> unexpected = new ArrayList<>();
        List<String> expected = Arrays.asList("5 5", "1 2 N", "GAGAGAGAA", "3 3 E", "AADAADADDA");
        assertNotEquals(null,fileUtils.readFile(), "Le contenu du fichier en entree ne peut etre null");
        assertNotEquals(unexpected,fileUtils.readFile(), "Le contenu du fichier en entree ne peut etre vide");
        assertEquals(expected,fileUtils.readFile(), "donnees en entrees 5 5 1 2 N GAGAGAGAA 3 3 E AADAADADDA");
    }
}