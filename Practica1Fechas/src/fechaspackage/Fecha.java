/*
 * The following class uses methods to operate dates. 
 */

package fechaspackage;
import java.lang.String;

/**
 * @author Fernando Carbajal
 * @DerReinhardt
 * @email derreinhardt@loadingspace.co.cc
 * @URL www.loadingspace.co.cc
 */
public class Fecha {
    private int day;
    private int month;
    private int year;


    /**
     * Constructor sin parámetros. Agrega valores por default.
     */
    public Fecha()
    {
        day = 1;
        month = 1;
        year = 1900;
    }

    /*
     * Constructor con tres parámetros.
     * @param dayx día
     * @param monthx mes
     * @param yearx año
     */
    public Fecha(int dayx, int monthx, int yearx)
    {
        day = dayx;
        month = monthx;
        year = yearx;
    }

    /**
     * Constructor que toma dos enteros y una cadena para el nombre del mes
     * @param dayx día
     * @param yearx año
     * @param monthx string que será transformada en entero
     */
     public Fecha(int dayx, String monthx, int yearx)
     {
         day = dayx;
         year = yearx;
         month = MonthToInt(monthx);
     }

     /**
      * Transforma el string del mes en número
      * @param monthx string recibida para transformar
      * @return int número de mes
      */
     public int MonthToInt(String monthStr){
         int month = 0;

         switch(monthStr.toLowerCase())
         {
            case "enero":      month = 1;break;
            case "febrero":   month =  2; break;
            case "marzo":      month =  3; break;
            case "abril":      month =  4; break;
            case "mayo":        month =  5; break;
            case "junio":       month =  6; break;
            case "julio":       month =  7; break;
            case "agosto":     month =  8; break;
            case "septiembre":  month =  9; break;
            case "octubre":    month = 10; break;
            case "noviembre":   month = 11; break;
            case "diciembre":   month = 12; break;
            default:           month =  0; break;
         }
         return month;
     }
     
     /**
      * Asigna los atributos de una fecha
      * @param dayx dia
      * @param monthx mes 
      * @param yearx año
      */
     
     public void SetDateAttributes(int dayx, int monthx, int yearx){
        day = dayx;
        month = monthx;
        year = yearx;
     }
     
     /**
      * Regresa el atributo dia
      * @return day dia
      */
     public int GetDay()
     {
         return day;
     }
     /**
      * Regresa el atributo mes
      * @return month mes
      */
     public int GetMonth()
     {
         return month;
     }
     /**
      * Regresa el atributo año
      * @return year año
      */
     public int GetYear()
     {
         return year;
     }
     
     /**
      * Compara este objeto Fecha con otro. Si son iguales regresa true
      * @param b objeto tipo Fecha a comparar
      * @return sameDate true si son iguales
      */
     public boolean CompareEqualDates(Fecha b)
     {
         boolean sameDate = false;
         
         if(this.equals(b))     // se necesita probar
             sameDate = true;
         
         return sameDate;
     }
     
     /**
      * Regresa los atributos del objeto en una cadena
      * @return fechaStr string con los atributos
      */
     
     public String FechaToString()
     {
         String fechaStr = day + " de " + MonthToString(month) + " de " + year;
         return fechaStr;
     }
     
     /**
      * Regresa los atributos del objeto en una cadena
      * @return fechaStr string con los atributos
      */
     public String FechaIntToString()
     {
         String fechaStr = day + "/" + month + "/" + year + " (dd/mm/yyy)";
         return fechaStr;
     }
     
     /**
      * Convierte los meses de int a string
      * @param monthInt número a convertir
      * @return monthStr string asociado con el número de mes
      */
     
     public boolean EsBisiesto(Fecha fecha)
     {
         int year = fecha.GetYear();
         return ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0);
     }
     
     public String MonthToString(int monthInt){
         String monthStr = "";

         switch(monthInt)
         {
            case 1: monthStr = "enero"; break;
            case 2: monthStr = "febrero"; break;
            case 3: monthStr = "marzo"; break;
            case 4: monthStr = "abril"; break;
            case 5: monthStr = "mayo"; break;
            case 6: monthStr = "junio"; break;
            case 7: monthStr = "julio"; break;
            case 8: monthStr = "agosto"; break;
            case 9: monthStr = "septiembre"; break;
            case 10: monthStr = "octubre"; break;
            case 11: monthStr = "noviembre"; break;
            case 12: monthStr = "diciembre"; break;
            default:           month =  0; break;
         }
         return monthStr;
     }
     
     /**
      * Compara fechas y regresa true si el objeto this es mayor
      * @param b fecha contra quien comparar
      * @return thisMayor indica si el objeto this es mayor
      */
     public boolean CompareDates(Fecha b)
     {
         boolean thisMayor = false;
         
         if(this.year > b.GetYear())
             thisMayor = true;
         else if(this.year == b.GetYear())
         {
             if(this.month > b.GetMonth())
                 thisMayor = true;
             else if(month == b.GetMonth())
             {
                 if(this.day > b.GetDay())
                     thisMayor = true;
             }
         }
                      
         return thisMayor;
         
     }
     
     

}
