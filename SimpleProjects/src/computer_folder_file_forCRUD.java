import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class computer_folder_file_forCRUD {

	public static void main(String[] args) {

		
		//COMPUTER HOSTNAME
		String hostname = "Unknown";
		try
		{
		    InetAddress addr;
		    addr = InetAddress.getLocalHost();
		    hostname = addr.getHostName();
		    System.out.println(hostname);
		}
		catch (UnknownHostException ex)
		{
		    System.out.println("Hostname can not be resolved");
		}
		
		
		
		
		
		
		//COMPUTER USERNAME
		String username = System.getProperty("user.name");
		System.out.println(username);
		
		
		
		
		
		
		
		//CREATE DIRECTORIES
		File files = new File("F:\\Directory2\\Sub2\\Sub-Sub2");
        if (!files.exists()) {
            if (files.mkdirs()) {
                System.out.println("Multiple directories are created!");
            } else {
                System.out.println("Failed to create multiple directories!");
            }
        }
		
		
        
        
        
        
        
        
        //CREATE TEXT FILE
        String data = "";
        File accountData = new File("accounts.txt");
		try {
			if (accountData.createNewFile()) {
				System.out.println("File created: " + accountData.getName());
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		try {
			data = data.concat("\n");
			FileWriter writer = new FileWriter("F:\\Directory2\\Sub2\\Sub-Sub2\\accounts.txt",true);
			writer.write(data);
			writer.close();
        } 
		catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		
		
		
		
		
		//REPLACING TEXT FROM A TEXT FILE
		File fileToBeModified = new File("F:/test.txt");
        String oldContent = "";
        BufferedReader reader = null;
        FileWriter writer = null;
        try
        {
            reader = new BufferedReader(new FileReader(fileToBeModified));
             
            //Reading all the lines of input text file into oldContent
            String line = reader.readLine();
            while (line != null) 
            {
                oldContent = oldContent + line + System.lineSeparator();
                line = reader.readLine();
            }
             
            //Replacing oldString with newString in the oldContent
            String newContent = oldContent.replaceAll("4444", "qwerty");
             
            //Rewriting the input text file with newContent
            writer = new FileWriter(fileToBeModified);
            writer.write(newContent);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                //Closing the resources
                reader.close();
                writer.close();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
		

	}

}
