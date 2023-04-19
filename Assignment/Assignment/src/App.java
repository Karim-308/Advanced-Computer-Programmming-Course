import java.io.*;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;



class Container implements Comparable<Container>{
private String id ;
private String ShortName;
private String LongName;

public String getUUID() {
    return id;
}
public void setUUID(String uUID) {
    id = uUID;
}
public String getShortName() {
    return ShortName;
}
public void setShortName(String shortName) {
    ShortName = shortName;
}
public String getLongName() {
    return LongName;
}
public void setLongName(String longName) {
    LongName = longName;
}


public String toString()
{

   

return "	<CONTAINER UUID=\"" + getUUID() + "\">"
        + "\n		<SHORT-NAME>" + getShortName() + "</SHORT-NAME>"
        + "\n		<LONG-NAME>" + getLongName() + "</LONG-NAME>"
        + "\n	</CONTAINER>\n";



}


@Override
public int compareTo(Container c) {
  return this.ShortName.compareTo(c.getShortName());
  //Compares Containers Based on there Short Name
  // To be used by sort funtion to rearrange the Containers
}


}




class EmptyAutosarFileException extends RuntimeException {

        public  EmptyAutosarFileException(String message)
        {
            // If the file passed to the program is an empty file 

            super(message);
        }
}

class NotValidAutosarFileException extends Exception {

        //  If the file passed to the program is with arxml extension i.e (.arxml) 
        public NotValidAutosarFileException(String message)
        {
            super(message);
        }
}







public class App {
    


    public static void main(String[] args) throws Exception {
       
       try{ 

        // throws and Exception if the not file is passed as an argument
        if (args.length == 0) {
            throw new IllegalArgumentException("Filename argument is missing!");
        }


        File Input_File = new File(args[0]);


        // Check if file extension is .arxml
        if (!Input_File.getName().endsWith(".arxml")) {
                    
            throw new NotValidAutosarFileException("The file is not a valid AUTOSAR file!");
        }


        

         // Check if file is empty
         if (Input_File.length() == 0) {
           
            throw new EmptyAutosarFileException("The input file is empty!");
         }

        

        // Creating a  new output file
        //  Using getOutputFileName method to get the name of the Outputfile 
        File Output_File = new File(getOutputFileName(Input_File));
        
        //Using obejects from Scanner and PrintWriter classes to read from the Input_File and Write to Output_File
        PrintWriter output=new PrintWriter(Output_File);
        Scanner input =new Scanner(Input_File);

        // The Number Of Containers Entered
        // Countcontainers Scans the input file to retun the number of containers
        int NoOfInputs =countContainers(Input_File);  

        Container[] containers = new  Container[NoOfInputs]; // creating Array to Store Containers

        int containers_index=0; // An index to navigate through the array of conatiners

       

        
         //Starts to write in the outputfile with xml version and utf-8 , then <Autosar>
         BeginAutosarFile(output, input);


       
      // looping through the whole array of conatiners
        while (input.hasNextLine() && (containers_index<NoOfInputs)  )
        {

            //Creating instances of conatiners to assing it's Data fields
            containers[containers_index] = new Container();
            
            //seting the data fields of each container
           GetUuidOFContainer(input, containers[containers_index]);
           GetShortNameOFContainer(input, containers[containers_index]);
           GetLongNameOFContainer(input,  containers[containers_index]);

            containers_index++;

        }

        input.nextLine(); // Skip the last </CONTAINER>


        //Sorting the arrays of Container based on their Short Name
        Arrays.sort(containers);


        //Writing in the Output File for each Container
        for (int i = 0  ; i<NoOfInputs ; i++)
        {
            output.print(containers[i].toString());          
        }

        //Ending The Output file with Last line in input File : </AUTOSAR>
        EndAutosarFile(output, input);

        // Closing The Scanner and PrintWriter objects to Save the Written Data in Output File
        input.close();
        output.close();

    } catch (IllegalArgumentException | NotValidAutosarFileException | EmptyAutosarFileException e) {
        System.out.println(e);
        //Catching the Exceptions and printting their messages
    }





    

}


// Scans the input file to count the number of containers
    public static int countContainers(File inputFile) throws FileNotFoundException {
        Scanner input = new Scanner(inputFile);
        int containerCount = 0;

        while (input.hasNextLine()) {
            String line = input.nextLine();

            if (line.contains("UUID=") )
            {
                containerCount++;
            }
        }

        input.close();

        return containerCount;
    }


//Starts Wrinting in output file with The first two line in the input file 
    public static void BeginAutosarFile (PrintWriter p,Scanner s)
    {
        
       p.println(s.nextLine());
       p.println(s.nextLine());



}

//Ends Wrinting in output file with The last line in the input file 

    public static void EndAutosarFile (PrintWriter p,Scanner s)
    {
        
        p.println(s.nextLine());
        
    }

    //Extarct the input file name when passed to the program

    public static String getOutputFileName(File inputFile) {
        File output_file = new File(inputFile.getName().substring(0, inputFile.getName().lastIndexOf(".")) + "_mod.arxml");
        return output_file.getName();
    }


    //Sets the UUID of the container 
    //if the input file is <CONTAINER UUID="198ae269-8478-44bd-92b5-14982c4ff68b">
    //It extracts the Subtring between " and " marks and assign it to the conatiner UUID
    public static void GetUuidOFContainer(Scanner s , Container c)
    {
        



                String Id_Line = s.nextLine();

                if (Id_Line.equals("	</CONTAINER>"))
                Id_Line=s.nextLine();
                
                int i = Id_Line.indexOf("\"");
                String sub = Id_Line.substring(i + 1, Id_Line.indexOf("\"", i+1));
                c.setUUID(sub);


    }


    //Sets the Short of the container 
    //if the input file is 		<SHORT-NAME>ContainerA</SHORT-NAME>
    //It extracts the substring between > and < marks and assign it to the conatiner ShortName
    public static void GetShortNameOFContainer(Scanner s , Container c)
    {
        


                String Short_Name = s.nextLine();    
                int i = Short_Name.indexOf('>');
                String sub = Short_Name.substring(i + 1, Short_Name.indexOf("<", i + 1));
                c.setShortName(sub);
            }



    //Sets the Short of the container 
    //if the input file is 		<LONG-NAME>CC</LONG-NAME>
    //It extracts the substring between > and < marks and assign it to the conatiner LongName
            public static void GetLongNameOFContainer(Scanner s , Container c) 
            {
                String Short_Name = s.nextLine();    
                int i = Short_Name.indexOf('>');
                String sub = Short_Name.substring(i + 1, Short_Name.indexOf("<", i + 1));
                c.setLongName(sub);
                
            }
        

}