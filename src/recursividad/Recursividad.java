
package recursividad;

import java.util.Random;
import java.util.Scanner;

public class Recursividad  {
    
    public Recursividad(){
        
    }

/*public int suma(int a[], int n){
    if(n==0)
        return 0;
    else
        return n + suma(int a[], int (n-1));
}    */
  




//metodo recursivo que dado un arreglo de objetos cuente y regrese cuantas posiciones no nulas tiene

public int cuenta (Object arreglo[], int i, int cont){
    if(i==arreglo.length)
        return cont;
    else {
    if(arreglo[i]== null)
        return cuenta(arreglo, i+1, cont);
    else
        return cuenta(arreglo, i+1,  cont+1);
}
}

public int cuenta(Object A[], int i){
    if(i<0)
        return 0;
    if(A[i]==null)
      return  cuenta(A, i-1);
    else
        return 1 + cuenta(A, i-1); 
}


//dado un arreglo de int haga un metodo recursivo
/*
 * a) regresa los elementos de 0 al n en una cadena
 * b) que regrese los elementos del n al 0 en una cadena
 */

//a)
public String ImprimeA(int a[], int i){
       
    if(i==a.length)
       return " ";
    else
        return a[i]+ImprimeA(a,i+1);      
 
   
}

//b)
public String ImprimeB(int a[], int i){
     if(i==a.length)
       return " ";
    else
        return ImprimeB(a,i+1)+a[i];      
 
}

public int BusquedaBinaria(int a[],int elemento, int i, int j){
    int n=j-i, m=0;
    if(n%2==0)
            m=n/2;
        else
            m=(n%2)+1;
    if(a[m]==elemento)
        return m;
    if(i==j && a[i]==elemento )
        return i;
    if(i>j)
        return -1;
    else{
        if(elemento<a[m])
           return BusquedaBinaria(a, elemento,i,m);
        else
            return BusquedaBinaria(a, elemento,m,n);
    }
      
}

//metodo dado un int n imprima todas las permutaciones de los primeros n enteros
/*ej
 *n=2
 * 1 2
 * 2 1
 */
public void imprimePermutaciones(int n, String s, int limite ){
    
    if(limite==n)
        System.out.println(s); 
    else
    for(int i=1;i<=n;i++){
        if(!s.contains(i+""))
        imprimePermutaciones(n,s+(i+""),limite+1);
    }
        
}

public void laberinto(int fila, int columna, int x,int y, int movimientos ){
    int[][] laberinto=new int[fila][columna];
   // Random rand=new Random();
    //rand.nextInt(n-1);
   // rand.nextInt(m-1);
   //paso base
    if(!contains(laberinto,0))
        imprimeMatriz(laberinto);
    else
        laberinto[x][y]=movimientos;
    //laberinto(fila,columna,x,y,movimientos+1);
    
    
    //movimientos
   int derecha=y+1, izquierda=y-1, arriba=x-1, abajo=x+1;
   
    //casos bordes
    if(laberinto [x][izquierda]!=0 || y==0)//restriccion izquierda 
        laberinto(fila,columna,arriba,y,movimientos+1);//arriba
    if(laberinto[arriba][y]!=0 || x==0)//restriccion arriba
        laberinto(fila,columna,x,derecha,movimientos+1);//derecha
    if(laberinto[x][derecha]!=0 || y==columna)//restriccion derecha
        laberinto(fila,columna,abajo,y,movimientos+1);//abajo
    else
        laberinto(fila,columna,x,izquierda,movimientos+1);//izquierda
    
}

    

public boolean contains (int [][]matriz, int n){
    boolean resp=true;
    int i=0,j=0;
    int Nofilas=matriz.length, Nocolumnas=matriz[i].length;
    while( i<= Nofilas && matriz[i][j]!=n ){
        j++;
        if(j==Nocolumnas)
            j=0;
            i++;
}
    if(i>Nofilas)
        resp=false;
    return resp;
}

public void imprimeMatriz(int [][] m){
    for(int i=0;i<m.length;i++){
        for(int j=0;i<m.length;j++)
            System.out.print(m[i][j]+" ");
    }
    System.out.println();
}
        
public static void main (String[] args){
    Recursividad p = new Recursividad();
    Object a[]={1, null, 2,null,4,2};
    int resp;
    int ar[]={1,2,3,4,5,6,7};
    
    /*resp=p.cuenta(a, 0);
    System.out.println(resp);
    String resps;
    
    System.out.println("inciso a");
    resps=p.ImprimeA(ar,0);
        System.out.println(resps);
    System.out.println("inciso b");    
    resps=p.ImprimeB(ar, 0);
    System.out.println(resps);
       */
   //resp= p.BusquedaBinaria(ar, 7, 0, ar.length);
    //System.out.println(resp);
    
  // System.out.println("Impresion permutacion de n numero");
  //  p.imprimePermutaciones(2, "", 0);

//juego laberinto
    int n,m,x,y;
    Random rand=new Random();
    Scanner lectura=new Scanner(System.in);
    System.out.println("Ingresa numero de filas de tu tablero: ");
    n=lectura.nextInt();
    System.out.println("Ingresa numero de columnas de tu tablero: ");
    m=lectura.nextInt();
    
    x=rand.nextInt(n-1);
    y=rand.nextInt(m-1);
    
    p.laberinto(n, m, x, y, 0);
    
    
   

}
}
