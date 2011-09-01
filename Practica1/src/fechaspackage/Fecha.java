package fechaspackage;

/*
 * The following class uses methods to operate dates. 
 *
 */


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
     * Constructor que crea un objeto copiando los par�metros del objeto recibido
     * @param originalDate Objeto del cual vamos a copiar
     */
    public Fecha(Fecha originalDate)
    {
        day = originalDate.GetDay();
        month = originalDate.GetMonth();
        year = originalDate.GetYear();
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
      * Transforma el string del mes en número. Estático para poderlo invocar
      * sin la necesidad de crear el objeto
      * @param monthx string recibida para transformar
      * @return int número de mes
      */
     public static int MonthToInt(String monthStr){
         int month = 0;

         String lMonthStr = monthStr.toLowerCase();

         if(lMonthStr.equals("enero"))
             month = 1;
         else if(lMonthStr.equals("febrero"))
             month = 2;
         else if(lMonthStr.equals("marzo"))
             month = 3;
         else if(lMonthStr.equals("abril"))
             month = 4;
         else if(lMonthStr.equals("mayo"))
             month = 5;
         else if(lMonthStr.equals("junio"))
             month = 6;
         else if(lMonthStr.equals("julio"))
             month = 7;
         else if(lMonthStr.equals("agosto"))
             month = 8;
         else if(lMonthStr.equals("septiembre"))
             month = 9;
         else if(lMonthStr.equals("octubre"))
             month = 10;
         else if(lMonthStr.equals("noviembre"))
             month = 11;
         else if(lMonthStr.equals("diciembre"))
             month = 12;
         else
             month = 0;
         
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
         String fechaStr = day + "-" + month + "-" + year + " (dd-mm-yyy)";
         return fechaStr;
     }
          
     /**
      * Checa si el año es bisiesto
      * @param fecha
      * @return 
      */
     
     public boolean EsBisiesto(Fecha fecha)
     {
         int year = fecha.GetYear();
         return ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0);
     }
     
     /**
      * Convierte los meses de int a string
      * @param monthInt número a convertir
      * @return monthStr string asociado con el número de mes
      */     
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

     /*
     * M�todo que devuelve la diferencia en dias entre la fecha
     * que se pasa por parametro (dayx, monthx, yearx) y la
     * fecha del objeto.
     */

    public long difDeDosFechas(int dayx, int monthx, int yearx)
    {
        long diferencia = 0;
        long juliano1 = 0;
        long juliano2 = 0;

        juliano1 = gregorianoajuliano(dayx, monthx, yearx);
        juliano2 = gregorianoajuliano(day, month, year);

        diferencia = juliano1 - juliano2;
        if(diferencia < 0)
            diferencia = diferencia * -1 ;



        return diferencia;
    }

    /*
     * Transforma del calendario gregoriano a julioano
     */

    public static long gregorianoajuliano(int dayx, int monthx, int yearx)
    {

         long tmonth, tyear;
         long jday;

         if(monthx>2)
         {
             tmonth = monthx - 3;
             tyear = yearx;
         }
         else
             {
             tmonth = monthx + 9;
             tyear = yearx -1;
         }
         jday = (tyear/4000)*1460969;
         tyear = (tyear%4000);
         jday = jday + (((tyear/100)*146097)/4)+
                 (((tyear%100)*1461)/4)+
                 (((153*tmonth)+2)/5)+
                 dayx + 1721119;

         return jday;
    } 
    
     /*
     * Transforma dia juliano a calendario gregoriano
     */
    public void julianoAGregoriano(long jday)
    {
        jday = jday - 1721119;
        year = (int)(4 * jday - 1) / 146097;
        jday = 4 * jday - 1 - 146097 * year;
        day = (int)jday / 4;

        jday = (4 * day + 3) / 1461;
        day = 4 * day + 3 - 1461 * (int)jday;
        day = (day + 4) / 4;

        month = (5 * day - 3) / 153;
        day = 5 * day -3 - 153 * month;
        day = (day + 5) / 5;

        year = 100 * year + (int)jday;

        if (month < 10)
            month = month + 3;
        else
        {
            month = month - 9;
            year = year + 1;
        }

    }


 /*
     * Metodo para sumar dias a una fecha inicial
     */
    public void sumarDiasAFecha(long dias)
    {
        long julianoInicial = gregorianoajuliano(day, month, year);
        long julianoFinal = julianoInicial + dias;

        julianoAGregoriano(julianoFinal);

    }
    
    /*
     * Metodo que devuelve los dias transcurridos en el a�o
     */
    public int diasTranscurridosEnElAnio()
    {
        int diasTrans = 0;

        long anioJuliano = 0;
        long fechaJuliana = 0;

        anioJuliano = gregorianoajuliano(1, 1, year);
        fechaJuliana = gregorianoajuliano(day, month, year);

        diasTrans = (int) (fechaJuliana - anioJuliano) + 1;

        return diasTrans;
    }



    /*
     * M�todo que determina si dos fechas son iguales
     */
    public boolean sonIguales(int dayx, int monthx, int yearx)
    {
        long juliano1 = 0;
        long juliano2 = 0;

        juliano1 = gregorianoajuliano(dayx, monthx, yearx);
        juliano2 = gregorianoajuliano(day, month, year);

        if(juliano1 == juliano2)
            return true;
        else
            return false;
    }
     

}
