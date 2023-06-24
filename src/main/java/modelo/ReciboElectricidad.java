
package modelo;

public class ReciboElectricidad {
    
    private int numRecibo;
    private String nombre;
    private String domicilio;
    private String fecha;
    private int tipoServicio;
    private float costoKilow;
    private int kilowConsum;

    public ReciboElectricidad(int numRecibo, String nombre, String domicilio, String fecha, int tipoServicio, float costoKilow, int kilowConsum) {
        this.numRecibo = numRecibo;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.fecha = fecha;
        this.tipoServicio = tipoServicio;
        this.costoKilow = costoKilow;
        this.kilowConsum = kilowConsum;
    }

    public ReciboElectricidad(ReciboElectricidad RecElec) {
        this.numRecibo = RecElec.numRecibo;
        this.nombre = RecElec.nombre;
        this.domicilio = RecElec.domicilio;
        this.fecha = RecElec.fecha;
        this.tipoServicio = RecElec.tipoServicio;
        this.costoKilow = RecElec.costoKilow;
        this.kilowConsum = RecElec.kilowConsum;
    }

    public ReciboElectricidad() {
        this.numRecibo = 0;
        this.nombre = "";
        this.domicilio = "";
        this.fecha = "";
        this.tipoServicio = 0;
        this.costoKilow = 0.0f;
        this.kilowConsum = 0;
    }

    public int getNumRecibo() {
        return numRecibo;
    }

    public void setNumRecibo(int numRecibo) {
        this.numRecibo = numRecibo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(int tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public float getCostoKilow() {
        return costoKilow;
    }

    public void setCostoKilow(float costoKilow) {
        this.costoKilow = costoKilow;
    }

    public int getKilowConsum() {
        return kilowConsum;
    }

    public void setKilowConsum(int kilowConsum) {
        this.kilowConsum = kilowConsum;
    }
    
    public float CalcularSubTotal(){
        float subt;
        
        if(tipoServicio==1){
            costoKilow=2;
           return subt = (float)(costoKilow*kilowConsum); 
        }
        else if(tipoServicio==2){
            costoKilow=3;
           return subt = (float)(costoKilow*kilowConsum); 
        }
        else if(tipoServicio==3){
            costoKilow=500;
           return subt = (float)(costoKilow*kilowConsum); 
        }
        else{
            return 0;
        }
        
        
    }
    
    public float CalcularImpuesto(){
        float imp;
        return imp =(float)(CalcularSubTotal()*.16);
    }
    
    public float CalcularTotalPagar(){
        float tpagar;
        return tpagar=(float)(CalcularSubTotal()+CalcularImpuesto());
    }
    
    
    
}
