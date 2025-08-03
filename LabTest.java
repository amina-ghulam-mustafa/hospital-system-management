import java.util.*;
import java.io.*;
import java.text.*;


class LabTest {
    private String name;
    private boolean isCancelled;
    private List<String> results;

    public LabTest(String name) {
        this.name = name;
        this.isCancelled = false;
        this.results = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public boolean isCancelled() {
        return isCancelled;
    }

    public List<String> getResults() {
        return results;
    }

    public void viewTest() {
        System.out.println("Lab Test: " + name);
        if (isCancelled) {
            System.out.println("This test has been cancelled.");
        } else {
            System.out.println("This test is scheduled.");
        }
    }

    public void cancelTest() {
        isCancelled = true;
        System.out.println("Lab Test: " + name + " has been cancelled.");
    }

    public void generateTestResult(String result) {
        results.add(result);
        System.out.println("Test result for " + name + " generated: " + result);
    }
}
