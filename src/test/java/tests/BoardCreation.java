package tests;

import models.Board;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BoardCreation extends TastBase{

    @BeforeTest
    public void preCond() {
       if(!app.getHelperUser().isLogged()){
           app.getHelperUser().login(new User().withPassword("Miledi88").withEmail("sabant88@mail.ru"));
       }
    }

    @Test
    public void boardCreationSuccess1(){

        Board board = new Board().withTitle("QA-35");

        int boardCountBefore = app.getHelperBoard().getBoardCount();

        app.getHelperBoard().initBoardCreation();
        app.getHelperBoard().fillBoardCreationForm(board);
        app.getHelperBoard().scrollDownForm();
        app.getHelperBoard().pause(2000);
        app.getHelperBoard().submitBoardCreation();
        app.getHelperBoard().pause(2000);
        app.getHelperBoard().returnToHomePage();


        int boardCountAfter = app.getHelperBoard().getBoardCount();


        Assert.assertEquals(boardCountAfter, boardCountBefore+1);


    }


}
