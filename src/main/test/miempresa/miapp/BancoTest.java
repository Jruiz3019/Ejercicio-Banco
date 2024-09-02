package main.test.miempresa.miapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.com.miempresa.miapp.Banco;

class BancoTest {

	private Banco banco;

	@BeforeEach
	void setUp() {
		// Se ejecuta antes de cada prueba para inicializar el objeto Banco
		// Saldo inicial de 1000
		banco = new Banco(1000.0);
	}

	@AfterEach
	void despues() {
		System.out.println("Terminando prueba");
	}

	@Test
	void testDeposito() {
		banco.Deposito(500.0);
		assertEquals(1500.0, banco.getBaleance(), "El saldo después del depósito debe ser 1500.0");
	}

	@Test
	void testDepositoNegativo() {
		Exception excepcion = assertThrows(IllegalArgumentException.class, () -> {
			banco.Deposito(-100.0);
		});
		assertEquals("El monto debe de ser positivo", excepcion.getMessage());
	}

	@Test
	void testRetiro() {
		banco.retirar(200.0);
		assertEquals(800.0, banco.getBaleance(), "El saldo después del retiro debe ser 800.0");
	}

	@Test
	void testRetiroInsuficiente() {
		Exception excepcion = assertThrows(IllegalArgumentException.class, () -> {
			banco.retirar(1200.0);
		});
		assertEquals("Fondos insuficientes", excepcion.getMessage());
	}

	@Test
	void testRetiroNegativo() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			banco.retirar(-100.0);
		});
		assertEquals("El monto debe de ser positivo", exception.getMessage());
	}

	@Test
	void testSaldoInicialNegativo() {
		Exception excepcion = assertThrows(IllegalArgumentException.class, () -> {
			new Banco(-100.0);
		});
		assertEquals("El saldo inicial no puede ser negativo", excepcion.getMessage());
	}
}