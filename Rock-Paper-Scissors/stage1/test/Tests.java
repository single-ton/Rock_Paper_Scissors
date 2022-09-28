import org.hyperskill.hstest.stage.StageTest;
import org.hyperskill.hstest.testcase.CheckResult;
import org.hyperskill.hstest.testcase.TestCase;
import java.util.ArrayList;
import java.util.List;

public class Tests extends StageTest<String> {
  String[] cases = new String[]{"rock",
          "paper",
          "scissors"};

  public List<TestCase<String>> generate(){
    List<TestCase<String>> tests = new ArrayList<TestCase<String>>();
    for(String input : cases){
      TestCase<String> testCase = new TestCase<String>();
      testCase.setAttach(getWin(input));
      testCase.setInput(input);
      tests.add(testCase);
    }
    return tests;
  }
  public CheckResult check(String reply, String attach){
    String correctOutput = String.format("Sorry, but the computer chose %s",attach.strip());
    return new CheckResult(correctOutput.equals(reply.strip()),
            String.format("Your answer on \"%s\" was \"%s\". This is a wrong output. The correct output is \"%s\"", attach, reply.strip(),
                    correctOutput));
  }
  String getWin(String input){
    for(int i=0;i<cases.length;i++)
      if(input.equals(cases[i])){
        if(i+1<cases.length)
          return cases[i+1];
        else
          return cases[0];
      }
    return "";
  }
}