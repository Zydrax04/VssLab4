import controller.AppController;
import exception.DuplicateIntrebareException;
import exception.InputValidationFailedException;
import exception.NotAbleToCreateTestException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import repository.IntrebariRepository;
import model.*;

public class test {

    @Test
    public void testAddIntrebareReusit() throws InputValidationFailedException, DuplicateIntrebareException {
        IntrebariRepository repo = new IntrebariRepository();

        Intrebare q1 = new Intrebare("Enunt?","1) varianta1","2) varianta2","1","Domeniu");
        Intrebare q2 = new Intrebare("Alt enunt?","1) alta varianta1","2) alta varianta2","2","Domeniu");

        repo.addIntrebare(q1);
        repo.addIntrebare(q2);
        int nrIntrebari = repo.getIntrebari().size();
        Assert.assertEquals(2, nrIntrebari);
    }


    @Test
    public void testAddIntrebareDuplicat() throws InputValidationFailedException, DuplicateIntrebareException {
        IntrebariRepository repo = new IntrebariRepository();

        Intrebare q1 = new Intrebare("Enunt?","1) varianta1","2) varianta2","1","Domeniu");
        Intrebare q2 = new Intrebare("Enunt?","1) varianta1","2) varianta2","1","Domeniu");
        try {
            repo.addIntrebare(q1);
            repo.addIntrebare(q2);
            Assert.assertEquals(true, false);
        }
        catch (Exception ex){
            Assert.assertEquals(true, true);
        }

    }

    @Test
    public void testAddIntrebareGresita() throws InputValidationFailedException, DuplicateIntrebareException {
        IntrebariRepository repo = new IntrebariRepository();

        Intrebare q1 = new Intrebare(null,"1)","2) varianta2","1","Aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        //Intrebare q2 = new Intrebare("Enunt?","varianta1","varianta2","1","Domeniu");
        try {
            repo.addIntrebare(q1);
            //repo.addIntrebare(q2);
            Assert.assertEquals(true, false);
        }
        catch (Exception ex){
            Assert.assertEquals(true, true);
        }

    }

    @Test
    public void createTestTest() throws NotAbleToCreateTestException {
        AppController controller = new AppController();
        try{
            //Se creeaza testul
            model.Test myTest = controller.createNewTest();
            System.out.println(myTest.getIntrebari().size());
        }

        catch (Exception ex){
            // Vedem Mesajul de eroare
            System.out.println(ex.getMessage());
        }

    }


}
