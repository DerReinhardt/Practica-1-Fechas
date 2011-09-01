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
     * Muestra el menu de opciones y permite elegir una
     */
    public static int LeeOpcion()
    {
        int opc = 0;
        
        
        System.out.println("******** APLICACION DE FECHAS ********\n");
        System.out.println("1.- Crea una fecha sin parametros");
        System.out.println("2.- Crea una fecha dando en número dia, mes y año respectivamente");
        System.out.println("3.- Crea la copia de una fecha");
        System.out.println("4.- Diferencia de dias entre 2 fechas");
        System.out.println("5.- Obtener el numero respectivo a un mes, dando su nombre");
        System.out.println("6.- Obtener el nombre respectivo a un mes, dando su numero");
        
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
                LeeFechaConEnteros();                
                break;
            
            case 3:
                PrintDates(CopiaFechas(LeeFechaConEnteros()), true);
                
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
     * Lee el string de la fecha con el formato definido e invoca a la función
     * para validarla. Si los resultados obtenidos de la validación son enteros,
     * se crea el objeto. Regresa el objeto de tipo fecha creada si es válido; 
     * null de lo contrario
     */
    public static Fecha LeeFechaConEnteros()
    {        
        System.out.println("Introduzca la fecha con el siguiente formato "
                + "dd-mm-aaaa (e.g. 29-10-1987)");
        
        
        int[] fecha = ValidaStringFecha(Teclado.readString());
        if(fecha != null)
        {
            Fecha date = new Fecha(fecha[0], fecha[1], fecha[2]);
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
    
    public static int[] ValidaStringFecha(String str)
    {
        boolean validDate = true;
        String dayStr = "0";
        String monthStr = "0";
        String yearStr = "0";
        
        int day = 0, month = 0, year = 0;
        
        try
        {
            dayStr = str.substring(0, 2);
            monthStr = str.substring(3, 5);
            yearStr = str.substring(6, 10);
        }
        catch(IndexOutOfBoundsException ex)
        {
            validDate = false;
            System.out.println("Error en el tamaño de la fecha: " + ex.toString());
        }
        
        try
        {
            
            day = Integer.parseInt(dayStr);        
            month = Integer.parseInt(monthStr);        
            year = Integer.parseInt(yearStr);        
        } 
        catch(NumberFormatException ex)
        {
            validDate = false;
            System.out.println("Error en el formato de los números: " + ex.toString());
        }
        
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
        // TODO code application logic here                    
        while(LeeOpcion() > 0);
        System.out.println("Halt!");
        
    }
}
