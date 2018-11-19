package pkgMetrics;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.*;
public class TestePilha {
    // Definindo a classe que representará cada elemento da Pilha
    private static class Pilha {
        public int numero;
        public double valor;
        public int pedido;
        public Pilha prox;
    }
    public static void main(String[] args) {
        Pilha topo = null;
        Pilha aux;
        int op = 0;
        do {
            try {
                op = Integer.parseInt(JOptionPane.showInputDialog(opcoesMenu(), "1"));
            } catch (Exception e) {
                // Silent exception
                System.out.println("");
            }

            if (op < 1 || op > 8) {
                mensagem("Opção Inválida!");
            }
            // INSERIR/EMPILHAR CHAPAS - DESAFIO 1
            if (op == 1) {
                topo = opcao1(topo);
            }
            // CONSULTAR CHAPAS CADASTRADAS
            if (op == 2) {
                opcao2(topo);
            }
            // DESEMPILHAR CHAPA
            if (op == 3) {
                topo = opcao3(topo);
            }
            // ESVAZIAR PÁTIO
            if (op == 4) {
                topo = opcao4(topo);
            }
            // QUANTIDADE E CHAPAS 
            if (op == 5) {
                opcao5(topo);
            }
            // FILTRAR CHAPAS CADASTRADAS - DESAFIO 3
            if (op == 6) {
                opcao6(topo);
            } 
            
        } while (op != 7);
        System.out.println(">>> PROGRAMA FINALIZADO!");

    } // FIM MÉTODO MAIN()

	private static void opcao6(Pilha topo) {
		Pilha aux;
		if (topo == null) {
		    pilhaVazia();
		} else {
		    topoDifNull(topo);
		}
	}

	private static void topoDifNull(Pilha topo) {
		consChapCad(topo);
	}

	private static void consChapCad(Pilha topo) {
		consultaChaCadPorPilha(topo);
	}

	private static void consultaChaCadPorPilha(Pilha topo) {
		consNovamente(topo);
	}

	private static void consNovamente(Pilha topo) {
		Pilha aux;
		int npedido = Integer.parseInt(JOptionPane.showInputDialog(
		        "NÚMERO DO PEDIDO", "0"));
		JTextArea saida = new JTextArea(6, 35); // HEIGHT X WIDTH
		JScrollPane scroll = new JScrollPane(saida);
		saida.append("FILTRO, CHAPAS PARA O PEDIDO NRO: " + npedido + "\n");
		saida.append("NÚMERO\t" + "VALOR\t" + "PEDIDO\n");
		saida.append("================================\n");
		aux = topo;
		while (aux != null) {
		    if (aux.pedido == npedido) {
		        saida.append(aux.numero + "\t" + aux.valor + "\t" + aux.pedido + "\n");
		    }
		    aux = aux.prox;
		}
		JOptionPane.showMessageDialog(null, scroll, 
		        "CONSULTAR CHAPAS CADASTRADAS", 
		        JOptionPane.INFORMATION_MESSAGE);
	}

	private static void opcao5(Pilha topo) {
		void5(topo);
	}

	private static void void5(Pilha topo) {
		confOpcao5(topo);
	}

	private static void confOpcao5(Pilha topo) {
		Pilha aux;
		aux = topo;
		int n = 0;
		while (aux != null) {
		    aux = aux.prox;
		    n++;
		}
		mensagem("A Pilha contém: " + n + " elementos.");
	}

	private static Pilha opcao4(Pilha topo) {
		return pilha4(topo);
	}

	private static Pilha pilha4(Pilha topo) {
		return confOpcao4(topo);
	}

	private static Pilha confOpcao4(Pilha topo) {
		if (topo == null) {
		    mensagem("A Pilha está vazia!");
		} else {
		    topo = null;
		    mensagem("A Pilha foi esvaziada!");
		}
		return topo;
	}

	private static Pilha opcao3(Pilha topo) {
		return pilha3(topo);
	}

	private static Pilha pilha3(Pilha topo) {
		return confOpcao3(topo);
	}

	private static Pilha confOpcao3(Pilha topo) {
		if (topo == null) {
		    pilhaVazia();
		} else {
		    mensagem("Número: " + topo.numero + ", foi removido.");
		    topo = topo.prox;
		}
		return topo;
	}

	private static void opcao2(Pilha topo) {
		void2(topo);
	}

	private static void void2(Pilha topo) {
		confOpcao2(topo);
	}

	private static void confOpcao2(Pilha topo) {
		verificar(topo);
	}

	private static void verificar(Pilha topo) {
		Pilha aux;
		if (topo == null) {
		    pilhaVazia();
		} else {
		    JTextArea saida = new JTextArea(6, 35); // HEIGHT X WIDTH
		    JScrollPane scroll = new JScrollPane(saida);
		    saida.append("NÚMERO\t" + "VALOR\t" + "PEDIDO\n");
		    saida.append("===============================\n");
		    aux = topo;
		    while (aux != null) {
		        // VERIFICAR ENDER E PROX (DESAFIO 2)
		        if (aux.prox != null) {
		            System.out.println("Num: " + aux.numero + ", endereço: " 
		                    + aux.hashCode() + " => " + " Prox => " 
		                    + aux.prox.hashCode() + "\n");
		        }

		        saida.append(aux.numero + "\t" + aux.valor + "\t" + aux.pedido + "\n");
		        aux = aux.prox;
		    }
		    JOptionPane.showMessageDialog(null, scroll, 
		            "CONSULTAR CHAPAS CADASTRADAS", 
		            JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private static void pilhaVazia() {
		mensagem("A PILHA está vazia!");
	}

	private static Pilha opcao1(Pilha topo) {
		return pilha1(topo);
	}

	private static Pilha pilha1(Pilha topo) {
		return confOpcao1(topo);
	}

	private static Pilha confOpcao1(Pilha topo) {
		Pilha aux;
		int numero = Integer.parseInt(JOptionPane.showInputDialog("NÚMERO DA CHAPA", "0"));
		aux = topo;
		boolean achou = false;
		while (aux != null) {
		    if (aux.numero == numero) {
		        achou = true;
		        mensagem("Esse número de chapa já foi empilhado.\nFavor verificar!");
		        break;
		    }
		    aux = aux.prox;
		}
		if (achou == false) {
		    topo = achouIglFal(topo, numero);
		}
		return topo;
	}

	private static Pilha achouIglFal(Pilha topo, int numero) {
		Pilha novo = new Pilha();
		novo.numero = numero;
		novo.valor = Double.parseDouble(JOptionPane.showInputDialog("VALOR DA CHAPA", "0"));
		novo.pedido = Integer.parseInt(JOptionPane.showInputDialog("NÚMERO DO PEDIDO", "0"));
		novo.prox = topo;
		topo = novo;
		return topo;
	}

    // STRING - OPÇÕES MENU
    private static String opcoesMenu() {
        return opcoesMenu7();
    }
    // MÉTODO VOID MENSAGEM()

	private static String opcoesMenu7() {
		return menuOpcoes();
	}

	private static String menuOpcoes() {
		String menu = "\nMENU DE OPÇÕES\n"
                + "\n1 - Empilhar Chapas."
                + "\n2 - Consultar Todas as Chapas."
                + "\n3 - Desempilhar Chapas."
                + "\n4 - Remover Todas as Chapas Da Pilha."
                + "\n5 - Verificar Quantidade de Chapas."
                + "\n6 - Filtrar Chapas Por Pedido."
                + "\n7 - Sair";
        return menu;
	}

    private static void mensagem(String a) {
        msgPrograma(a);
    }

	private static void msgPrograma(String a) {
		JOptionPane.showMessageDialog(null, a, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
	}
    
}