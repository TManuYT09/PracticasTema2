package org.example;

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
}
