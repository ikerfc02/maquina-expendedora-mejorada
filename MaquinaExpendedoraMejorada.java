public class MaquinaExpendedoraMejorada {
    
    // El precio del billete
    private int precioBillete;
    // La cantidad de dinero que lleva metida el cliente actual
    private int balanceClienteActual;
    // El total de dinero almacenado en la maquina desde su ultimo vaciado
    private int totalDineroAcumulado;
    // El origen del billete
    private String estacionOrigen;
    // El destino del billete
    private String estacionDestino;
    // El numero de billetes vendidos
    private int numeroBilletes;
    // Especifica si es con premio o sin premio
    private boolean maquinaPremio;
    //El numero maximo de billetes que se pueden vender
    private int numeroMaximo;

    /**
     * Crea una maquina expendedora de billetes de tren con el 
     * precio del billete y el origen y destino dados. Se asume que el precio
     * del billete que se recibe es mayor que 0.
     */
    public MaquinaExpendedoraMejorada(int precioDelBillete, String origen, String destino, boolean maquinaConSinPremio, int numeroMaximoBilletes) {
        precioBillete = precioDelBillete;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = origen;
        estacionDestino = destino;
        numeroBilletes = 0;
        maquinaPremio = maquinaConSinPremio ;
        numeroMaximo = numeroMaximoBilletes;
    }

    /**
     * Devuelve el precio del billete
     */
    public int getPrecioBillete() {
        return precioBillete;
    }

    /**
     * Devuelve la cantidad de dinero que el cliente actual lleva introducida
     */
    public int getBalanceClienteActual() {
        return balanceClienteActual;
    }

    /**
     * Simula la introduccion de dinero por parte del cliente actual
     */
    public void introducirDinero(int cantidadIntroducida) {
        if (numeroMaximo > 0) {
            if (cantidadIntroducida > 0) {
                balanceClienteActual = balanceClienteActual + cantidadIntroducida;
            }
            else {
                System.out.println(cantidadIntroducida + " no es una cantidad de dinero valida.");
            }        
        }
        else {
            System.out.println("No se permite introducir más dinero, cantidad de billetes superada.");
        }
    }
    

    /**
     * Imprime un billete para el cliente actual
     */
    public void imprimirBillete() {
        int cantidadDeDineroQueFalta = precioBillete - balanceClienteActual;
        if (numeroMaximo <= 0) {
            System.out.println("No es posible imprimir el billete, numero vendido de billetes excedido");
        }
        
        else { 
            if (cantidadDeDineroQueFalta <= 0) { 
                System.out.println("##################");
                System.out.println("# Billete de tren:");
                System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
                System.out.println("# " + precioBillete + " euros.");
                System.out.println("##################");
                if (maquinaPremio == true) {
                    // Simula la impresion de un billete con Premio            
                    System.out.println("Además tienes " + (precioBillete * 0.1) + " en el establecimiento que quieras.");
                }
                
                // Actualiza el total de dinero acumulado en la maquina
                totalDineroAcumulado = totalDineroAcumulado + precioBillete;
                // Reduce el balance del cliente actual dejandole seguir utilizando la maquina
                balanceClienteActual = balanceClienteActual - precioBillete;
                //Incrementa numero de billetes vendidos
                numeroBilletes = numeroBilletes + 1;
                //Resta el numero de billetes vendidos
                numeroMaximo = numeroMaximo - 1;
            }
            else {
                System.out.println("Necesitas introducir " + cantidadDeDineroQueFalta + " euros mas!");            
            }
        }  
    }
    
    /**
     * Cancela la operacion de compra del cliente actual y le
     * devuelve al cliente el dinero que ha introducido hasta el momento
     */
    public int cancelarOperacionYDevolverDinero() {
        int cantidadDeDineroADevolver;
        cantidadDeDineroADevolver = balanceClienteActual;
        balanceClienteActual = 0;
        return cantidadDeDineroADevolver;
    } 
    
    /**
     * Vacía todos los depósitos de la máquina.
     */
    public int vaciarDeposito() {
        int totalAVaciar = totalDineroAcumulado + balanceClienteActual;
        if (balanceClienteActual != 0) {
            System.out.println("Se está realizando una operación.");
            System.out.println("Por favor retire su dinero antes.");
            totalAVaciar = -1; 
        }
        else {
            totalDineroAcumulado = 0;        
            
        }
        return totalAVaciar;
    }
    
    /**
     * Devuelve numero de billetes vendidos
     */
    public int getNumeroBilletesVendidos() { 
        return numeroBilletes;
    }
    
    /**
     * Imprime numero de billetes vendidos
     */
    public void imprimeNumeroBilletesVendidos() {
        System.out.println("Se han vendido " + numeroBilletes + " billetes." );
    }
}
