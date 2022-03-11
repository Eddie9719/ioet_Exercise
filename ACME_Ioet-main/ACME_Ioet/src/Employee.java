import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Employee {

	public static void main(String[] args) {
		
		List<String> employees = new ArrayList<>();
		Path path = Paths.get("");
		String directoryName = path.toAbsolutePath().toString();
        //employees = readFile(directoryName+"\\src\\Data\\AcmeData.txt");
		String file = args [0];
		employees = readFile(directoryName+ file);
		String[] employee_name = new String[employees.size()];
		Map<String, String> map = new HashMap<String, String>();
		for(int i = 0;i<employees.size();i++)
		{
			String[] input = employees.get(i).split("="); //Split to get, the name of the employees and their schedule
			employee_name[i]= input[0];
			map.put(input[0], input[1]);
		}
		String employees_timeAtoffice = TimeAtOffice(map,employee_name);
		String[] answer= employees_timeAtoffice.split(",");
		for(int i = 0;i<answer.length;i++)
		{
			System.out.println(answer[i]);
		}	
		
	}
	
	public static String TimeAtOffice(Map<String,String> Data,String[] names) {
		String result = "";		
		String[] aux ;
		int count = 0;
		for(int i = 0;i<Data.size();i++)
		{
			for(int j = 1;j<Data.size();j++)
			{				
				String schedule_employee =Data.get(names[i]);//String to compare the schedule of an employee with the schedule of the other employees
				aux= Data.get(names[j]).split(",");
				for(int k = 0;k<aux.length;k++)
				{
					if(schedule_employee.contains(aux[k])) //This allows verifying if the employees have been in the same period of time.
					{
						count++;
					}				
				}
				if(names[j].equals(names[i])) //To ignore duplicates Example: RENE-ASTRID, ASTRID-RENE
				{
					count = 0;	
					break;				
				}
				if(count>0)
				{
				result+= names[i]+"-"+names[j] +":" +count+","; //If the count is higher than 0, it means that the employees have been in the same period of time
				}				
				count = 0;	
			}	
		}				
		return result.substring(0,result.length()-1);		
	}
	
	//Read the text file, and save the data in a list
	public static List<String> readFile(String file){ 
		List<String> list = Collections.emptyList();
		try { 
			list = Files.readAllLines(Paths.get(file), StandardCharsets.UTF_8); 
		} 
		catch (IOException e) { 
			e.printStackTrace(); 
			}
        return list;
		
	}

}

