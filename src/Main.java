import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Variables
        Scanner input = new Scanner(System.in);
        char letraX = 'X';
        char letraO = 'O';
        boolean turnoX = true;
        char[][] tablero = {
                {'-', '-', '-'},
                {'-', '-', '-'},
                {'-', '-', '-'}
        };
        boolean terminoJuego = false;

        //Bucle principal
        while(!terminoJuego){
            if(turnoX){
                int columna = pedirColumna(input);
                int fila = pedirFila(input);
                while(tablero[columna][fila] != '-'){
                    System.out.println("Ese lugar se encuentra ocupado");
                    columna = pedirColumna(input);
                    fila = pedirFila(input);
                }
                tablero[columna][fila]=letraX;
                pintarTabla(tablero);
                turnoX=false;
            }else{
                int columna = pedirColumna(input);
                int fila = pedirFila(input);
                while(tablero[columna][fila] != '-'){
                    System.out.println("Ese lugar se encuentra ocupado");
                    columna = pedirColumna(input);
                    fila = pedirFila(input);
                }
                tablero[columna][fila]=letraO;
                pintarTabla(tablero);
                turnoX=true;
            }
            boolean ganoX= ganoJugador(tablero,letraX);
            if(!ganoX){
                boolean ganoO = ganoJugador(tablero,letraO);
                if(!ganoO){
                    boolean empate=empate(tablero,terminoJuego);
                    if(empate) terminoJuego=true;
                }else{
                    terminoJuego = true;
                }
            }else{
                terminoJuego = true;
            }
        }
    }

    //Metodos:

    //Pintar tabla:
    public static void pintarTabla(char[][] tablero){
        for(int i = 0; i < tablero.length; i++){
            System.out.println();
            for(int j = 0;j < 3;j++){
                System.out.print("|"+tablero[i][j]+"|");
            }
        }
        System.out.println();
    }

    //Pedir columna:
    public static int pedirColumna(Scanner input){
        boolean seguirPidiendo = true;
        int columna = 0;
        while(seguirPidiendo) {
            System.out.println("-------------------------------");
            System.out.println("Ingrese columna puede ser 0|1|2");
            System.out.println("-------------------------------");
            int test = input.nextInt();
            input.nextLine();
            if (test != 0 && test != 1 && test != 2) {
                System.out.println("Debe ser 0-1-2");
                columna=4;
            } else {
                columna = test;
                seguirPidiendo = false;
            }
        }
        return columna;
    }

    //Pedir fila:
    public static int pedirFila(Scanner input){
        boolean seguirPidiendo = true;
        int fila = 0;
        while(seguirPidiendo) {
            System.out.println("----------------------------");
            System.out.println("Ingrese fila puede ser 0|1|2");
            System.out.println("----------------------------");
            int test = input.nextInt();
            input.nextLine();
            if (test != 0 && test != 1 && test != 2) {
                System.out.println("Debe ser 0-1-2");
                fila=4;
            } else {
                fila = test;
                seguirPidiendo = false;
            }
        }
        return fila;
    }

    //Verificar si gano algun jugador
    public static boolean ganoJugador(char[][] tablero,char letra) {
        if ((tablero[0][0] == letra && tablero[0][1] == letra && tablero[0][2] == letra) ||
                (tablero[1][0] == letra && tablero[1][1] == letra && tablero[1][2] == letra) ||
                (tablero[2][0] == letra && tablero[2][1] == letra && tablero[2][2] == letra)) {
            System.out.println("Gano jugador: " + letra);
            return true;
        } else if ((tablero[0][0] == letra && tablero[1][0] == letra && tablero[2][0] == letra) ||
                (tablero[0][1] == letra && tablero[1][1] == letra && tablero[2][1] == letra) ||
                (tablero[0][2] == letra && tablero[1][2] == letra && tablero[2][2] == letra)) {
            System.out.println("Gano jugador: " + letra);
            return true;
        }else if((tablero[0][0] == letra && tablero[1][1] == letra && tablero[2][2] == letra) ||
                (tablero[0][2] == letra && tablero[1][1] == letra && tablero[2][0] == letra)){
            System.out.println("Gano jugador: " + letra);
            return true;
        }
        return false;
    }

    public static boolean empate(char[][] tablero,boolean termino){
        if(!termino && (tablero[0][0]!='-' && tablero[0][1]!='-' && tablero[0][2]!='-') &&
                (tablero[1][0]!='-' && tablero[1][1]!='-' && tablero[1][2]!='-') &&
                (tablero[2][0]!='-' && tablero[2][1]!='-' && tablero[2][2]!='-')){
            System.out.println("Empate!");
            return true;
        }
        return false;
    }
}