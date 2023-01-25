package br.com.alura.tdd.service;
/*
 * @author allfel
 *
 * Data: 23/01/2023
 */

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class BonusServiceTest {

    private BonusService bonusService;
    private Funcionario funcionario;

    @BeforeEach
    private void inicializar(){
        bonusService = new BonusService();
        funcionario = new Funcionario("Allan", LocalDate.now(), new BigDecimal("0.00"));
    }

    @Test
    public void bonusDeveriaSerZeroParaSalarioMuitoAltoTest () {
        funcionario.setSalario(new BigDecimal("25000"));
        assertThrows(IllegalArgumentException.class, () -> bonusService.calcularBonus(funcionario));

    /*    try {
            bonusService.calcularBonus(funcionario);
            fail();
        } catch (Exception ex) {
            assertEquals("Salário muito alto para receber bônus!", ex.getMessage());
        } */
    }

    @Test
    public void bonusDeveSer10PorCentoDoSalarioTest () {
        funcionario.setSalario(new BigDecimal("2500"));
        BigDecimal bonus = bonusService.calcularBonus(funcionario);
        assertEquals(new BigDecimal("250.00"), bonus);
    }

    @Test
    public void bonusDeveSer10PorCentoParaSalarioDe10000 () {
        funcionario.setSalario(new BigDecimal("10000"));
        BigDecimal bonus = bonusService.calcularBonus(funcionario);
        assertEquals(new BigDecimal("1000.00"), bonus);
    }

}
