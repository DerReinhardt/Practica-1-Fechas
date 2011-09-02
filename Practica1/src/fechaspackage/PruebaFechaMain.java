/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fechaspackage;

/**
 *
 * @author Reinhardt
 */
public class PruebaFechaMain {
    
    /**
     * Muestra el menu de opciones y permite elegir
     */
    public static int LeeOpcion()
    {
        int opc = 0;
        
        
        System.out.println("******** APLICACION DE FECHAS ********\n");
        System.out.println("1.- Crea una fecha sin parametros");
        System.out.println("2.- Crea una fecha dando en número dia, mes y año respectivamente");
        System.out.println("3.- Crea una fecha dando en número dia y año. Mes como cadena");
        System.out.println("4.- Crea la copia de una fecha");
        System.out.println("5.- Métodos para asignar atributos de una fecha");
        System.out.println("6.- Métodos para obtener atributos de una fecha");        
        System.out.println("7.- Diferencia de dias entre dos fechas");
        
        System.out.println("6.- Obtener el numero respectivo a un mes, dando su nombre");
        System.out.println("7.- Obtener el nombre respectivo a un mes, dando su numero");
        
        System.out.println("Escribir 0 para terminar");
        
        System.out.print("Opcion: ");
        opc = Teclado.readInt();
        
        EjecutaOpcion(opc);
        
        return opc;

    }        
    
    /**
     * Ejecuta la opción recibida del menú
     * @param opc opción a ejecutar
     */
    public static void EjecutaOpcion(int opc)
    {
        // check the selection to enable/disable fields
        switch(opc)
        {
            case 1:     // fecha sin parámetros
                LeeFechaSinParametros();
                break;

            case 2:     // fecha con parámetros enteros
                LeeFechaString(opc);                
                break;
            case 3:     // mes como string
                LeeFechaString(opc);                
                break;
            
            case 4:
                PrintDates(CopiaFechas(LeeFechaString(2)), true);                
                break;
            case 5:
                SetFecha();
                break;
            case 6:
                GetFecha(SetFecha());
                break;
                
            case 7:
                Fecha date1 = LeeFechaString(2);
                Fecha date2 = LeeFechaString(2);
                
                System.out.println("La diferencia es " + date1.difDeDosFechas(date2.GetDay(), 
                        date2.GetMonth(), date2.GetYear()));
                break;
/*
                Default:
                    System.out.println("Opción inválida");
                    break;
*/              
        }
    }

    /**
     * Imprime las fechas
     * @param date objeto Fecha a imprimir
     * @param valid es fecha válida?
     */
    public static void PrintDates(Fecha date, boolean valid)
    {
        if(date != null && valid)
        {
            System.out.println(date.FechaToString());
            System.out.println(date.FechaIntToString());

        }
        else
        {
            System.out.println("Fecha no válida");
            System.out.println("Fecha no válida");
        }
    }
    
    
    /**
     * Crea una fecha con atributos por default e invoca su impresión.
     */
    public static void LeeFechaSinParametros()
    {
        Fecha date = new Fecha();
        PrintDates(date, true);
    }
    
    
    /**
     * Lee la fecha y si es válida, asigna cada parámetro al atributo correspondiente
     * Después invoca su impresión
     * @return date el objeto instanciado
     */
    public static Fecha SetFecha()
    {
        System.out.println("Introduzca la fecha con el siguiente formato "
                + "dd-mm-aaaa (e.g. 29-10-1987)");
        
        int[] fecha = ValidaStringFecha(Teclado.readString(), 2);
        if(fecha != null)
        {
            Fecha date = new Fecha();
            date.SetDay(fecha[0]);
            date.SetMonth(fecha[1]);
            date.SetYear(fecha[2]);
            PrintDates(date, true);
            return date;
        }              
        
        return null;
    }
    
    /**
     * Utiliza los métodos get de la clase Fecha para imprimir los atributos
     * @param date objeto del cuál vamos a imprimir sus atributos
     */
    
    public static void GetFecha(Fecha date)
    {
        System.out.println("Dia: " + date.GetDay());
        System.out.println("Mes: " + date.GetMonth());
        System.out.println("Año: " + date.GetYear());
    }
    
    /**
     * Lee el string de la fecha con el formato definido e invoca a la función
     * para validarla. Si los resultados obtenidos de la validación son enteros,
     * se crea el objeto. Regresa el objeto de tipo fecha creada si es válido; 
     * null de lo contrario
     * @param opc opción para facilitar el tipo de lectura
     */
    public static Fecha LeeFechaString(int opc)
    {        
        if(opc == 3)
        System.out.println("Introduzca la fecha con el siguiente formato "
                + "dd-mm-aaaa (e.g. 29-octubre-1987)");
        else
        System.out.println("Introduzca la fecha con el siguiente formato "
                + "dd-mm-aaaa (e.g. 29-10-1987)");
        
        
        
        int[] fecha = ValidaStringFecha(Teclado.readString(), opc);     // array para guardar los atributos
        if(fecha != null)   // si la fecha es válida
        {
            Fecha date = new Fecha(fecha[0], fecha[1], fecha[2]);   // crea una fecha con atributos del array
            PrintDates(date, true);
            return date;
        }              
        
        return null;
    }
        
    
    /**
     * Valida la cadena como una fecha. Utiliza substring de la clase String
     * para separar la cadena y validar cada parte.
     * @param str fecha string a validar
     * @return int[] regresa un arreglo que contiene los valores enteros de la fehca
     */
    
    public static int[] ValidaStringFecha(String str, int opc)
    {
        boolean validDate = true;
        String dayStr = "0";
        String monthStr = "0";
        String yearStr = "0";
       
        int day = 0, month = 0, year = 0, strLen = str.length(),  monthLen = strLen - 5;
        
        try
        {
            dayStr = str.substring(0, 2);
            monthStr = str.substring(3, monthLen);  // tomamos el substr que está entre el año y el día
            yearStr = str.substring(strLen - 4, strLen);    // final del string y -4 para el año
        }
        catch(IndexOutOfBoundsException ex)
        {
            validDate = false;
            System.out.println("Error en el tamaño de la fecha: " + ex.toString());
        }
        
        try
        {
            
            if(opc == 2)  // Si el mes es entero
                month = Integer.parseInt(monthStr);     // parsealo directamente
            else
                month = Fecha.MonthToInt(monthStr);     // transformarlo en entero
                        
            day = Integer.parseInt(dayStr);                    
            year = Integer.parseInt(yearStr);        
        } 
        catch(NumberFormatException ex)
        {
            validDate = false;
            System.out.println("Error en el formato de los números: " + ex.toString());
        }
        
        if(!Fecha.pruebaDiasDelMes(day, month, year))   // si no pasa la prueba
            validDate = false;
        
        if(day < 1 || month < 1 || year < 1900)     // como fue comentado en clase, checaremos desde 1900
            validDate = false;
        
        if(validDate)
        {
            int[] Fecha = new int[3];
            Fecha[0] = day;
            Fecha[1] = month;
            Fecha[2] = year;
            return Fecha;
        }
        return null;
    }
    
    /**
     * Crea una fecha como copia de otra usando el constructor para copiar
     * @param dateToCopy fecha a copiar
     * @return date regresa la fecha creada (copia de la recibida), o un objeto
     * null si la fecha recibida es null
     */
    
    public static Fecha CopiaFechas(Fecha dateToCopy)
    {
        if(dateToCopy != null)
        {
            Fecha date = new Fecha(dateToCopy);
            return date;
        }
        
        return null;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        while(LeeOpcion() > 0);
        System.out.println("Halt!");
        
    }
}
