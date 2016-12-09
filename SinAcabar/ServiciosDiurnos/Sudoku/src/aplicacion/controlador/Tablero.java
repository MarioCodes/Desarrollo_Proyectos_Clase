/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador;

/**
 * Tablero de juego. Es el conjunto de Cuadrados, Filas y Columnas, cada uno con sus casillas correspondientes.
 * @author Mario Codes Sánchez
 * @since 08/12/2016
 */
public class Tablero {
    private Cuadrado[] cuadrados = new Cuadrado[9];
    private Fila[] filas = new Fila[9];
    private Columna[] columnas = new Columna[9];
    
    /**
     * Constructor para inicializar el Tablero de juego. El se encargara de inicializar todo lo necesario.
     */
    public Tablero() {
        preparacionTablero();
    }
    
    /**
     * Pasos necesarios para que el tablero este listo.
     */
    private void preparacionTablero() {
        iniCuadrados();
        rellenoFilas();
        rellenoColumnas();
    }
    
    /**
     * Inicializacion de los Cuadrados. 
     * todo: Mas adelante habra que poner los numeros de cada casilla. Ahora mismo se ponen solas a 0.
     */
    private void iniCuadrados() {
        for (int i = 0; i < cuadrados.length; i++) {
            cuadrados[i] = new Cuadrado();
        }
    }
    
    /**
     * Introduccion en si misma. Se debera repetir 3 veces.
     * @param numPrimerCuadrado Numero del primer cuadrado. Debera ser 0/3/6.
     */
    private void introduccionCasillasCuadradosEnFilas(int numPrimerCuadrado) {
        Casilla[] casillasTmp; //Almacen temporal hasta que este la fila completa y se introduzcan.
        
        for (int indiceFila = numPrimerCuadrado, indiceCasillaTmp, indiceCasillaCuadrado = 0; indiceFila <= numPrimerCuadrado+2; indiceFila++, indiceCasillaCuadrado += 3) {
            casillasTmp = new Casilla[9];
            indiceCasillaTmp = 0;
            for (int x = 0; x <= 2; x++) {
                casillasTmp[indiceCasillaTmp++] = cuadrados[numPrimerCuadrado].getCASILLAS()[indiceCasillaCuadrado];
                casillasTmp[indiceCasillaTmp++] = cuadrados[numPrimerCuadrado+1].getCASILLAS()[indiceCasillaCuadrado+1];
                casillasTmp[indiceCasillaTmp++] = cuadrados[numPrimerCuadrado+2].getCASILLAS()[indiceCasillaCuadrado+2];
            }
            filas[indiceFila] = new Fila(casillasTmp);
        }
    }
    
    /**
     * Introduccion de las Casillas de los Cuadrados en las Filas.
     */
    private void rellenoFilas() {
        introduccionCasillasCuadradosEnFilas(0);
        introduccionCasillasCuadradosEnFilas(3);
        introduccionCasillasCuadradosEnFilas(6);
    }
    
    /**
     * Obtencion del numero de la primera columna que no se haya instanciado, para saber a partir de cual empezar a rellenar.
     * @return Int con la primera posicion a rellenar.
     */
    private int obtenerPrimeraColumnaNula() {
        for (int i = 0; i < columnas.length; i++) {
            if(columnas[i] == null) return i;
        }
        
        return -1; //Nunca deberia llegar a este punto.
    }
    
    /**
     * Idem a las Filas pero introduciendo las Casillas en las columnas.
     * @param numPrimerCuadrado Numero del primer cuadrado. Debera ser 0/1/2.
     */
    private void introduccionCasillasCuadradosEnColumnas(int numPrimerCuadrado) {
        Casilla[] casillasTmp;
        int indicePrimeraColumna = obtenerPrimeraColumnaNula();
        
        for (int indiceColumna = indicePrimeraColumna, indiceCasillaTmp, indiceCasillaCuadrado = 0; indiceColumna <= indicePrimeraColumna+2; indiceColumna++, indiceCasillaCuadrado += 1) {
            casillasTmp = new Casilla[9];
            indiceCasillaTmp = 0;
            for (int i = 0; i <= 2; i++) {
                casillasTmp[indiceCasillaTmp++] = cuadrados[numPrimerCuadrado].getCASILLAS()[indiceCasillaCuadrado];
                casillasTmp[indiceCasillaTmp++] = cuadrados[numPrimerCuadrado+3].getCASILLAS()[indiceCasillaCuadrado+3];
                casillasTmp[indiceCasillaTmp++] = cuadrados[numPrimerCuadrado+6].getCASILLAS()[indiceCasillaCuadrado+6];
            }
            columnas[indiceColumna] = new Columna(casillasTmp);
        }
    }
    
    /**
     * Introduccion de las Casillas en las columnas correspondientes.
     */
    private void rellenoColumnas() {
        introduccionCasillasCuadradosEnColumnas(0);
        introduccionCasillasCuadradosEnColumnas(1);
        introduccionCasillasCuadradosEnColumnas(2);
    }
    
    @Override
    public String toString() {
        String buffer = "Cuadrados: \n";
        
        for(Cuadrado cuad : cuadrados) {
            buffer += cuad;
        }
        
        buffer += "Filas: \n";
        for(Fila fil : filas) {
            buffer += fil;
        }
        
        buffer += "\nColumnas: \n";
        for(Columna col : columnas) {
            buffer += col;
        }
        
        return buffer;
    }
}
