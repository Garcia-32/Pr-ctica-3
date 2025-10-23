
package ejercicio_licencias;



abstract class Licencia 
{   //ATRIBUTOS
   protected String version;
   private int cantidadLicencias;
   protected double precio, importeDescuento, importeCompra, importePagar, porcentajeDescuento;

   //CONSTRUCTORES
   public Licencia(String version, int cantidadLicencias)
   {   this.version = version;
       this.cantidadLicencias = cantidadLicencias;
   }
   //METODOS DE CLASE ABSTRACTA
   public void calcularDescuento()
   {   if(cantidadLicencias < 5)
           porcentajeDescuento = 11;
       else
           if(cantidadLicencias >= 5 && cantidadLicencias < 10)
               porcentajeDescuento = 13;
           else
               if(cantidadLicencias >= 10)
                   porcentajeDescuento = 14;
   }
   public void calcularImportePagar()
   {   this.importeCompra = cantidadLicencias * precio;
       this.importeDescuento = importeCompra * porcentajeDescuento/100;
       this.importePagar = importeCompra - importeDescuento;
   }
   //METODOS ABTRACTOS
   public abstract void calcularPrecio();
   public abstract String toString();
}
//CLASE HIJA
class LicenciaEstudiante extends Licencia
{
    //CONSTRUCTOR DE LA CLASE HIJA
   public LicenciaEstudiante(int cantidadLicencias)
   {   
       super("ESTUDIANTE",cantidadLicencias );
       //LLAMADA A METODOS PRIVADOS
       this.calcularPrecio();
       this.calcularDescuento();
       this.calcularImportePagar();
   }
   //METODOS ABSTRACTOS
   @Override
   public void calcularPrecio() 
   {
       this.precio = 90.00; 
   }
   @Override
   public String toString()
   {
       StringBuffer resultado = new StringBuffer("---------------------------");
       resultado.append("\nDATOS DE LA LICENCIA " + this.version + "\n---------------------------");
       resultado.append("\nPrecio :" + this.precio);
       resultado.append("\nImporte Compra :" + this.importeCompra);
       resultado.append("\nImporte Descuento :" + this.importeDescuento);
       resultado.append("\nImporte a Pagar :" + this.importePagar);
       
       return resultado.toString();
   }   
}


class LicenciaProfesional extends Licencia
{
   public LicenciaProfesional(int cantidadLicencias)
   {   
       super("PROFESIONAL",cantidadLicencias );
       //LLAMADA A METODOS PRIVADOS
       this.calcularPrecio();
       this.calcularDescuento();
       this.calcularImportePagar();
   }
   @Override
   public void calcularPrecio() 
   {
       this.precio = 120.00; 
   }
   @Override
   public String toString()
   {
       StringBuffer resultado = new StringBuffer("---------------------------");
       resultado.append("\nDATOS DE LA LICENCIA " + this.version + "\n---------------------------");
       resultado.append("\nPrecio :" + this.precio);
       resultado.append("\nImporte Compra :" + this.importeCompra);
       resultado.append("\nImporte Descuento :" + this.importeDescuento);
       resultado.append("\nImporte a Pagar :" + this.importePagar);
       
       return resultado.toString();
   }  
}


class LicenciaEmpresarial extends Licencia
{
    public LicenciaEmpresarial(int cantidadLicencias)
   {   
       super("EMPRESARIAL",cantidadLicencias );
       //LLAMADA A METODOS PRIVADOS
       this.calcularPrecio();
       this.calcularDescuento();
       this.calcularImportePagar();
   }
   @Override
   public void calcularPrecio() 
   {
       this.precio = 150.00; 
   }
   @Override
   public String toString()
   {
       StringBuffer resultado = new StringBuffer("---------------------------");
       resultado.append("\nDATOS DE LA LICENCIA " + this.version + "\n---------------------------");
       resultado.append("\nPrecio :" + this.precio);
       resultado.append("\nImporte Compra :" + this.importeCompra);
       resultado.append("\nImporte Descuento :" + this.importeDescuento);
       resultado.append("\nImporte a Pagar :" + this.importePagar);
       
       return resultado.toString();
   }  
}
class Main 
{
   static  Licencia[] ArregloLicencias = new Licencia[6];
   public static void imprimirLicencia(Licencia licencia)
   {
       System.out.println(licencia.toString());//POLIMORFISMO
   }
   public static void main(String[] args) 
   {
       ArregloLicencias[0] = new LicenciaEstudiante(4);
       ArregloLicencias[1] = new LicenciaEstudiante(3);
       ArregloLicencias[2] = new LicenciaProfesional(2);
       ArregloLicencias[3] = new LicenciaEmpresarial(1);
       ArregloLicencias[4] = new LicenciaProfesional(3);
       ArregloLicencias[5] = new LicenciaEmpresarial(1);
       
       for(Licencia licencia : ArregloLicencias)
       {
           imprimirLicencia(licencia);
       }
   }
}