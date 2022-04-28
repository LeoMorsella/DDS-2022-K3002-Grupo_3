package usuarios;

import usuarios.usuarioExceptions.ArchivoNotFoundException;
import usuarios.usuarioExceptions.EasyPasswordException;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.nio.charset.StandardCharsets.UTF_8;

public class ValidadorContrasenias {
    private final String yourDesktopPath = System.getProperty("user.dir")+"/";

    private static ValidadorContrasenias validadorContrasenias = new ValidadorContrasenias();

    private ValidadorContrasenias() {}

    public static ValidadorContrasenias getValidadorContrasenias() {
      return validadorContrasenias;
    }

    // validador General
    public void validarPassword(String password) {
      validarPassword10k(password);
      //validarPasswordRegex(password);
    }

  //politica de longitud
    public void validarPasswordRegex(String password){
    Pattern pattern;
    Matcher matcher;
    final String PASSWORD_PATTERN = "^(?=.*\\d)(?=.*[@#$%^&+=/.!,_?-])(?=.*[A-Z])(?=.*[a-z])\\S{8,16}$";
    pattern = Pattern.compile(PASSWORD_PATTERN);
    matcher = pattern.matcher(password);
    if (!matcher.matches()) {
      throw new EasyPasswordException("La contraseña no cumple los requsitos");
    }
  }

    // Validacion OWASP
    public void validarPassword10k (String password) {
      Scanner inputFile = null;

      try {
        //File file = new File(yourDesktopPath+"10k-worst-password.txt");
        InputStreamReader file = new InputStreamReader(new FileInputStream(yourDesktopPath + "10k-worst-password.txt"), UTF_8);
        inputFile = new Scanner(file);

      } catch (FileNotFoundException e ) {
        e.printStackTrace();
        throw new ArchivoNotFoundException("Archivo no existente o no encontrado");
      }
      Objects.requireNonNull(inputFile).useDelimiter("[\\r\\n]");
      while(inputFile.hasNext()) {
        String wrongPassword = inputFile.next();
        if(password.equals(wrongPassword)) {
            throw new EasyPasswordException("La contraseña esta entre las 10k mas faciles");
        }
      }
      inputFile.close();
    }
}
