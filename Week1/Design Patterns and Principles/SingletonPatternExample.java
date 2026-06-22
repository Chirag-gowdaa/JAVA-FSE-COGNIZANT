import java.util.*;
public class SingletonPatternExample {
    static class Logger{
        static Logger login = new Logger();
        String msg="";
        private Logger(){
             msg = "Logging user 1";
        }
        public static Logger getLogin(){
            return login;
        }
    }
    public static void main(String[] args){
          Logger log1 = Logger.getLogin();
          Logger log2 = Logger.getLogin();
          System.out.println(log1.msg);
          System.out.println(log2.msg);
    }   

}
