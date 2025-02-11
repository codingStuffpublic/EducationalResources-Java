package reflection.ext;

public interface HttpClient {

    void initialize();

    String sendRequest(String request);
}
