package gmiBank.stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gmiBank.pojos.User;

import java.util.ArrayList;
import java.util.List;

import static gmiBank.utilities.DatabaseUtil.*;
import static gmiBank.utilities.PDFGenerator.pdfGeneratorRowsAndCellsWithListFirstToTenForUser;

public class US_030StepDefinitions {

    @Given("user creates a connection using {string} , {string} and {string}")
    public void userCreatesAConnectionUsingAnd(String url, String username, String password) {
        createConnection(url,username,password);
    }


    @Then("user provides the query {string} and sees first ten user info on pdf file")
    public void userProvidesTheQueryAndSeesFirstTenUserInfoOnPdfFile(String query) {
        List<User> userList=new ArrayList<>();
        List<List<Object>> lists=getQueryResultList(query);

        for(int i=0; i<10; i++){
            User user=new User();
            user.setId(Integer.parseInt(String.valueOf(lists.get(i).get(0))));
            user.setLogin(lists.get(i).get(1).toString());
            user.setFirstName(lists.get(i).get(3).toString());
            user.setLastName(lists.get(i).get(4).toString());
            user.setEmail(lists.get(i).get(5).toString());

            userList.add(user);

        }

        pdfGeneratorRowsAndCellsWithListFirstToTenForUser("=========User list=========",userList,"userList.pdf");
        closeConnection();
    }
}
