import com.opencsv.bean.CsvToBeanBuilder;
import java.io.*;
import java.util.Base64;
import java.util.List;


public class converter {

    private static String base64String = "Rmlyc3ROYW1lLE1pZGRsZU5hbWUsTGFzdE5hbWUsRW1wbG95ZWVJZCxMZXZlbCxFbWFpbElkLFN1cGVydmlzb3IsT3JnSWQKUmFtZXNoLFJhbWppLFBhdGVsLDJ1eTIxaXUsTDEsZGVtb3QyNzgzQGdtYWlsLmNvbSxIMTIzMDA3LEIxMjAwMApLaXJhbixLYW5qaSxUYWlsb3IsMjgxODEyLEwxLGRlbW8yMTg3ODFAZ21haWwuY29tLEgxMjMwMDgsQjEyMDAw";

    public static void main(String[] args) throws Exception{
        //			decoding base64 encoded file and adding to input stream

        byte[] decodedBody = Base64.getDecoder().decode(base64String);
        InputStream stream = new ByteArrayInputStream(decodedBody);

//        try (CSVReader reader = new CSVReader(new InputStreamReader(stream))) {
//            List<String[]> r = reader.readAll();
//            r.forEach(x -> System.out.println(Arrays.toString(x)));
//        }

        List<user> beans = new CsvToBeanBuilder<user>(new InputStreamReader(stream))
                .withType(user.class)
                .build()
                .parse();
        System.out.println(beans.get(0).getEmailId());





    }
}
