
package swingchatclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;


public class Reader extends Thread {
    
    private BufferedReader br;
    private JTextArea taMessages;

    public Reader(BufferedReader br, JTextArea taMessages) {
        this.br = br;
        this.taMessages = taMessages;
        
        setDaemon(true);
    }

    @Override
    public void run() { // run ctrl+space
        String row = "";
        while (true){
            try {
                row = br.readLine();
                taMessages.append(row);
            } catch (IOException ex) {
                taMessages.append(ex.toString());
            }
        }
    }
    
    
}
