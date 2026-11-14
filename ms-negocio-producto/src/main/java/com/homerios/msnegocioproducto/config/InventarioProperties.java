package com.homerios.msnegocioproducto.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.Min;

/**
 * Parámetros de negocio del inventario (prefijo {@code inventario}).
 * <p>
 * Se usa una clase con setters (no un record) para que {@code /actuator/refresh}
 * pueda volver a enlazar los valores en caliente.
 */
@Validated
@ConfigurationProperties(prefix = "inventario")
public class InventarioProperties {

	/** Máximo de unidades permitidas en un solo movimiento. */
	@Min(1)
	private int maxUnidadesPorMovimiento = 1000;

	/** Si es true, se registra una advertencia cuando el stock queda bajo el mínimo. */
	private boolean alertaStockBajo = true;

	public int getMaxUnidadesPorMovimiento() {
		return maxUnidadesPorMovimiento;
	}

	public void setMaxUnidadesPorMovimiento(int maxUnidadesPorMovimiento) {
		this.maxUnidadesPorMovimiento = maxUnidadesPorMovimiento;
	}

	public boolean isAlertaStockBajo() {
		return alertaStockBajo;
	}

	public void setAlertaStockBajo(boolean alertaStockBajo) {
		this.alertaStockBajo = alertaStockBajo;
	}
}
