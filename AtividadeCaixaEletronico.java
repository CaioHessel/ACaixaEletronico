
package atividadecaixaeletronico;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Caio Cesar
 */
public class AtividadeCaixaEletronico {

    
            
    
    public static void main(String[] args) {
        
        Scanner ler = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#,###");
        ArrayList<Double> deposito = new ArrayList<>();
        ArrayList<Double> saque = new ArrayList<>();
        
        String senha = "01020304", senhau, cpf = "123.456.789-00", cpfu;  
                
        int escolhamenu = 0, x = 0;
        
        double saldo = 1000, valordep, valorsaque;
                
                
        do {           
        System.out.println("=========================");
        System.out.println("        BEM VINDO        ");
        System.out.println("=========================");
        System.out.print("Digite seu CPF: ");
        cpfu = ler.next();
        //Verificando se há diferença entre o CPF digitado e o que está dentro da variável.
        if(!cpfu.equals(cpf)){
            System.out.println("Acesso negado");    
            return;
        }
        System.out.print("Digite sua senha: ");
        senhau = ler.next();
        /*
        Verificando se há diferença entre a senha digitada e a que está na variável.
        Caso haja diferença permite-se 2 tentativas, se persistir a diferença bloqueia conta.  
        */
        if(!senhau.equals(senha)){
            for (int i = 0; i < 3; i++) {
                if(senhau.equals(senha)){
                    break;
                }else if (i == 2){
                    System.out.println("Conta bloqueada");
                    break;
                }else{
                    System.out.println("Digite novamente sua senha: ");
                    senhau = ler.next();
                }
            }
        }
        do {
        System.out.println("=========================");
        System.out.println("        1-SALDO          ");
        System.out.println("        2-DEPÓSITO       ");
        System.out.println("        3-SAQUE          ");
        System.out.println("        4-EXTRATO        ");
        System.out.println("        0-SAIR           ");
        System.out.println("=========================");
        System.out.println("Digite a opção desejada: ");
        escolhamenu = ler.nextInt();
        //Após receber a informação da operação desejada é direcionado para seu respectivo caso.
        switch(escolhamenu){
                case(1):
                    System.out.println("Seu saldo é de R$ "+df.format(saldo));
                    break;
                case(2):                                     
                    System.out.println("Digite o valor a ser depositado: ");
                    valordep = ler.nextDouble();
                    saldo += valordep;
                    deposito.add(valordep);
                    break;
                case(3):
                    System.out.println("Digite o valor a ser sacado: ");
                    valorsaque = ler.nextDouble();
                    saldo -= valorsaque;
                    saque.add(valorsaque);
                    break;
                case(4):
                    for (int i = 0; i < deposito.size(); i++) {
                        System.out.println("Deposito " + deposito.get(i));
                    }
                    for (int s = 0; s < saque.size(); s++) {
                        System.out.println("Saque " + saque.get(s));
                    }
                    break;
                case(0):
                    System.out.println("Obrigado por utilizar o nosso sistema!");
                    break;
                default:
                    System.out.println("Digite uma opção entre 0 e 3!");
                    break;
            }   
        }while (escolhamenu != 0);
        x++;
        }while(x != 0);
    }//Fim método
}//Fim clase
