package cz.cvut.test;

import cz.cvut.test.model.CvutBox;
import cz.cvut.test.model.Package;
import cz.cvut.test.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ApplicationTest {

    @DisplayName("Test that shows correct functionality of CVUT-BOX delivery/pickup process")
    @Test
    void cvutBoxTest() throws Exception {
        CvutBox cvutBox = new CvutBox("alzabox");

        User u1 = new User("u1");
        User u2 = new User("u2");
        cvutBox.addObserver(u1);
        cvutBox.addObserver(u2);
        Package z1 = new Package(u1,1);
        Package z2 = new Package(u2, 2);
        cvutBox.insertPackage(z1);
        cvutBox.insertPackage(z2);
        cvutBox.requestParcelPickup(1, u1);
        String code = u1.getInfo();
        Assertions.assertNotNull(cvutBox.getParcel(code));
        cvutBox.requestParcelPickup(2, u2);
        String code2 = u2.getInfo();
        Assertions.assertNotNull(cvutBox.getParcel(code2));

    }
}
