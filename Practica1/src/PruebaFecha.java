/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LUIS
 */
public class PruebaFecha
{

    Teclado teclado = new Teclado();
    /**
     * Muestra el menu de opciones y permite elegir una
     */
    public void LeeOpcion()
    {
        int opc = 0;
        System.out.println("******** APLICACION DE FECHAS ********\n\n\n");
        System.out.println("1.- Crea una fecha sin parametros\n");
        System.out.println("2.- Crea una fecha dando dia, mes y año respectivamente\n");
        System.out.println("3.- Crea la copia de una fecha\n");
        System.out.println("4.- Diferencia de dias entre 2 fechas\n");
        System.out.println("5.- Obtener el numero respectivo a un mes, dando su nombre");
        System.out.println("6.- Obtener el nombre respectivo a un mes, dando su numero");






    }
    
    public void LeeFechaSinParametros()
    {
        Fecha date = new Fecha();
        PrintDates(date, true);
    }

    public void EjecutaOpcion(int opc)
    {
        // check the selection to enable/disable fields
        switch(opc)
        {
            case 0:     // fecha sin parámetros
                LeeFechaSinParametros();
                break;
/*
            case 1:     // fecha con parámetros enteros
                comboMonth.setEnabled(true);
                comboDay.setEnabled(true);
                txtYear.setEnabled(true);
                break;

            case 2:     // fecha con el mes como string
                txtMonth.setEnabled(true);
                comboDay.setEnabled(true);
                txtYear.setEnabled(true);
                break;

            case 3:   // checar si dos fechas son iguales
                comboMonth.setEnabled(true);
                comboDay.setEnabled(true);
                txtYear.setEnabled(true);
                comboMonth2.setEnabled(true);
                comboDay2.setEnabled(true);
                txtYear2.setEnabled(true);

                break;
*/
        }
    }

    /**
     * Imprime las fechas
     * @param date objeto Fecha a imprimir
     * @param valid es fecha válida?
     */
    public void PrintDates(Fecha date, boolean valid)
    {
        if(valid)
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

}
