package br.com.fiap.lojaclasses;

import java.util.Scanner;

public class Teste {

	public static void main(String[] args) {
		Cliente c1 = new Cliente();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Escolha qual e a funcao desejada:"
				+ "\nCliente\nI - Incluir novo cliente\tA - Alterar um cliente\nE - Excluir um cliente\t\tP - Pesquisa cliente"
				+ "\n\nCategoria\nIC - Criar nova Categoria\tAC - Alterar uma Categoria\nEC - Excluir Categoria\t\tPC - Pesquisar uma Categoria"
				+ "\n\nProduto\nIP - Criar novo Produto\t\tAP - Alterar um Produto\nPP - Pesquisar Produto\n Opcao: ");
		String opt ;
		opt = sc.next();
		
		switch (opt.toUpperCase()) {
		case "I": {
			System.out.print("Id do cliente: ");
			c1.setIdCliente(sc.nextInt());
			System.out.print("Nome: ");
			c1.setNome(sc.next());
			System.out.print("Email: ");
			c1.setEmail(sc.next());
			System.out.print("CPF: ");
			c1.setCpf(sc.next());
			System.out.print("Telefone: ");
			c1.setTelefone(sc.next());
			c1.insereCliente();
			break;
		}
		case "A": {
			System.out.print("Id do cliente: ");
			c1.setIdCliente(sc.nextInt());
			System.out.print("Email: ");
			c1.setEmail(sc.next());
			System.out.print("Telefone: ");
			c1.setTelefone(sc.next());
			c1.alteraCliente();
			break;
		}
		case "E": {
			System.out.print("Digite o id do cliente que deseja excluir: ");
			c1.setIdCliente(sc.nextInt());
			c1.excluirCliente();
			break;
		}
		case "P": {
			System.out.print("Pesquisar por\n I - ID do Cliente\n N - Nome do Cliente\nOu T - Mostrar todos:  ");
			switch (sc.next().toUpperCase()) {
			case "I":
				System.out.print("Informe o ID: ");
				int idCategoria = sc.nextInt();
				for(Cliente c : c1.pesquisarCliente(idCategoria)) {
					System.out.println(c);
				}
				break;
			case "N":
				sc.nextLine();
				System.out.print("Informe o nome: ");
				String nome = sc.nextLine();
				for(Cliente c : c1.pesquisarCliente(nome)) {
					System.out.println(c);
				}
				break;
			case "T":
				System.out.println("Clientes Cadastrados");
				for(Cliente c : c1.pesquisarCliente()) {
					System.out.println(c);
				}
				break;
			default:
				System.out.println("Opcao invalida!");
			}
			break;		
		}
		case "IC": {
			Categoria cat1 = new Categoria();
			System.out.print("Digite o codigo da Categoria: ");
			cat1.setIdCategoria(sc.nextInt());
			sc.nextLine();
			System.out.print("Digite a descricao da Categoria: ");
			cat1.setDescricao(sc.nextLine());
			cat1.inserirCategoria();
			break;
		}
		case "AC": {
			Categoria cat1 = new Categoria();
			System.out.print("Digite o codigo da Categoria: ");
			cat1.setIdCategoria(sc.nextInt());
			sc.nextLine();
			System.out.print("Digite a descricaoo da Categoria: ");
			cat1.setDescricao(sc.nextLine());
			cat1.alterarCategoria();
			break;
		}
		case "EC": {
			Categoria cat1 = new Categoria();
			System.out.print("Informe o id da categoria: ");
			cat1.setIdCategoria(sc.nextInt());
			cat1.excluirCategoria();
			break;
		}
		case "PC": {
			Categoria cat1 = new Categoria();
			System.out.print("Pesquisar por\n I - ID do categoria\nOu T - Mostrar todas:  ");
			switch (sc.next().toUpperCase()) {
			case "I":
				System.out.print("Informe o ID da categoria: ");
				int idCategoria = sc.nextInt();
				System.out.println(cat1.pesquisarCategorias(idCategoria));
				break;
			case "T":
				System.out.println("Categorias Cadastradas");
				for(Categoria c : cat1.pesquisarCategorias()) {
					System.out.println(c);
				}
				break;
			default:
				System.out.println("Opcao invalida!");
			}
			break;
		}
		case "IP":{
			Categoria cat1 = new Categoria();
			Produto p1 = new Produto();
			System.out.print("Informe o codigo do novo produto: ");
			p1.setIdProduto(sc.nextInt());
			sc.nextLine();
			System.out.print("Informe a descricao do produto: ");
			p1.setDescricao(sc.nextLine());
			System.out.print("Informe o preco do produto: ");
			p1.setPreco(sc.nextDouble());
			System.out.print("Em qual categoria deseja cadastrar o produto?");
			for (Categoria c : cat1.pesquisarCategorias()) {
				System.out.println(c);
			}
			System.out.print("Selecione o ID: ");
			p1.setCategoria(cat1.pesquisarCategorias(sc.nextInt()));
			p1.inserirProduto();
			break;
		}
		case "AP": {
			Produto p1 = new Produto();
			System.out.print("Informe o ID do produto: ");
			p1.setIdProduto(sc.nextInt());
			sc.nextLine();
			System.out.print("Informe a nova descricao: ");
			p1.setDescricao(sc.nextLine());
			System.out.print("Informe o novo preco: ");
			p1.setPreco(sc.nextDouble());
			p1.alterarProduto();
			break;
		}
		case "PP":{
			Produto p1 = new Produto();
			System.out.print("Pesquisar por\nD - Descricao\nOU T - Mostrar do todos: ");
			opt = sc.next().toUpperCase();
			System.out.println("Produtos Cadastrados");
			switch(opt) {
			case "D":
				System.out.print("Informe a descricao do produto: ");
				String desc = sc.next();
				for (Produto p : p1.pesquisarProduto(desc)) {
					System.out.println(p);
				}
				break;
			case "T":
				for (Produto p : p1.pesquisarProduto()) {
					System.out.println(p);
				}				
			}
			break;
		}
		default:
			System.out.println("Opcao invalida!");
		}
		
		sc.close();
	}

}
