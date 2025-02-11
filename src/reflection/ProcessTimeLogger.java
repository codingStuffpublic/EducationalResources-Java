package reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import reflection.ext.DatabaseReader;
import reflection.ext.HttpClient;
import reflection.ext.impl.DatabaseReaderImpl;
import reflection.ext.impl.HttpClientImpl;

public class ProcessTimeLogger {

    public static void main(String[] args) throws InterruptedException {
        
    		HttpClient client = createProxy(new HttpClientImpl());
    		useHttpClient(client);
    	
//    		DatabaseReader databaseReader = createProxy(new DatabaseReaderImpl());
//        useDatabaseReader(databaseReader);

//        List<String> listOfGreetings = new ArrayList<>();
//        listOfGreetings.add("hello");
//        listOfGreetings.add("good morning");
//        listOfGreetings.remove("hello");
    }

    public static void useHttpClient(HttpClient httpClient) {
        httpClient.initialize();
        String response = httpClient.sendRequest("Example request");

        System.out.println(String.format("Http response is : %s", response));
    }

    public static void useDatabaseReader(DatabaseReader databaseReader) throws InterruptedException {
        int rows = 0;
        rows = databaseReader.countRowsInTable("DbTable");
        
        System.out.println(String.format("There are %s rows in DbTable", rows));

        String[] data = databaseReader.readRow("SELECT * from DbTable");

        System.out.println(String.format("Received %s", String.join(" , ", data)));
    }

    @SuppressWarnings("unchecked")
    public static <T> T createProxy(Object originalObject) {
        Class<?>[] interfaces = originalObject.getClass().getInterfaces();
        ProxyHandler timeMeasuringProxyHandler = new ProxyHandler(originalObject);

        return (T) Proxy.newProxyInstance(originalObject.getClass().getClassLoader(), interfaces, timeMeasuringProxyHandler);
    }

    public static class ProxyHandler implements InvocationHandler {
        private final Object original;

        public ProxyHandler(Object original) {
            this.original = original;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Object result;

            System.out.println(String.format("Measuring Proxy - Before Executing method : %s()", method.getName()));

            long startTime = System.currentTimeMillis();
            result = method.invoke(original, args);
            long endTime = System.currentTimeMillis();

            System.out.println();
            System.out.println(String.format("Proxy - Execution of %s() took %d milliseconds \n", method.getName(), endTime - startTime));

            return result;
        }
    }
}
