import com.guichaguri.minimalftp.FTPServer;
import com.guichaguri.minimalftp.impl.NativeFileSystem;
import com.guichaguri.minimalftp.impl.NoOpAuthenticator;
import java.io.File;
import java.io.IOException;

/**
 * Created by SAlavizadeh on 2019-May-14
 */
public class TestFTP {

  public static void main(String[] args) {
    // Uses the current working directory as the root
    File root = new File(System.getProperty("user.dir"));

    // Creates a native file system
    NativeFileSystem fs = new NativeFileSystem(root);

    // Creates a noop authenticator, which allows anonymous authentication
    NoOpAuthenticator auth = new NoOpAuthenticator(fs);

    // Creates the server with the authenticator
    FTPServer server = new FTPServer(auth);

    // Start listening synchronously
    try {
      server.listenSync(21);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
