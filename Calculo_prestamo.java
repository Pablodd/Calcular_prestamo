import java.util.Scanner;
import java.text.DecimalFormat;

// El siguiente codigo calcula la cantidad 
// que debe un cliente de banca
// tras ir haciendo aportaciones

public class Calculo_prestamo {

    public static void main(String[] args) {

        // 
        // Se crearan 3 variables que comprende el prestamos solicitado,
        // la cantidad de aportación que se dará para rebajar la deuda,
        // la deuda que es el capital pendiente por amortizar
    
        // 
        // Las variables serán flotantes ya que podremos tener capital en negativo y con decimales.
        // 
        float prestamo, aportacion, deuda;
        DecimalFormat df = new DecimalFormat("###.##");
        Scanner input1  = new Scanner(System.in);
        
        System.out.println("Por favor introduce el importe del prestamo");

        // 
        // Este primer bucle If es para detener el codigo si en algún momento
        // se introduce algún caracter, haciendo obligatoria la introducción de cantidades numéricas.
        // 
        // 
        
        if (input1.hasNextFloat()){
            prestamo = input1.nextFloat();

            System.out.println("El importe del prestamo es de: "+ df.format(prestamo));

            deuda = prestamo;

            // 
            // Hecha la solicitud del prestamo, entraremos en un bucle en el que se solicitaran las aportaciones.
            // Si la aportación es menor que el importe del prestamo el bucle seguirá activo.
            // Si la deuda es MAYOR que cero seguiremos dentro del bucle,
            // pero en el momento en el que la deuda sea MENOR que 0 entraremos en la condición while
            // 
            // Todos los formatos son redondeos para que no haya resultados periodicos
            // 

            do{

                System.out.println("Introduce una aportación");
                Scanner input2  = new Scanner(System.in);

                // 
                // En esta parte he introducido un if para que el codigo no se interrumpa si el usuario introduce caracteres
                // ya que si eso ocurre aparece un mensaje de introducir valores y nos solicita un importe,
                // además que continua la deuda donde se quedó, no reinicia de nuevo la solicitud de prestamo
                // 
                if(input2.hasNextFloat()){
                    aportacion = input2.nextFloat();
                    
                    deuda = deuda - aportacion;

                    System.out.println("Has hecho una aportación de: "+ df.format(aportacion) +" te queda por pagar: "+ df.format(deuda));
                }else{

                    System.out.println("Por favor introduce valores");

                }

            } while (deuda > 0 );

            // 
            // Al hacerse efectiva la condición While entraremos en dos opciones diferentes dependiento del resultado .
            // Opciones:
            // 
            // A)Si la deuda es 0 la deuda queda saldada
            // 
            // B)Pero si la deuda se encuentra en negativo eso quiere decir que se ha aportado más capital que el solicitado,
            // por lo que saltará un mensaje en el que se le comunica al cliente que se le devolverá la cantidad aportada de más.
            //

                if(deuda == 0){

                    System.out.println("Felicidades ha finalizado de pagar su prestamo de: "+ prestamo);


                }else if (deuda < 0){

                    // 
                    // Cuando aportemos capital de más al darnos un resultado en negativo, se multiplicará por -1 el resultado, para que salga en positivo y redondeado por si el resultado es periodico.
                    // 
                    
                    System.out.println("Felicidades ha finalizado su prestamo y se le devolverá la cantidad de: " + df.format(deuda*-1)+" que se han pagado de más.");
                }

        }else{
            System.out.println("Debes introducir una cifra");

        }
        
    }
    
}
