package main.java.com.miempresa.miapp;

public class Banco {
	private double balance;

	public Banco(double BalanceInicial) {
		if (BalanceInicial < 0) {
			throw new IllegalArgumentException("El saldo inicial no puede ser negativo");
		}

		this.balance = BalanceInicial;
	}

	public void Deposito(double cantidad) {
		if (cantidad <= 0) {
			throw new IllegalArgumentException("El monto del depósito debe de ser positivo");

		}
		balance += cantidad;
	}

	public void retirar(double cantidad) {

		if (cantidad <= 0) {
			throw new IllegalArgumentException("El monto del retiro debe ser positivo");
		}
		if (cantidad > balance) {
			throw new IllegalArgumentException("Fondos insuficientes");
		}
		balance -= cantidad;

	}

	public double getBaleance() {

		return balance;
	}

}
