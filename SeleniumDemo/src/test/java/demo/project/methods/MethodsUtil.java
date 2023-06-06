package demo.project.methods;

public class MethodsUtil {

    public void waitBySeconds(long seconds){

        waitByMilliSeconds(seconds * 1000);
    }

    public void waitByMilliSeconds(long milliSeconds){

        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
