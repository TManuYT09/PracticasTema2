package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Practicas {
    public void uno(){
        Scanner entrada = new Scanner(System.in);
        int fechanum =0;
        boolean comp = true;

        System.out.println("Introduce tu fecha de nacimiento (dd/mm/aaaa):");
        String fecha = entrada.nextLine(); //Aquí pido la fecha
        fecha = fecha.replace("/",""); //Remplaza el caracter / por nada para poder cambiar el tipo de dato de String a Int

        if (fecha.contains("-")){
            System.out.println("No se permiten numeros negativos.");
        } else {

            try{
                fechanum=Integer.parseInt(fecha); //Cambio el valor de String a Int
            }catch (NumberFormatException err){
                System.out.println("Se a detectado que se a introducido mal la fecha.");
                comp=false;
            }

            if(comp){
                if (fecha.length()>8){
                    System.out.println("La fecha introducida no es válida");
                }else {
                    //Aqui sumo el dia, mes y año
                    int dia = fechanum / 1000000; //Pillo el dia
                    int diarest = fechanum % 1000000;
                    int mes = diarest / 10000; //Pillo el mes
                    int ano = diarest % 10000; //Pillo el año

                    if (dia == 0 || mes == 0 || ano == 0 || dia > 31 || mes > 12) {
                        System.out.println("Uno de los valores esta erroneo");
                    } else {
                        int suma1 = dia + mes + ano;

                        //Aqui calcula la suma de cada numero de la suma anterior
                        int num1 = suma1 / 1000; //Pillo el primer numero
                        int rest = suma1 % 1000;
                        int num2 = rest / 100; //Pillo el segundo numero
                        rest = rest % 100;
                        int num3 = rest / 10; //Pillo el tercer numero
                        int num4 = rest % 10; //Pillo el cuarto numero
                        int suma2 = num1 + num2 + num3 + num4;

                        System.out.println(dia + "+" + mes + "+" + ano + " = " + suma1);
                        System.out.println(num1 + "+" + num2 + "+" + num3 + "+" + num4 + " = " + suma2);
                        System.out.println("Tu número de la suerte es " + suma2);
                    }
                }
            }
        }
    }
    public void dos(){
        Scanner entrada=new Scanner(System.in);
        System.out.println("BIENVENIDO A LA CALCULADORA RÁPIDA");
        boolean comp = true;
        double num1 = 0;
        double num2 = 0;

        while (comp){
            try {
                System.out.println("Introduce el primer operando:");
                num1 = entrada.nextInt();
                comp = false;
            }catch (InputMismatchException err){
                System.out.println("Valor introducido no es un número");
                entrada.nextLine();
            }
        }

        System.out.println("Introduce el signo a aplicar (+, -, /, x, R)");
        String ope = entrada.next();
        comp = true;

        if (ope.equals("R")){
            comp = false;
        }

        while (comp){
            try {
                System.out.println("Introduce el segundo operando:");
                num2 = entrada.nextInt();
                comp = false;
            }catch (InputMismatchException err){
                System.out.println("Valor introducido no es un número");
                entrada.nextLine();
            }
        }
        double res = 0;
        comp=true;

        switch (ope){
            case "+":
                res = num1+num2;
                break;
            case "-":
                res = num1-num2;
                break;
            case "/":
                try{
                    res = num1/num2;
                }catch (ArithmeticException err){
                    System.out.println("No se puede hacer "+ num1 +"/"+ num2);
                    comp=false;
                }
                break;
            case "x":
                res = num1*num2;
                break;
            case "R":
                res = Math.sqrt(num1);
                break;
            default:
                System.out.println("El signo "+ ope +" no se esta asignado a ninguna operación");
                comp=false;
                break;
        }

        if (comp){
            System.out.println("El resultado es "+ res);
        }

    }
    public void tres(){
        Scanner entrada=new Scanner(System.in);
        System.out.println("Introduzca ISBN:");
        String isbn=entrada.nextLine();
        int tot=0;
        int num=0;

        for (int i=10;i>0;i--){
            num=Integer.valueOf(isbn.substring(i-1,i));
            tot=tot+(i*num);
        }
        if (tot%11==0){
            System.out.println("El ISBN es válido");
        }else {
            System.out.println("El ISBN no es válido");
        }
    }
}
