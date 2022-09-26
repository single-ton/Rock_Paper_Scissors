import org.hyperskill.hstest.dynamic.DynamicTest;
import org.hyperskill.hstest.stage.StageTest;
import org.hyperskill.hstest.testcase.CheckResult;
import org.hyperskill.hstest.testcase.TestCase;
import org.hyperskill.hstest.testing.TestedProgram;

import java.util.ArrayList;
import java.util.List;

public class Tests extends StageTest {
  String[] cases = new String[]{"rock",
          "paper",
          "scissors"};
  public List<TestCase> generate(){
    String[] options = new String[]{"rock",
            "paper",
            "scissors"};
    List<String> inputs = new ArrayList<String>();
    for(String option : options){
      for(int i=0;i<50;i++)
        inputs.add(option);
    }
    List<TestCase> tests = new ArrayList<TestCase>();
    for(String input : inputs){
      TestCase testCase = new TestCase();
      testCase.setAttach(input);
      testCase.setInput(input);
      tests.add(testCase);
    }
    return tests;
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
  String getOutput(String input){
    return String.format("Sorry, but the computer chose %s",getWin(input));
  }
  @DynamicTest
  CheckResult test() {
    for (String input : cases) {
      if (!check(input)) {
        String result = getOutput(input);
        return CheckResult.wrong(String.format("Your answer on \"%s\" was \"%s\". This is a wrong output. The correct output is \"%s\"", input, getWin(input), result));
      }
    }
    return CheckResult.correct();
  }
  boolean check(String input){
    TestedProgram pr = new TestedProgram();
    pr.start();
    String programOutput = pr.execute(input).strip();
    String result = getOutput(input);
    return result.equals(programOutput);
  }
}