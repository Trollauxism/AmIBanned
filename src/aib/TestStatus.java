package aib;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;


public class TestStatus implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		System.out.println("Testing...");
		
		String email = AmIBanned.txtEmail.getText();
		String password = AmIBanned.passwordField.getText();
		
		try {
			
			URL oracle;
			
			oracle = new URL("http://realmofthemadgod.appspot.com/char/list?guid=" + email + "&password=" + password);
			
			BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));
			
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				
				if (inputLine.equals("<Error>Account credentials not valid</Error>")) {
					AmIBanned.txtpnWaiting.setText("Wrong email-password combination. \nAccount credentials are invalid, stoopid.");
				} else if (inputLine.equals("<Error>Account is under maintenance</Error>")) {
					AmIBanned.txtpnWaiting.setText("Yes. This account is banned. GG.");
				} else if (inputLine.contains("nextCharId")) {
					if (email.equals("")) {
						AmIBanned.txtpnWaiting.setText("No. The guest account can't be banned.");
					} else {
						AmIBanned.txtpnWaiting.setText("No. This account is valid. Stop complaining.");
					}
				} else if (inputLine.contains("Account in use")) {
					AmIBanned.txtpnWaiting.setText("Account is in use. Please try again in " + inputLine.substring(23, inputLine.indexOf(" seconds")) + " seconds. (Don't try too often to not exceed the limit, noob.)");
				} else if (inputLine.equals("<Error>LoginError.tooManyFails</Error>")) {
					AmIBanned.txtpnWaiting.setText("Too many failed login attempts. \nPlease try again later. GG.");
				} else if (inputLine.toLowerCase().equals("server error")) {
					AmIBanned.txtpnWaiting.setText("Server error. Try again.");
				} else {
					AmIBanned.txtpnWaiting.setText("Unhandled answer : \n" + inputLine);
				}
			}
			
			in.close();
			
		} catch (IOException e) {
			AmIBanned.txtpnWaiting.setText(e.getLocalizedMessage());
			e.printStackTrace();
		}
		
		
	}
}
