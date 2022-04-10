package helpers;

import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProvider {
    @DataProvider
    public Iterator<Object[]> loginValidDataCSV() throws IOException {

        List<Object[]> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader("src/test/java/tests/user/register.csv"));
        String line = reader.readLine();

        while (line!=null){
            String[] split = line.split(";");
            list.add(new Object[]{split[0],split[1]});
            line = reader.readLine();
        }
        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> loginWrongEmailDataCSV() throws IOException {

        List<Object[]> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader("src/test/java/tests/user/login_wrongEmail.csv"));
        String line = reader.readLine();

        while (line!=null){
            String[] split = line.split(";");
            list.add(new Object[]{split[0],split[1]});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> registerValidDataCSV() throws IOException {

        List<Object[]> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader("src/test/java/tests/user/register.csv"));
        String line = reader.readLine();

        while (line!=null){
            String[] split = line.split(";");
            list.add(new Object[]{split[0],split[1],split[2]});
            line = reader.readLine();
        }
        return list.iterator();
    }

}
