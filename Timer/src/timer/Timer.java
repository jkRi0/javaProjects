package timer;
import java.util.concurrent.TimeUnit;
public class Timer {
    public static void main(String[] args) throws InterruptedException{
        boolean x=true;
        long displayMinutes=0;
        long starttime=System.currentTimeMillis();
        System.out.println("Timer:");
        while(x)
        {
            long key = 465;          //input timer in milliseconds
            TimeUnit.MILLISECONDS.sleep(key);
            long timepassed=System.currentTimeMillis()-starttime;
            long secondspassed=timepassed/key;
            if(secondspassed==60){
                secondspassed=0;
                starttime=System.currentTimeMillis();
            }
             java.awt.Toolkit.getDefaultToolkit().beep(); 
        }
    }
}

