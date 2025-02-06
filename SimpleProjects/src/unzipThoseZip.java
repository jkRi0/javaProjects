import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class unzipThoseZip {

	public static void main( String[ ] args ) {  
        String zipFilePath = "F:\\qwerty.zip" ;  
        String destDir = "F:" ;  
        unzipfile( zipFilePath, destDir ) ;  
    }  
    private static void unzipfile( String zipFilePath, String destDir ) {  
        File dir = new File( destDir ) ;  
        // creating an output directory if it doesn't exist already  
        if( !dir.exists( ) ) dir.mkdirs( ) ;  
        FileInputStream FiS ;  
        // buffer to read and write data in the file  
        byte[ ] buffer = new byte[ 1024 ] ;  
        try {  
            FiS = new FileInputStream( zipFilePath ) ;  
            ZipInputStream ZiS = new ZipInputStream( FiS ) ;  
            ZipEntry ZE = ZiS.getNextEntry( ) ;  
            while( ZE != null ) {  
                String fileName = ZE.getName( ) ;  
                File newFile = new File( destDir + File.separator + fileName ) ;  
                System.out.println( " Unzipping to " + newFile.getAbsolutePath( ) ) ;  
                // create directories for sub directories in zip  
                new File( newFile.getParent( ) ).mkdirs( ) ;  
                FileOutputStream FoS = new FileOutputStream( newFile ) ;  
                int len ;  
                while ( ( len = ZiS.read( buffer ) )  > 0 ) {  
                FoS.write( buffer, 0, len ) ;  
                }  
                FoS.close( ) ;  
                // close this ZipEntry  
                ZiS.closeEntry( ) ;  
                ZE = ZiS.getNextEntry( ) ;  
            }  
            // close last ZipEntry  
            ZiS.closeEntry( ) ;  
            ZiS.close( ) ;  
            FiS.close( ) ;  
        } catch ( IOException e ) {  
            e.printStackTrace( ) ;  
        }  
    } 

}
