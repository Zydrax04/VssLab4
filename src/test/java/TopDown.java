import controller.AppController;
import exception.DuplicateIntrebareException;
import exception.InputValidationFailedException;
import exception.NotAbleToCreateStatisticsException;
import exception.NotAbleToCreateTestException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import repository.IntrebariRepository;
import model.*;

public class TopDown {
    @Test
    public void testAddIntrebareReusit() throws InputValidationFailedException, DuplicateIntrebareException {
        IntrebariRepository repo = new IntrebariRepository();

        Intrebare q1 = new Intrebare("Enunt?", "1) varianta1", "2) varianta2", "1", "Domeniu");
        Intrebare q2 = new Intrebare("Alt enunt?", "1) alta varianta1", "2) alta varianta2", "2", "Domeniu");

        repo.addIntrebare(q1);
        repo.addIntrebare(q2);
        int nrIntrebari = repo.getIntrebari().size();
        Assert.assertEquals(9, nrIntrebari);
    }

    @Test
    public void createTestTest() {
        AppController controller = new AppController();
        try {
            //Se creeaza testul
            model.Test myTest = controller.createNewTest();
            Assert.assertEquals(true,true);
        } catch (Exception ex) {
            // Vedem Mesajul de eroare
            System.out.println(ex.getMessage());
            Assert.assertEquals(true,false);
        }
    }

    @Test
    public void createStatisticaTest(){
        AppController appController = new AppController();
        appController.loadIntrebariFromFile("file");
        Statistica statistica;
        try {
            statistica = appController.getStatistica();
            Assert.assertEquals(true,true);
        } catch (NotAbleToCreateStatisticsException e) {
            Assert.assertEquals(true,false);
        }
    }

    @Test
    public void topDown1() throws InputValidationFailedException, DuplicateIntrebareException {
        IntrebariRepository repo = new IntrebariRepository();

        Intrebare q1 = new Intrebare("Se tine scoala online?", "1) Da", "2) nu sunt debil", "1", "Actualitate");

        repo.addIntrebare(q1);

        int nrIntrebari = repo.getIntrebari().size();
        Assert.assertEquals(8, nrIntrebari);
    }

    @Test
    public void topDown2() throws InputValidationFailedException, DuplicateIntrebareException {
        //P->A->B->C
        AppController appController = new AppController();
        appController.loadIntrebariFromFile("file");

        //A
        Intrebare q1 = new Intrebare("Se tine scoala online?", "1) Da", "2) nu sunt debil", "1", "Actualitate");

        appController.addNewIntrebare(q1);
        int nrIntrebari = appController.getQuestionsNumber();

        Assert.assertEquals(8, nrIntrebari);

        //B
        try {
            //Se creeaza testul
            model.Test myTest = appController.createNewTest();
            Assert.assertEquals(true,true);
        } catch (Exception ex) {
            // Vedem Mesajul de eroare
            System.out.println(ex.getMessage());
            Assert.assertEquals(true,false);
        }
    }

    @Test
    public void topDown3() throws InputValidationFailedException, DuplicateIntrebareException {
        //P->A->B->C
        AppController appController = new AppController();
        appController.loadIntrebariFromFile("file");

        //A
        Intrebare q1 = new Intrebare("Se tine scoala online?", "1) Da", "2) nu sunt debil", "1", "Actualitate");

        appController.addNewIntrebare(q1);
        int nrIntrebari = appController.getQuestionsNumber();

        Assert.assertEquals(8, nrIntrebari);

        //B
        try {
            //Se creeaza testul
            model.Test myTest = appController.createNewTest();
            Assert.assertEquals(true,true);
        } catch (Exception ex) {
            // Vedem Mesajul de eroare
            System.out.println(ex.getMessage());
            Assert.assertEquals(true,false);
        }


        //C
        Statistica statistica;
        try {
            statistica = appController.getStatistica();
            System.out.println(statistica);
            Assert.assertEquals(true,true);
        } catch (NotAbleToCreateStatisticsException e) {
            Assert.assertEquals(true,false);
        }
    }
}
