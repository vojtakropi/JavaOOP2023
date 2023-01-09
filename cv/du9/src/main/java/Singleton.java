package du9.src.main.java;

public class Singleton {

        private static Singleton single_instance = null;


        public String s;


        public Singleton()
        {
            s = "you created singleton";
        }


        public static Singleton getInstance()
        {
            if (single_instance == null)
                single_instance = new Singleton();

            return single_instance;
        }
}

